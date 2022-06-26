package algHW;



public class HW11_4109064207_1 extends SunMoonLake{
	public int find_num(int i,int j,int max)
	{
		return (i-1)*max+(j-1);
	}
	
	public int[] find_original(int num,int h) {
		int[] ori = new int[2];
		ori[0] = 1+num/h;
		ori[1] = 1+num%h;
		return ori;
	}

	
	public class Edge 
	{
		private final int v;
		public final int v_value;
		private final int w;
		public final int w_value;
		private final int vw_weight;
		private final int wv_weight;
		
		public Edge(int v,int w,int v_value,int w_value)
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
		private  Edge[] adj;
		
		public EdgeWeightedGraph(int V)
		{
			this.V = V;
			this.E = 0;
			this.adj = new Edge[V*4];
			for(int i=0;i<V*4;i++) {
				
				adj[i] = new Edge(-2,-2,-2,-1);
				System.out.println(i+"-"+"   "+adj[i]);		

			}
		}
		
		public int V() {	return V;	};
		public int E() {	return E;	};
		
		
		public  void addEdge(Edge e)
		{
			int v = e.either();
			for(int i=0;i<4;i++) {
				if(adj[v*4+i].v==-2) {
					adj[v*4+i] = e;
					System.out.printf("%s !!!! %s",adj[v].toString(),e.toString());
					i=4;
				}
			}
			
			E++;
		}
		
		public Edge adj(int v,int pos)
		{
			return adj[v*4+pos];
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
				Edge e0 = new Edge(num,up_num,big_lake[i][j],big_lake[i-1][j]);
				Edge e1 = new Edge(num,down_num,big_lake[i][j],big_lake[i+1][j]);
				Edge e2 = new Edge(num,left_num,big_lake[i][j],big_lake[i][j-1]);
				Edge e3 = new Edge(num,right_num,big_lake[i][j],big_lake[i][j+1]);
				System.out.printf("%s %s %s %s\n",e0.toString(),e1.toString(),e2.toString(),e3.toString());
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

						boolean ans=find(g,num,s[2].length-2,s);		
						if(ans==true) {
							for(int k=0;k<g.V();k++) lake[k]=0;
							continue;
						}
						else {
							for(int k=0;k<g.V();k++) {
								if(lake[k]==1) {
									
									int[] x = find_original(k,s[1].length-2);
									total+=(min_mountain-s[x[0]][x[1]]);
									System.out.print(k+"  "+min_mountain+"  "+s[x[0]][x[1]]+"   "+total+"\n");
								}
								lake[k]=0;
							}
						}
						
					}
					min_mountain=10000;
				}
			}
		}
		
		private boolean find(EdgeWeightedGraph g,int s,int h,int[][] source)
		{
			boolean ans=false;
			lake[s] = 1;
			for(int i=0;i<4;i++) {
				Edge e= g.adj(s,i);
				System.out.printf("%s ",e.toString());
				if(e.other(s)==g.V()-1) {
					ans=true;
					
					return ans;
					
				}
				else if(e.vw_weight>=0 ) {

					lake[e.other(s)] = 1;
					ans = find(g,e.other(s),h,source);
					if(ans==true) return ans;
					marked[s] = true;
					marked[e.other(s)] = true;

				}
				else if(e.vw_weight<0) {
					ans=false;
					if(e.other(s) >=0  ) {
						if(lake[e.other(s)]==0)
							if(e.w_value<min_mountain) min_mountain = e.w_value;
					}
						
					System.out.println("<<<"+min_mountain+">>>");
					
				
				}
			}
			
			
			return ans;
		}
	}



	public static void main(String[] args) {
		HW11_4109064207_1 test = new HW11_4109064207_1();
		int[][] array = {{2, 5, 3}, {7, 1, 6}, {9, 8, 4}};
		int ans = test.count_water_volume(array);
		System.out.print(":))"+ans);

	}

}
