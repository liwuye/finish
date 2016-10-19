//��Ϣ���ͷ����

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * �û�����ClientUI
 */
public class ClientUI extends JFrame {
	JTextArea mainArea;

	JTextArea sendArea;

	ChatClient client;

	JTextField ipArea;

	JButton btnLink;

	public void setClient(ChatClient client) {
		this.client = client;
	}

	public ClientUI() {
		super("�ͻ���");
		Container contain = getContentPane();
		contain.setLayout(new BorderLayout());
		mainArea = new JTextArea();
		JScrollPane mainAreaP = new JScrollPane(mainArea);// Ϊ�ı�����ӹ�����
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		sendArea = new JTextArea(3, 8);
		JButton sendBtn = new JButton("����");
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				client.sendMsg(sendArea.getText());
				mainArea.append("���ͻ��ˡ�" + sendArea.getText() + "\n");
				sendArea.setText("");
			}
		});
		JPanel ipPanel = new JPanel();
		ipPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		ipPanel.add(new JLabel("��������"));
		ipArea = new JTextField(12);
		ipArea.setText("172.25.240.31");
		ipPanel.add(ipArea);
		btnLink = new JButton("����");
		ipPanel.add(btnLink);
		btnLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				client = new ChatClient(ipArea.getText(), 6666, ClientUI.this);// ����socket����
				ClientUI.this.setClient(client);
			}
		});
		panel.add(sendBtn, BorderLayout.EAST);
		panel.add(sendArea, BorderLayout.CENTER);
		contain.add(ipPanel, BorderLayout.NORTH);
		contain.add(mainAreaP, BorderLayout.CENTER);
		contain.add(panel, BorderLayout.SOUTH);
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		ClientUI ui = new ClientUI();
	}
}

/**
 * ͨѶ��ChatClient�����غ����ݵ���
 */
class ChatClient extends Thread {
	Socket sc;// ����sc���������������

	BufferedReader in;// ���������������������ڴ洢��������������Ϣ

	PrintWriter out;// ������ӡ�������������Ϣ�ķ���

	ClientUI ui;

	public ChatClient(String ip, int port, ClientUI ui) {// ��ʼ��ChatClient��
		this.ui = ui;
		try {
			sc = new Socket(ip, port); // ����sc, �÷�����ip�Ͷ˿�������
			System.out.println("��˳�����ӵ���������");
			out = new PrintWriter(sc.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
		} catch (Exception e) {
			System.out.println(e);
		}
		start();
	}

	public void run() { // ���ڼ����������˷���������Ϣ
		String msg = "";
		while (true) {
			try {
				msg = in.readLine();// �ӻ���������һ���ַ�����msg
			} catch (SocketException ex) {
				System.out.println(ex);
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			if (msg != null && msg.trim() != "") {// ��msg��Ϣ��Ϊ��
				System.out.println(">>" + msg);
				ui.mainArea.append(msg + "\n");// ��msg��Ϣ��ӵ��ͻ��˵��ı�������
			}
		}
	}

	public void sendMsg(String msg) {// ���ڷ�����Ϣ
		try {
			out.println("���ͻ��ˡ�" + msg);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
