
package algHW;


public class HW11_4109064207_4 extends SunMoonLake{
	
	@Override
	 public int count_water_volume(int[][] heights) {
	  
	  
	  int row = heights.length;
	  int col = heights[0].length;
	  int[][] volume = new int[row][col];

	  int i = 0;int j;
	  while ( i < row ) {
	   j = 0;
	   while ( j < col) {
	    volume[i][j] = heights[i][j++];
	   }
	   i++;
	  }
	  
	  boolean update = true;
	  boolean init = true;
	  int round = 0;
	  while (update) {
	   round++;
	   
	   update = false;
	   i = 1;
	   while (i < row - 1 ) {
	    j = 1;
	    while ( j < col - 1 ) {
	     int val = Math.max(heights[i][j], Math.min(volume[i - 1][j], volume[i][j - 1]));
	     
	     if (init || val < volume[i][j]) {
	      volume[i][j] = val;
	      update = true;
	      
	     }
	     j++;
	    }
	    i++;
	   }
	   init = false;
	   i = row - 2;
	   while (  i >= 1 ) {
	    j = col - 2;
	    while( j >= 1 ) {
	     int val = Math.max(heights[i][j], Math.min(volume[i + 1][j], volume[i][j + 1]));
	     
	     if (val < volume[i][j]) {
	      volume[i][j] = val;
	      update = true;
	      
	     }
	     j--;
	    }
	    i--;
	   }
	  }
	  
	  
	  
	  int sum = 0;i = 0;
	  while ( i < row ) {
	   j = 0;
	   while ( j < col ) {
	    if (volume[i][j] - heights[i][j] > 0) {
	     sum +=  volume[i][j] - heights[i][j];
	     
	    }j++;
	   }
	   i++;
	  }

	  return sum;
	    }
	



	public static void main(String[] args) {
		final long begin = System.nanoTime();
		HW11_4109064207_4 test = new HW11_4109064207_4();
		int[][] array = {{1, 3, 2, 4, 5, 2}, {2, 1, 3, 2, 1, 4}, {2, 3, 4, 5, 7, 8}};
		int ans = test.count_water_volume(array);
		System.out.print(":))"+ans);
		final long end = System.nanoTime();
		System.out.println(end-begin);

	}

}
