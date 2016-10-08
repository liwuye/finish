package dao;

/*
 * 用户名密码登录界面，添加判断用户名和密码是否正确
 * */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class denglujiemian extends JFrame {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new denglujiemian();
    }
    public denglujiemian(){
        JFrame jf=new JFrame ();
        Container container=jf.getContentPane();
        jf.setBounds(300,200,300,180);
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
        JButton jb2=new JButton("取消");
        jb2.setBounds(170,90,80,30);
        container.add(jb1);
        container.add(jb2);
        
        jf.setVisible(true);
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //设置监听
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(name.getText().trim().equals("admin")&&password.getText().trim().equals("123456")){
                    JOptionPane.showMessageDialog(null,"登录成功");
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