package algHW;

import java.util.Collections;
import java.util.ArrayList;

public class HW09_410964207_1 extends LSD{
	
	public int Distance(int[][] arr) {
		int lsd = 0;
		
		
		
		return lsd;
	}
	
	public class Graph{
		private final int V;
		private int E;
		private ArrayList<ArrayList<Integer>> adj;
		
		public Graph(int V) {
			this.V = V;
			adj = new ArrayList<>(V);
			
			for(int i=0;i<V;i++) {
				adj.add(new ArrayList<Integer>());
			}
		}
		
		/*public Graph(int in) {
			
		}*/
		
	}
	class Sortbyroll implements Comparator<ArrayList<Integer>> {
		public int compare(ArrayList<Integer> a,ArrayList<Integer> b) {
			int a_num = a.get(0);
			int b_num = b.get(0);
			if(a_num >b_num) {
				return 1;
			}
			if(a_num ==b_num) {
				return 0;
			}
			if(a_num <b_num) {
				return -1;
			}
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Integer>> arr= new ArrayList<ArrayList<Integer>>(1000000);
		
		for(int i =0;i<1000000;i++) {
			arr.add(new ArrayList<Integer>(2));
			ArrayList<Integer> hi = arr.get(i);
			int num = (int)(Math.random()*1000);
			hi.add(0,num);
			num = (int)(Math.random()*1000);
			hi.add(1,num) ;
			System.out.printf("[ %d, %d]\n", hi.get(0),hi.get(1));
		}
		
		for(int i=0;i<1000000;i++) {
			Collections.sort(arr.get(i));
			System.out.printf("[ %d, %d]\n", arr.get(i).get(0),arr.get(i).get(1));
		}
		
		Collections.sort(arr,new Comparator<ArrayList<Integer>>()){
			@Override
			public int compare(ArrayList<Integer>> a,ArrayList<Integer> b) {
				return a.get(0) - b.get(1);
			}
		}
		
	}

}
