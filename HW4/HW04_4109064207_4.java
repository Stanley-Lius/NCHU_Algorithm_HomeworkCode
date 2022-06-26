package algHW;

public class HW04_4109064207_4 extends One_0k_rock{
	public HW04_4109064207_4() {
		
	}
	public boolean[] one0k(String[] str) {
		int l = str.length;
		boolean[] ans = new boolean[l];
		for(int i=0;i<l;i++) {
			int ln=str[i].length();
			if(ln%2==1) {
				ans[i] = false;
			}
			else {
				int j =0;
				do {
					if(j<ln/2) {
						Character ze = str[i].charAt(j);
						ans[i] = ze.equals((char)48);
					}
					else if(j>=ln/2 && j<ln) {
						Character ze = str[i].charAt(j);
						ans[i] = ze.equals((char)49);
					}
					
					j++;
				}while(ans[i]!=false &&j<ln);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		final long begin = System.nanoTime();
		HW04_4109064207_4 test = new HW04_4109064207_4();
		String[] str = {"000111","000111","10","1011001","1000111","1111000","00001111","01","000000111111","00001101","0010010101","000000","111111","0","1","00","0000000000","10000111","000000111111","100000111111"};
		boolean[] ans = test.one0k(str);
		for(int i=0;i<ans.length;i++) {
			System.out.printf("%b\n", ans[i]);
		}
		final long end = System.nanoTime();
		System.out.printf("used time : %d", end - begin);

	}

}
