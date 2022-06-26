package algHW;

public class HW05_4109064207_1 extends LLK{
	
	public HW05_4109064207_1(){
	}
	public boolean checkLLK(int[][] array) {
		int l = array.length;
		
		boolean ans = false;
		for(int i=0;i<l;i++) {//�Ĥ@���I
			
			double[] slope = new double[l-i-1];//�x�s�ײv���}�C
			for(int r =0;r<l-i-1;r++) {
				slope[r] = r+1-i*r/l;//�]���t�ιw�]����0�A���üơA�קK�]���ײv��0�ҳy�����~�P
			}
			for(int j=i+1;j<l;j++) {//�ĤG���I
				double a = array[i][0]-array[j][0];//X�y�Ь۴�
				double b = array[i][1]-array[j][1];//y�y�Ь۴�
				double fin = 0;
				if(a==0) {//�p�G�������s�A���F�ϧO�A�NX�y�а��H(10)��(X�y�Цr��ƫ᪺����)����
					String A = Integer.toString(array[i][0]);
					double ln = A.length();
					double S = array[i][0]/Math.pow(10, ln+1);
					fin =S;
				}
				else {//���������ª�����
					double S = b/a;
					fin = S;
				}
				for(int k =0;k<j-1 && k<slope.length;++k) {//����ײv
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
