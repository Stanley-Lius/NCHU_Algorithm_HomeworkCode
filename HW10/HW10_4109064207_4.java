package algHW;

public class HW10_4109064207_4 extends StringSort{
	public String[] checkString(String[] array) 
	{
		MSD_4109064207 ans = new MSD_4109064207();
		ans.sort(array);
		return array;
		
	}

	
	class MSD_4109064207
	{
		private  int R =256;
		private  final int CUTOFF =15;
		private  String[] aux;
		
		
		
		int charAt(String s, int d)
		{
			
			if(d<s.length()) return s.charAt(d);
			else return -1;
		}
		
		 void sort(String[] a)
		{
			int n = a.length;
			aux = new String[n];
			for(int i=0;i<n;i++)
			{
				aux[i] = "";
			}
			sort(a, 0, n-1, 0);
		}
		
		 private void sort(String[] a, int lo, int hi, int d)
		{
			if(hi<=lo+CUTOFF)
			{
				insertion_sort(a, lo, hi, d);
				return ;
			}
			int[] count = new int[R+2];
			for(int i=0;i<R+2;i++)
			{
				count[i]=0;
			}
			for(int i = lo;i <=hi;i++)
			{
				count[charAt(a[i],d)+2]++;
			}
			for(int r=0;r<R+1;r++)
				count[r+1] += count[r];
			
			for(int i = lo;i<=hi;i++)
			{
				aux[count[charAt(a[i], d)+1]++] = a[i];
			}
			
			for(int i=lo;i<=hi;i++)
				a[i] = aux[i-lo];
			
			for(int r=0;r< R;r++)
			{
				sort(a,lo+count[r],lo+count[r+1]-1,d+1);
			}
		}
		
		 void insertion_sort(String[] a, int lo, int hi, int d)
		{
			for(int i=lo;i<=hi;i++)
				for(int j = i;j>lo && less(a[j],a[j-1],d); j--)
					exch(a,j,j-1);
		}
		
		private  boolean less(String v,String w,int d)
		{
			for(int i = d;i<(v.length()>w.length()?w.length():v.length());i++)
				if (v.charAt(i) < w.charAt(i)) return true;
				else if(v.charAt(i) > w.charAt(i)) return false;
			return v.length() < w.length();
		}
		
		private  void exch(String[] a,int now ,int next)
		{
			String temp = "";
			temp = a[now];
			a[now] = a[next];
			a[next] = temp;
			
		}
		
	}

	public static void main(String[] args) {
		HW10_4109064207_4 test = new HW10_4109064207_4();
		String[] arr = {"aaaa", "aa", "aaa" ,"a", "aaa","bafs","asdsafwq","asdafqgte","asasdagwew","yyyyewrwer","asdadadsad","asad","g","sada","qqqq","asdasdxv","lsls","sadasd55"}; 
		String[] arr1 = {"Once","a","upon","time"};
		arr = test.checkString(arr);
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}

}
