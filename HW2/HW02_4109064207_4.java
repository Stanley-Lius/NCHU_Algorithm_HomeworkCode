package algHW;

import java.util.Arrays;

public class HW02_4109064207_4 extends ThreeSum{
	public HW02_4109064207_4() {
	}
	public int T_sum(int[] A) {
		Arrays.sort(A);
		int l = A.length;
		int count=0,left,right,sum;
		for(int i=0;A[i]<0;i++) {
			left = i+1;
			right = l-1;
			while(left<right  && A[right]>0) {
				sum = A[i]+A[left]+A[right];
				if(sum==0) {
					count+=1;
					left+=1;
					right-=1;
				}
				else if(sum<0) {
					left+=1;
				}
				else {
					right-=1;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		final long begin = System.nanoTime();
		int[] a = {-1,5,6,-7,9,-4,-100,50,49,-101,96,4,-6,-7,77,-99,66,547,258,659,96,-24,-26,25,23,931,85,-100};
		HW02_4109064207_4 test = new HW02_4109064207_4();
		System.out.printf("%d\n", test.T_sum(a));
		final long end = System.nanoTime();
		System.out.printf("%d", end-begin);
		}

}
