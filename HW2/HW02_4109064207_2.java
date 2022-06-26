package algHW;

import java.util.Arrays;
public class HW02_4109064207_2 extends ThreeSum{
	public HW02_4109064207_2() {
	}
	public int T_sum(int[] A) {
		int tol = 0,i=0,right,left,sum;
		Arrays.sort(A);
		int lg = A.length;
		do {
			right = i+1;
			left = lg-1;
			while(right<left) {
				sum = A[right] + A[left]+A[i];
				if(sum == 0) {
					tol+=1;
					left--;
					right++;
					
				}
				else if(sum<0) {
					right++;
				}
				else {
					left--;
				}
			}
		} while(i++!=(lg-3));
		return tol;
	}

	public static void main(String[] args) {
		final long startTime = System.nanoTime();
		int []a = {-1,5,6,-7,9,-4,-100,50,49,-101,96,4,-6,-7,77,-99,66,547,258,659,96,-24,-26,25,23,931,85,-100};
		HW02_4109064207_2 test = new HW02_4109064207_2();
        System.out.printf("%d\n", test.T_sum(a));
        final long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime));
        
	}

}
