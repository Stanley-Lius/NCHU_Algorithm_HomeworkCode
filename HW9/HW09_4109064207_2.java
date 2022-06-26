package algHW;

import java.util.Stack;
import java.util.ArrayList;

public class HW09_4109064207_2 extends LSD{
	
	public int Distance(int[][] arr) {
		int v = 0;
		int e = arr.length;
		
		Graph_4109064207 g = new Graph_4109064207(e,arr);
		for(int i=0;i<e;i++) {
			g.addEdge(arr[i][0], arr[i][1]);
		}
		v = g.V();
		int max= 0;
		for(int i=0;i<g.p;i++) {
			
			int j = g.pair.get(i)[0];
			int r = g.pair.get(i)[1];
			
			BFS_4109064207 n = new BFS_4109064207(g,r);

			for(int h=i+2;h<g.p;h++) {
				int f = g.pair.get(h)[1];
				Stack<Integer> pa = new Stack<Integer>();
				pa = n.PathTo(f);
 				if(!(pa==null)) max = pa.size()>max?pa.size():max;
			}
		}
		return max;
	}
	
	public class Graph_4109064207{
		private  int V;
		private int E;
		private ArrayList<ArrayList<Integer>> adj;
		public int p=0;
		public ArrayList<Integer[]> pair;
		public int max=0;
		
		public Graph_4109064207(int E,int[][] arr) {
			this.V = 0;
			adj = new ArrayList<>();
			pair = new ArrayList<>();
		}
		
		public int V() { return V;}
		
		public int E() { return E; }
		
		public void addEdge(int v,int w) {
			max = v>max?v:max;
			max = w>max?w:max;
			int t = 0;
			int s = 0;
			for(int i=0;i<p;i++) {
				int a = pair.get(i)[1];
				if(a == v) {
					adj.get(pair.get(i)[0]).add(w);
					t = 1;
				}
				else if(a==w) {
					adj.get(pair.get(i)[0]).add(v);
					s = 1;
				}
			}
			if(t==0 && s ==1) {
				adj.add(new ArrayList<Integer>());
				Integer[] now = {p++,v};
				pair.add(now);
				adj.get(p-1).add(w);
				V++;
			}
			else if(s==0 && t==1) {
				adj.add(new ArrayList<Integer>());
				Integer[] now_1 = {p++,w};
				pair.add(now_1);
				adj.get(p-1).add(v);
				V++;
			}
			else if(s==0 && t==0){
				adj.add(new ArrayList<Integer>());
				Integer[] now = {p++,v};
				pair.add(now);
				adj.get(p-1).add(w);
				adj.add(new ArrayList<Integer>());
				Integer[] now_1 = {p++,w};
				pair.add(now_1);
				adj.get(p-1).add(v);
				V+=2;
			}
			E++;
		}
		
		public int[] adj(int v){
			int pos=0;
			for(int i=0;i<p;i++) {
				int j = pair.get(i)[1];
				
				if(j==v) {
					pos = pair.get(i)[0];
					i=p;
				}
			}
			int l =adj.get(pos).size();
			int[] ans = new int[l];
			for(int i=0;i<l;i++) {
				ans[i] = adj.get(pos).get(i);
			}
			return ans;
		}
		
		public int adj_length(int v) {
			int pos=0;
			for(int i=0;i<p;i++) {
				int j = pair.get(i)[1];
				
				if(j==v) {
					pos = pair.get(i)[0];
					i=p;
				}
			}
			
			return adj.get(pos).size();
		}
		
	}

	public class BFS_4109064207{
		private boolean[] marked;
		private int[] edgeTo;
		private final int s;
		
		public BFS_4109064207(Graph_4109064207 G,int s) {
			marked = new boolean[G.max+1];
			edgeTo =new int[G.max+1];
			this.s = s;
			bfs(G,s);
		}
		private void bfs(Graph_4109064207 G,int s) {
			ArrayList<Integer> arraylist = new ArrayList<Integer>();
			marked[s]= true;
			arraylist.add(s);
			while(!arraylist.isEmpty()) {
				int v = arraylist.get(0);
				arraylist.remove(0);
				int[] list = G.adj(v);
				for(int i=0;i<list.length;i++) {
					
					int w= list[i];
					if(!marked[w]) {
						edgeTo[w] = v;
						marked[w] = true;
						arraylist.add(w);
					}
				}
			}
		}
		public boolean hasPathTo(int v) {
			return marked[v];
		}
		public Stack<Integer> PathTo(int v){
			if(!hasPathTo(v)) return null;
			Stack<Integer> path = new Stack<Integer>();
			for(int x=v;x!=s;x=edgeTo[x]) {
				path.push(x);
				
			}
			path.push(s);
			return path;
		}
	}
	

	public static void main(String[] args) {
		int[][] array =new  int[10][2];
		
		int[][] arr = {{0,1},{0,2},{0,4},{1,3},{1,4},{2,5},{6,7}};

		for(int i =0;i<10;i++) {
			
			int num = (int)(Math.random()*10);
			array[i][0] = num;
			
			num = (int)(Math.random()*10);
			
			array[i][1] = num;
		}
		HW09_4109064207_2 test = new HW09_4109064207_2();
		int ans = test.Distance(arr);
		System.out.print(ans);
	}

}
