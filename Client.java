//��½����
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
        jf.setTitle("����˵�¼");
        container.setLayout(null);
        
        JLabel jl1=new JLabel("�û���");
        jl1.setBounds(10,10, 50, 20);
        //JTextArea name=new JTextArea();//TextArea���Զ��У�������ӹ�����
        final JTextField name=new JTextField();//TextFieldֻ��һ�п�д
        name.setBounds(80,10,150,20);
        JLabel jl2=new JLabel("����");
        jl2.setBounds(10,50,50,20);
        final JPasswordField password=new JPasswordField();
        password.setBounds(80,50,150,20);
        container.add(jl1);
        container.add(name);
        container.add(jl2);
        container.add(password);
        
        JButton jb1=new JButton("ȷ��");
        jb1.setBounds(40,90,80,30);
        JButton jb2=new JButton("����");
        jb2.setBounds(170,90,80,30);
        container.add(jb1);
        container.add(jb2);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //���ü���
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(name.getText().trim().equals("admin")&&password.getText().trim().equals("123456")){
                	JOptionPane.showMessageDialog(null,"��¼�ɹ�");
                	jf.setVisible(false);
                	new FrameDemo().setVisible(true);

                }
                else if(name.getText().trim().equals("14251104207")&&password.getText().trim().equals("123456")){
                	JOptionPane.showMessageDialog(null,"��¼�ɹ�");
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
                    JOptionPane.showMessageDialog(null,"�û��������벻��Ϊ�գ�");
                }else{
                    JOptionPane.showMessageDialog(null,"�û������������");
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