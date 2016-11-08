import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
 
public class FrameDemo1 extends JFrame {

    public FrameDemo1() {
    	String IP = javax.swing.JOptionPane.showInputDialog(null,"请输入主机的电脑的IP");
    	
        setTitle("学生端");//设置窗口标题
        setSize(400, 100);//设置窗口大小
        setLocationRelativeTo(null);//设置窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置关闭时退出虚拟机
        getContentPane().setLayout(new FlowLayout());//设置窗口布局为流式布局
        JPanel jp = new JPanel(new FlowLayout());//设置jp面板为表格布局4行2列
        
        ImageIcon icon = new ImageIcon("C://Users//Administrator//Desktop//web远程桌面//setting.jpg");
        JButton jb_set=new JButton(new ImageIcon("C://Users//Administrator//Desktop//web远程桌面//setting.jpg"));
        jb_set.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        
        
        /*JButton b = new JButton();
        b.setIcon(new ImageIcon("C://Users//Administrator//Desktop//web远程桌面//setting.jpg"));//f://1.jpg
        */
        /*j.add(b);
        j.setSize(300, 200);
        j.setVisible(true);*/
        
        JButton A = new JButton("文件传输");
        A.setBounds(10, 10, 50, 50);
        jp.add(A);
        JButton B = new JButton("消息传输");
        B.setBounds(10, 10, 50, 50);
        jp.add(B);
        //JButton C = new JButton("远程监控");
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
        		SvrCom server = new SvrCom(ui);// 创建并启动网络通讯线程，准备接受客户端数据包
        		ui.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        });
        /*C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new jiankong();
                ServerGUI sendOrder=new ServerGUI("172.25.240.31", "实时操控");//被监控电脑的ip地址
                WriteGUI catchScreen=new WriteGUI(sendOrder);
                catchScreen.changePort(30009);//现在可以修改获取主机屏幕信息要访问的端口号
                new Thread(catchScreen).start();//启动线程
            }
        });*/
        
        getContentPane().add(jp);

    }
 

}