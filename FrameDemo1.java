import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
 
public class FrameDemo1 extends JFrame {

    public FrameDemo1() {
    	String IP = javax.swing.JOptionPane.showInputDialog(null,"�����������ĵ��Ե�IP");
    	
        setTitle("ѧ����");//���ô��ڱ���
        setSize(400, 100);//���ô��ڴ�С
        setLocationRelativeTo(null);//���ô��ھ���
        setDefaultCloseOperation(EXIT_ON_CLOSE);//���ùر�ʱ�˳������
        getContentPane().setLayout(new FlowLayout());//���ô��ڲ���Ϊ��ʽ����
        JPanel jp = new JPanel(new FlowLayout());//����jp���Ϊ��񲼾�4��2��
        
        ImageIcon icon = new ImageIcon("C://Users//Administrator//Desktop//webԶ������//setting.jpg");
        JButton jb_set=new JButton(new ImageIcon("C://Users//Administrator//Desktop//webԶ������//setting.jpg"));
        jb_set.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        
        
        /*JButton b = new JButton();
        b.setIcon(new ImageIcon("C://Users//Administrator//Desktop//webԶ������//setting.jpg"));//f://1.jpg
        */
        /*j.add(b);
        j.setSize(300, 200);
        j.setVisible(true);*/
        
        JButton A = new JButton("�ļ�����");
        A.setBounds(10, 10, 50, 50);
        jp.add(A);
        JButton B = new JButton("��Ϣ����");
        B.setBounds(10, 10, 50, 50);
        jp.add(B);
        //JButton C = new JButton("Զ�̼��");
        //C.setBounds(10, 10, 50, 50);
        //jp.add(C);
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new BxServerSocket();
					new BxClient(IP);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		ServerUI ui = new ServerUI();
        		SvrCom server = new SvrCom(ui);// ��������������ͨѶ�̣߳�׼�����ܿͻ������ݰ�
        		ui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });
        /*C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new jiankong();
                ServerGUI sendOrder=new ServerGUI("172.25.240.31", "ʵʱ�ٿ�");//����ص��Ե�ip��ַ
                WriteGUI catchScreen=new WriteGUI(sendOrder);
                catchScreen.changePort(30009);//���ڿ����޸Ļ�ȡ������Ļ��ϢҪ���ʵĶ˿ں�
                new Thread(catchScreen).start();//�����߳�
            }
        });*/
        
        getContentPane().add(jp);

    }
 

}