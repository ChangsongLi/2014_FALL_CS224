import java.io.*;


public class Population {
	
	private void solve() throws IOException{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		String line;
		while( !( line = br.readLine()).equals("0") ){
			int[] num = new int[100];
			line = br.readLine();
			String[] tokens = line.split("\\s+");
			for(String s: tokens){
				num[Integer.parseInt(s)-1]++;
			}
			
			StringBuilder str = new StringBuilder("");
			
			for( int i = 0; i < 100; i++ ){
				for( int j = 0; j < num[i]; j++ ){
					if( str.length() == 0 )
						str.append(i+1);
					else
						str.append( " " + (i+1) );
				}
			}
			
			System.out.println(str);
			
		}
	}

	public static void main(String[] args){
		Population p = new Population();
		try {
			p.solve();
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

}
