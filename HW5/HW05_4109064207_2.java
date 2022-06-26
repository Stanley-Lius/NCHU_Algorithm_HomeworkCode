package algHW;


public class HW05_4109064207_2 extends LLK{

	public HW05_4109064207_2() {
	}
	public boolean checkLLK(int[][] array) {
		try {
			throw new TryException(array);
		}catch(TryException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void main(String[] args) {
		HW05_4109064207_2 test = new HW05_4109064207_2();
		int[][] array = {{0,0},{1,0},{1,1},{0,1}};
		test.checkLLK(array);
	}

}

class TryException extends Exception{
	int[][] arr1;
	String fin ="" ;
	public  TryException() {
		super();
	}
	public TryException(int[][] arr) {
		arr1 = arr;
		int l = arr.length;
		for(int i=0;i<l;i++) {
			System.out.print("["+arr[i][0]+","+arr[i][1]+"]"+",");
			fin = fin + "[" + arr[i][0] + ","+arr[i][1]+"]"+",";
		}
		
	}
	public String toString(){
		
		return ("test_data:"+fin);
	}
}
