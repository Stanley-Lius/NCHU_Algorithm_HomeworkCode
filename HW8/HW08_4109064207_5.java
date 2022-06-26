package algHW;

public class HW08_4109064207_5 extends Buy_Phone_v2{

	
	public int[][] bestPhone(int[][] inputArr){
		int l = inputArr.length;

		int[][] fi = sort_4109064207(inputArr,l);
		
	
		
		return fi;
	}

	
	 static int[][] sort_4109064207(int[][] input,int ln){
		
		int[][] aux = new int[ln][6];
		for(int d = 5;d>=0;d--) {
			int[] count = new int[1024];
			int l = input.length;
			for(int i=0;i<l;i++) {
				count[input[i][d]+1]++;
			}
			
			for(int r=0;r<1022;r++) {
				count[r+1]+=count[r];
			}
			
			for(int i=0;i<l;i++) {
				aux[count[input[i][d]]++] = input[i];
			}
			for(int i=0;i<l;i++) {
				input[i] = aux[i];
				
			}
			input = find_4109064207(input,l);
		}
		
		return input;
	}
	
	 static int[][] find_4109064207(int[][] input,int l){
		int count = 0;
		int[][] pre_ans = new int[l][6];
		int[] test = input[l-1];
		pre_ans[count++] = test;
		for(int i =l-2;i>=0;i--) {
			int[] fight = input[i];
			for(int j=0;j<6;j++) {
				if(fight[j] > test[j]) {
					pre_ans[count++] = fight;
					j=6;
					test = fight;
				}
			}
		
		}
		int [][] ans = new int[count][6];
		
		for(int i=0;i<count;i++) {
			ans[i] = pre_ans[i];
		}
		
		return ans;
		
	}
	


}
