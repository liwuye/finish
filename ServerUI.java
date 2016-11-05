//��Ϣ���Ϳͻ���
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * ����˽���ServerUI
 */
public class ServerUI extends JFrame {
	JTextArea mainArea;

	JTextArea sendArea;

	JTextField indexArea;

	SvrCom server;

	public void setServer(SvrCom server) {
		this.server = server;
	}

	public ServerUI() {
		super("ѧ����");
		Container contain = getContentPane();
		contain.setLayout(new BorderLayout());
		mainArea = new JTextArea();
		JScrollPane mainAreaP = new JScrollPane(mainArea);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		sendArea = new JTextArea(3, 8);
		JButton sendBtn = new JButton("����");
		sendBtn.addActionListener(new ActionListener()// ע�ᶯ��������
				{
					public void actionPerformed(ActionEvent ae) {
						server.sendMsg(sendArea.getText());// ����Ϣ���ݵ���ʦ��
						mainArea.append("��ѧ���ˡ�" + sendArea.getText() + "\n");// ����Ϣ��ʾ�ڷ������������¼����
						sendArea.setText("");
					}
				});
		JPanel tmpPanel = new JPanel();
		//indexArea = new JTextField(2);
		//indexArea.setText("0");
		tmpPanel.add(sendBtn);
		//tmpPanel.add(indexArea);
		panel.add(tmpPanel, BorderLayout.EAST);
		panel.add(sendArea, BorderLayout.CENTER);
		contain.add(mainAreaP, BorderLayout.CENTER);
		contain.add(panel, BorderLayout.SOUTH);
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}

/**
 * ͨѶ��SvrCom�����غ����ݵ���
 */
class SvrCom extends Thread// ����ͨѶ��
{
	Socket client;

	ServerSocket soc;

	BufferedReader in;

	PrintWriter out;

	ServerUI ui;

	// ChatServer server;

	public SvrCom(ServerUI ui) { // ��ʼ��SvrCom��
		this.ui = ui;
		ui.setServer(this);
		try {
			soc = new ServerSocket(6666); // ����������˿�6666
			System.out.println("�����������ɹ����ȴ��˿ںţ�6666");
			client = soc.accept();// ���ͻ�����������ʱ������һ������
			System.out.println("���ӳɹ�������" + client.toString());
			in = new BufferedReader(new InputStreamReader(client
					.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		start();
	}

	public void run() {// ���ڼ����ͻ��˷���������Ϣ
		String msg = "";
		while (true) {
			try {
				msg = in.readLine();// ��in�����϶�������Ϣ
			} catch (SocketException ex) {
				System.out.println(ex);
				break;
			} catch (Exception ex) {
				System.out.println(ex);
			}
			if (msg != null && msg.trim() != "") {
				System.out.println(">>" + msg);
				ui.mainArea.append(msg + "\n");
			}
		}
	}

	public void sendMsg(String msg) {// ���ڷ�����Ϣ
		try {
			out.println("��ѧ���ˡ�" + msg);// ����Ϣд�������
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}