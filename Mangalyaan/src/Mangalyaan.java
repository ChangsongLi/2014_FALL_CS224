import java.io.*;
import java.util.Scanner;


public class Mangalyaan {
	
	private void solve() throws IOException{
		BufferedReader b = new BufferedReader( new InputStreamReader(System.in));
		int num = Integer.parseInt(b.readLine());
		String line;
		for( int i = 0; i < num; num++){
			int count = 0;
			line = b.readLine();
			Scanner scan = new Scanner(line);
			int p = scan.nextInt();
			int s = scan.nextInt();
			line = b.readLine();
			scan = new Scanner(line);
			for( int j = 0; j < p; j++ ){
				if( scan.nextInt() >= s )
					count++;
			}
			System.out.println(count);
		}
	}

	public static void main(String[] args) throws IOException{
		Mangalyaan m = new Mangalyaan();
		m.solve();
	}

}
