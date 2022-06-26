package algHW;

public class HW07_4109064207_2 extends Buy_Phone{
	
	public HW07_4109064207_2() {
		
	}
	
	public int [][] bestPhone(int[][] inputArr){
		cellphone [] cellphones = new cellphone[inputArr.length];
		for(int i=0;i<inputArr.length;i++) {
			cellphone n  = new cellphone(inputArr[i][0],inputArr[i][1]);
			cellphones[i] = n;
		}
		
	}
	public static class cellphone {
		public int first;
		public int second;
		private int ans;
		public cellphone(int item1,int item2) {
			this.first = item1;
			this.second = item2;
		}
		public boolean cal(int mode) {
			if(mode==1) {
				return 
			}
		}
		public int getans() {
			return ans;
		}
	}

	public static void main(String[] args) {
		HW07_4109064207_2 test = new HW07_4109064207_2();

	}

}
