import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
 
public class FrameDemo extends JFrame {
    //申明需要的组件
    private final JTextField jtf1,jtf2,jtf3;
    private final JTextArea jta;
 
    public FrameDemo() {
        setTitle("Information");//设置窗口标题
        setSize(1000, 600);//设置窗口大小
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
        JButton C = new JButton("远程监控");
        C.setBounds(10, 10, 50, 50);
        jp.add(C);
        A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					new BxClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientUI();
            }
        });
        C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*methodA();
                methodB();*/
            }
        });
        
        //第一行
        JPanel jp01 = new JPanel();
        JLabel jl1 = new JLabel("Name:");
        jp01.add(jl1);
        JPanel jp1 = new JPanel();
        jtf1 = new JTextField(8);
        jp1.add(jtf1);
        //第二行
        JPanel jp02 = new JPanel();
        JLabel jl2 = new JLabel("Number:");
        jp02.add(jl2);
        JPanel jp2 = new JPanel();
        jtf2 = new JTextField(8);
        jp2.add(jtf2);
        //第三行
        JPanel jp03 = new JPanel();
        JLabel jl3 = new JLabel("Class:");
        jp03.add(jl3);
        JPanel jp3 = new JPanel();
        jtf3 = new JTextField(8);
        jp3.add(jtf3);
        //第四行
        JPanel jp04 = new JPanel();
        JLabel jl4 = new JLabel("");
        jp04.add(jl4);
        JPanel jp4 = new JPanel();
        JButton jb = new JButton("确认");
        jp4.add(jb);
         
        /*jb_set.setBounds(10, 10, 50, 50);
        b.setBounds(1, 1, 1, 1);
        jp.add(jb_set);*/
        
        
        //jp.add(b);
        /*jp.add(jp01);
        jp.add(jp1);
        jp.add(jp02);
        jp.add(jp2);
        jp.add(jp03);
        jp.add(jp3);
        jp.add(jp04);
        jp.add(jp4);*/
        getContentPane().add(jp);
        jta = new JTextArea();
        jta.setColumns(20);//设置文本域的大小
        jta.setEditable(false);//设置文本域不可编辑
        jta.setBackground(jp.getBackground());//设置文本域的背景色和面板一样
        getContentPane().add(jta);
         
        jb.addActionListener(new ActionListener() {//给按钮添加事件
             
            public void actionPerformed(ActionEvent e) {//点击按钮,显示信息到文本域
                String name = jtf1.getText();
                String number = jtf2.getText();
                String clazz = jtf3.getText();
                jta.setText("You name is "+name+" number is "+number+" class is "+clazz);
            }
        });
    }
 
    public static void main(String[] args) {
        new FrameDemo().setVisible(true);//创建窗口,被设置为可见
    }
}