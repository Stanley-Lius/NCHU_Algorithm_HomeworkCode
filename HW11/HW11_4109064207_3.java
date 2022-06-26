package algHW;



public class HW11_4109064207_3 extends SunMoonLake{
	public int find_num(int i,int j,int max)
	{
		return (i-1)*max+(j-1);
	}
	
	public int[] find_original(int num,int h) {
		int[] ori = {0,0};
		ori[0] = 1+num/h;
		ori[1] = 1+num%h;
		return ori;
	}

	
	public class Edge_4109064207 
	{
		private final int v;
		public final int v_value;
		private final int w;
		public final int w_value;
		private final int vw_weight;
		private final int wv_weight;
		
		public Edge_4109064207(int v,int w,int v_value,int w_value)
		{
			this.v = v;
			this.w = w;
			this.v_value = v_value;
			this.w_value = w_value;
			this.vw_weight = v_value - w_value;
			this.wv_weight = w_value - v_value;
		}
		
		public int weight(int vertex)
		{
			if(vertex==v)
				return vw_weight;
			else if(vertex==w)
				return wv_weight;
			return -1;
		}
		
		public int either()
		{
			return v;
		}
		
		public int other(int vertex)
		{
			if		(vertex==v) return w;
			else if	(vertex==w) return v;
			return -1;
		}
		
		public String toString()
		{
			return String.format("%d-%d %d %d", v,w,vw_weight,wv_weight);
		}
	}
	
	public class EdgeWeightedGraph
	{
		private final int V;
		private int E;
		private  Edge_4109064207[][] adj;
		
		public EdgeWeightedGraph(int V)
		{ 
			this.V = V;
			this.E = 0;
			this.adj = new Edge_4109064207[V][4];
			for(int i=0;i<V;i++) {
				adj[i][0] = new Edge_4109064207(-2,0,0,0);
				adj[i][1] = new Edge_4109064207(-2,0,0,0);
				adj[i][2] = new Edge_4109064207(-2,0,0,0);
				adj[i][3] = new Edge_4109064207(-2,0,0,0);
			}
		}
		
		public int V() {	return V;	};
		public int E() {	return E;	};
		
		
		public  void addEdge(Edge_4109064207 e)
		{
			int v = e.either();
			for(int i=0;i<4;i++) {
				if(adj[v][i].v==-2) {
					adj[v][i] = e;
					i=4;
				}
			}
			
			E++;
		}
		
		public Edge_4109064207[] adj(int v)
		{
			return adj[v];
		}
	}
	public int count_water_volume(int[][] heights) {
		int l = heights.length;
		int max = heights[0].length;
		int[][] big_lake = new int[l+2][max+2];
		int space = l*max;
		EdgeWeightedGraph g = new EdgeWeightedGraph(space+1);
		for(int i =0 ;i<=l+1;i++) {
			for(int j=0;j<=max+1;j++) {
				if(j==0 | i==0 | i == l+1 | j==max+1) {
					big_lake[i][j] = -1;
				}
				else {
					big_lake[i][j] = heights[i-1][j-1];
				}
			}
		}
		
		for(int i=1;i<l+1;i++) {
			for(int j=1;j<max+1;j++) {
				int num = big_lake[i][j]!=-1?find_num(i,j,max):space;
				int up_num = big_lake[i-1][j]!=-1?find_num(i-1,j,max):space;
				int down_num = big_lake[i+1][j]!=-1?find_num(i+1,j,max):space;
				int left_num = big_lake[i][j-1]!=-1?find_num(i,j-1,max):space;
				int right_num = big_lake[i][j+1]!=-1?find_num(i,j+1,max):space;
				Edge_4109064207 e0 = new Edge_4109064207(num,up_num,big_lake[i][j],big_lake[i-1][j]);
				Edge_4109064207 e1 = new Edge_4109064207(num,down_num,big_lake[i][j],big_lake[i+1][j]);
				Edge_4109064207 e2 = new Edge_4109064207(num,left_num,big_lake[i][j],big_lake[i][j-1]);
				Edge_4109064207 e3 = new Edge_4109064207(num,right_num,big_lake[i][j],big_lake[i][j+1]);
				g.addEdge(e0);
				g.addEdge(e1);
				g.addEdge(e2);
				g.addEdge(e3);
			}
		}
		
		find_lake ans = new find_lake(g,big_lake);
		
		return ans.total;
		
	}
	
	public class find_lake
	{
		private boolean[] marked;
		private int[][] s;
		private int[] lake ;
		private int min_mountain=10000;
		public int total = 0;
		
		public find_lake(EdgeWeightedGraph g,int[][] sourse)
		{
			marked = new boolean[g.V()];
			s = sourse;
			int m = s[0].length;
			lake = new int[g.V()];
			for(int i=1;i<s.length-1;i++) {
				for(int j=1;j<s[0].length-1;j++) {
					int num = find_num(i,j,m-2);
					if(marked[num]==true) continue;
					else
					{
						marked[num] = true;

						boolean ans=find(g,num);		
						if(ans==true) {
							for(int k=0;k<g.V();k++) lake[k]=0;
							continue;
						}
						else {
							for(int k=0;k<g.V();k++) {
								if(lake[k]==1) {
									
									int[] x = find_original(k,s[1].length-2);
									total+=(min_mountain-s[x[0]][x[1]]);
								}
								lake[k]=0;
							}
						}
						
					}
					min_mountain=10000;
				}
			}
		}
		
		private boolean find(EdgeWeightedGraph g,int s)
		{
			boolean ans=false;
			lake[s] = 1;
			for(Edge_4109064207 e : g.adj(s)) {
				if(e.other(s)==g.V()-1) {
					ans=true;
					
					return ans;
					
				}
				else if(e.vw_weight>=0) {
					ans = find(g,e.other(s));
					if(ans==true) return ans;
					else lake[e.other(s)] = 1;
					marked[s] = true;
					marked[e.other(s)] = true;
				}
				else if(e.vw_weight<0) {
					ans=false;
					if(lake[e.other(s)]==0)
						if(e.w_value<min_mountain) min_mountain = e.w_value;
					
				
				}
			}
			
			
			return ans;
		}
	}



	public static void main(String[] args) {
		final long begin = System.nanoTime();
		HW11_4109064207_3 test = new HW11_4109064207_3();
		int[][] array = {{1, 3, 2, 4, 5, 2}, {2, 1, 3, 2, 1, 4}, {2, 3, 4, 5, 7, 8}};
		int ans = test.count_water_volume(array);
		System.out.print(":))"+ans);
		final long end = System.nanoTime();
		System.out.println(end-begin);

	}

}
