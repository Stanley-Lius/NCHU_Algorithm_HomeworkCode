package algHW;

public class HW08_4109064207_3 extends Buy_Phone_v2{

	
	public int[][] bestPhone(int[][] inputArr){
		int l = inputArr.length;
		int count=0;
		int[][] fi = sort_4109064207(inputArr,l);
		int[][] pre_ans = new int[l][6];
		int[] test = fi[l-1];
		pre_ans[count++] = test;
		for(int i =l-2;i>=0;i--) {
			int[] fight = fi[i];
			for(int j=0;j<6;j++) {
				if(fight[j] > test[j]) {
					pre_ans[count++] = fight;
					j=6;
					test = fight;
				}
			}
			
		}
		
		int[][] ans = new int[count][6];
		
		for(int i=0;i<count;i++) {
			ans[i] = pre_ans[i];
		}
		
		

		
		return ans;
	}

	
	static int[][] sort_4109064207(int[][] input,int ln){
		
		int[][] aux = new int[ln][6];
		for(int d = 5;d>=0;d--) {
			int[] count = new int[26000];
			for(int i=0;i<25999;i++) {
				count[i] = 0;
			}
			for(int i=0;i<ln;i++) {
				count[input[i][d]+1]++;
			}
			
			for(int r=0;r<25998;r++) {
				count[r+1]+=count[r];
			}
			
			for(int i=0;i<ln;i++) {
				aux[count[input[i][d]]++] = input[i];
			}
			for(int i=0;i<ln;i++) {
				input[i] = aux[i];
			}
		}
		return input;
	}

}
