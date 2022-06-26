package algHW;

public class HW04_4109064207_1 extends One_0k_rock{
    public HW04_4109064207_1() {
    }
    public boolean[] one0k(String[] str) {
    	int l = str.length,count = 0;
    	boolean[] ans= new boolean[l];
    	for(int i=0;i<l;i++) {
    		long sttr = Long.valueOf(str[i],2);
    		if((sttr & 1) ==1) {
    			count++;
    			while(((sttr>>>=1) & 1) ==1) {
    				count++;
    				
    			}
    			if(sttr!=0) {
    				ans[i] = false;
    				
    			}
    			else if(str[i].length() - count != count) {
    				ans[i] = false;
    			}
    			else ans[i] = true;
    			count =0;
    		}
    		else if((sttr & 1) ==0) {
    			ans[i] = false;
    		}
    	}
    	return ans;
    	
    }
	public static void main(String[] args) {
		final long begin = System.nanoTime();
		HW04_4109064207_1 test = new HW04_4109064207_1();
		String[] str = {"000111","000111","10","1011001","1000111","1111000","00001111","01","000000111111","00001101","0010010101","000000","111111","0","1","00","0000000000","10000111","000000111111","100000111111"};
		boolean[] ans = test.one0k(str);
		for(int i=0;i<ans.length;i++) {
			System.out.printf("%b\n", ans[i]);
		}
		final long end = System.nanoTime();
		System.out.printf("used time : %d", end - begin);

	}

}
