package algHW;


public class HW06_4109064207_1 extends MedianOfArrays{
	public HW06_4109064207_1() {
		
	}
	
	public double find_median(int[][] arrays) {
		int ln = 0;
		double  ans;
		for(int i=0;i<arrays.length;i++) {
			ln += arrays[i].length;
		}
		int[] arr = new int[ln];
		int index = 0;
		for(int j=0;j<arrays.length;j++) {
			int begin = index;
			for(int k=0;k<arrays[j].length;k++) {
				arr[index] = arrays[j][k];
				
				index++;
				
			}
			if(begin!=index-1) {
				sort_arrays s = new sort_arrays();
				arr = s.sort(arr,begin, index-1);
				for(int f=0;f<ln;f++) {
					
				}
				
			}
			
		}
		if(ln%2==0) {
			ans = (arr[ln/2-1]+arr[ln/2])/2;
		}
		else {
			ans = arr[ln/2];
		}
		return ans;
	}
	public class sort_arrays {
		    public int[] sort(int[] arr,int begin,int index) {
			int[] aux = new int[index+1];
			int i =0,j=begin;
			
			for(int k = 0;k<=index;k++) {
				aux[k]=arr[k];
			}
			
			for(int k=0;k<=index;k++) {
				if		(i>begin-1)		arr[k] = aux[j++];
				else if (j>index)		arr[k] = aux[i++];
				else if (aux[j]<aux[i]) arr[k] = aux[j++];
				else					arr[k] = aux[i++];
			}
			return arr;
		}
	}
	public static void main(String[] args) {
		final long begin = System.nanoTime();
		HW06_4109064207_1 test = new HW06_4109064207_1();
		int [][] arr = {{5},{1,5,6,8,99},{5,6,7,8,77,99},{1,4,5,7,8,66}};
	    double answer =	test.find_median(arr);
	    System.out.println("Answer is :"+answer);
	    final long end = System.nanoTime();
	    System.out.println("Used time:"+(end - begin));
	}

}
