package algHW;
import java.util.Arrays;
public class HW02_4109064207_3 extends ThreeSum{
	
	public HW02_4109064207_3() {
	}
	
	public int T_sum(int[]A) {
		Arrays.sort(A);
		int n = A.length;
		int count = 0;
		for(int i = 0;i<n;i++) {
			for(int j=i+1;j<n;j++){
				if(Arrays.binarySearch(A, -A[i]-A[j]) >j ) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		final long startTime = System.nanoTime();
		int[] a = {99,-98,1,-100,-1,98,-99};
		HW02_4109064207_3 test = new HW02_4109064207_3();
		System.out.printf("%d\n", test.T_sum(a));
		final long endTime = System.nanoTime();
	    System.out.printf("used time:%d", endTime-startTime);

	}

}
