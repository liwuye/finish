//登陆界面
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class Client extends JFrame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Client();
    }
    public Client(){
        final JFrame jf=new JFrame ();
        Container container=jf.getContentPane();
        jf.setBounds(300,200,300,180);
        jf.setTitle("服务端登录");
        container.setLayout(null);
        
        JLabel jl1=new JLabel("用户名");
        jl1.setBounds(10,10, 50, 20);
        //JTextArea name=new JTextArea();//TextArea可以多行，可以添加滚动条
        final JTextField name=new JTextField();//TextField只有一行可写
        name.setBounds(80,10,150,20);
        JLabel jl2=new JLabel("密码");
        jl2.setBounds(10,50,50,20);
        final JPasswordField password=new JPasswordField();
        password.setBounds(80,50,150,20);
        container.add(jl1);
        container.add(name);
        container.add(jl2);
        container.add(password);
        
        JButton jb1=new JButton("确定");
        jb1.setBounds(40,90,80,30);
        JButton jb2=new JButton("重置");
        jb2.setBounds(170,90,80,30);
        container.add(jb1);
        container.add(jb2);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //设置监听
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(name.getText().trim().equals("admin")&&password.getText().trim().equals("123456")){
                	JOptionPane.showMessageDialog(null,"登录成功");
                	jf.setVisible(false);
                	new FrameDemo().setVisible(true);

                }
                else if(name.getText().trim().equals("14251104207")&&password.getText().trim().equals("123456")){
                	JOptionPane.showMessageDialog(null,"登录成功");
                	jf.setVisible(false);

                	new Server();
                	SendScreenImg sender=new SendScreenImg();
                	sender.changeServerPort(30009);
                	new Thread(sender).start();
                	OperateWindow operate=new OperateWindow();
                	new Thread(operate).start();
                	new FrameDemo1().setVisible(true);

                }
                else if(name.getText().trim().length()==0||password.getText().trim().length()==0){
                    JOptionPane.showMessageDialog(null,"用户名或密码不能为空！");
                }else{
                    JOptionPane.showMessageDialog(null,"用户名或密码错误！");
                }
                
            }

        });
        
        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                name.setText("");
                password.setText("");
            }
        });
        
    }
}