package algHW;

public class HW08_4109064207_1 extends Buy_Phone_v2{
	
	public HW08_4109064207_1() {
		
		}
	
	
	public int[][] bestPhone(int[][] inputArr){
		int l = inputArr.length;
		cellphone[]  cellphones = new cellphone[l];
		
		
		for(int i = 0;i<l;i++) {
			cellphones[i] = new cellphone(inputArr[i][0],inputArr[i][1],inputArr[i][2],inputArr[i][3],inputArr[i][4],inputArr[i][5],i);
		}

		
		

		
			
		for(int d = 5;d>=0;d--) {	
			int[] count = new int[102];
			for(int i = 0;i < l;i++) {
				count[cellphones[i].arr[d]+1]++;
			}
			for(int r = 0;r < 101;r++) {
				count[r+1] += count[r];
			}
		
			for(int i = 0;i < l;i++) {
				cellphones[i].now_pos = count[cellphones[i].arr[d]]++;
			}
		
		}
		
		int max = 0;
		for(int i = 0;i<l;i++) {
			if(cellphones[i].now_pos > cellphones[max].now_pos)
				max = i;
		}
			
		int[] time = new int[l];
		
		for(int i =1;i<l;i++) {
			for(int j = i;j>0&&(cellphones[j].now_pos>cellphones[j-1].now_pos);j--) {
				cellphone tmp = cellphone2
			}
		}
		
		for(int i=0;i<6;i++) {
			for(int j =0;j<l;j++) {
				System.out.print(cellphones[j].arr[i]+"  ");
			}
			System.out.print("\n");
		}
			

			
			
			


		
		
		
		return inputArr;
		
		
	}
	
	
	public static class cellphone {
		public int[] arr = new int[6];
		public int now_pos;
		public boolean unbeatable = false;
		public int old;
		public cellphone(int item1,int item2, int item3, int item4, int item5,int item6,int now_pos) {
			this.arr[0] = item1;
			this.arr[1] = item2;
			this.arr[2] = item3;
			this.arr[3] = item4;
			this.arr[4] = item5;
			this.arr[5]= item6;
			this.now_pos = now_pos;
		}
		public int getnumber(int d) {
			return this.arr[d];
		}
		
		public int changepos(int d) {
			this.now_pos = d;
			return this.now_pos;
		}
	}
	

	public static void main(String[] args) {
		
		HW08_4109064207_1 test = new HW08_4109064207_1();
		
		int[][] inputArr= {{8,7,7,4,2,1},{2,4,4,6,2,1},{4,0,5,1,3,2},{5,2,4,3,7,3},{7,5,6,9,8,9},{1,1,1,1,1,100},{1,1,1,1,1,100}};
		
		int[][] ans = test.bestPhone(inputArr); 
		
		
		

		
		

	}

}
