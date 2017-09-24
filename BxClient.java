
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * �ļ����Ϳͻ���������
 * @author admin_Hzw
 * 6666
 *
 */
public class BxClient {
	public BxClient(String IP) throws IOException {
		int length = 0;
		double sumL = 0 ;
		byte[] sendBytes = null;
		Socket socket = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		boolean bool = false;
		try {
			File file = new File("D:/123.zip"); //Ҫ������ļ�·��
			long l = file.length(); 
			socket = new Socket();  
			socket.connect(new InetSocketAddress(IP, 48123));
			dos = new DataOutputStream(socket.getOutputStream());
			fis = new FileInputStream(file);      
			sendBytes = new byte[1024];  
			while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
				sumL += length;  
				System.out.println("�Ѵ��䣺"+((sumL/l)*100)+"%");
				dos.write(sendBytes, 0, length);
				dos.flush();
			} 
			//��Ȼ�������Ͳ�ͬ����JAVA���Զ�ת������ͬ�������ͺ������Ƚ�
			if(sumL==l){
				bool = true;
			}
		}catch (Exception e) {
			System.out.println("�ͻ����ļ������쳣");
			bool = false;
			e.printStackTrace();  
		} finally{  
			if (dos != null)
				dos.close();
			if (fis != null)
				fis.close();   
			if (socket != null)
				socket.close();    
		}
		System.out.println(bool?"�ɹ�":"ʧ��");
	}
	
	/**
	 * ����main����
	 * @param args
	 * @throws IOException
	 */
	
	
}