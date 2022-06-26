package algHW;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HW05_4109064207_3 extends LLK{
	public HW05_4109064207_3() {
	}
	public boolean checkLLK(int[][] array) {
		try {
			throw new IPException();
		}catch ( IPException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String[] args) {
		HW05_4109064207_3 test = new HW05_4109064207_3();
		int[][] array = {{0,0},{1,0},{1,1},{0,1}};
		test.checkLLK(array);
	}

}
class IPException extends Exception {
	
	InetAddress ip;
	String hostname;
	public IPException() {
		super();
		try {
			ip = InetAddress.getLocalHost();
	        hostname = ip.getHostName();
	        System.out.print("IP:"+ip);
	        System.out.print("Hostname:"+hostname);
		}catch (UnknownHostException e) {
 
            e.printStackTrace();
        }
		
	}
	public String toString() {
		return ("IP:"+ip+","+"Hostname:"+hostname);
	}
	
	
}