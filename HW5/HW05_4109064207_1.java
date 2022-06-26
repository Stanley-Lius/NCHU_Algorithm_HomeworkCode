package algHW;

public class HW05_4109064207_1 extends LLK{
	
	public HW05_4109064207_1(){
	}
	public boolean checkLLK(int[][] array) {
		int l = array.length;
		
		boolean ans = false;
		for(int i=0;i<l;i++) {//第一個點
			
			double[] slope = new double[l-i-1];//儲存斜率的陣列
			for(int r =0;r<l-i-1;r++) {
				slope[r] = r+1-i*r/l;//因為系統預設都為0，取亂數，避免因為斜率為0所造成的誤判
			}
			for(int j=i+1;j<l;j++) {//第二個點
				double a = array[i][0]-array[j][0];//X座標相減
				double b = array[i][1]-array[j][1];//y座標相減
				double fin = 0;
				if(a==0) {//如果分母為零，為了區別，將X座標除以(10)的(X座標字串化後的長度)次方
					String A = Integer.toString(array[i][0]);
					double ln = A.length();
					double S = array[i][0]/Math.pow(10, ln+1);
					fin =S;
				}
				else {//分母不為玲直接除
					double S = b/a;
					fin = S;
				}
				for(int k =0;k<j-1 && k<slope.length;++k) {//比較斜率
					if(slope[k] ==fin ) {
						ans = true;
						break;
					}
				}
				slope[j-1-i]=fin;
				if(ans==true) break;
			}
			if(ans==true) break;
		}
		return ans;
	}

	public static void main(String[] args) {
		final long begin = System.nanoTime();
		HW05_4109064207_1 test = new HW05_4109064207_1();
		int[][] array = {{0,0},{1,1},{2,5},{2,6},{6,8},{3,7},{5,7},{45,78},{9,7},{9,45},{9,-84}};
		System.out.println(test.checkLLK(array));
		final long end = System.nanoTime();
		System.out.printf("Used time:%d\n",end-begin);
		
	}
}
