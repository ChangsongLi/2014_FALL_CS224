import java.util.Arrays;
import java.util.Scanner;


public class Painter {
	
	public void solve(){
		Scanner s = new Scanner( System.in );
		String str;
		
		while( !(str = s.nextLine()).equals("0") ){
			Scanner scan = new Scanner( str );
			
			int num = scan.nextInt();
			int[] col = new int[num];
			int a = col.length - 1;
			int b = col.length - 2;
			int c = col.length - 3;
			
			for( int i = 0; i < num; i++ ){
				col[i] = scan.nextInt();
			}	
			Arrays.sort( col );
			
			int gray = scan.nextInt();	
			int kit = col[ col.length - 1 ] / 50;
			
			if( col[ col.length - 1 ] % 50 != 0 ){
				kit++;
			}
			
			for( int i = 0; i < num; i++ ){
				col[i] = kit * 50 - col[i];
			}
			
			
			int mix = 0;
			while( mix < gray ){
				Arrays.sort(col);
				
				if( col[c] == 0 ){
					fill( col );
					kit++;
				}
				else{
					col[a]--;
					col[b]--;
					col[c]--;
					mix++;
				}
			}
			System.out.println(kit);
		}
	}
	
	public void fill( int[] a ){
		for( int i = 0; i < a.length; i++ ){
			a[i] = a[i] + 50;
		}
	}

	public static void main(String[] args) {
		Painter p = new Painter();
		p.solve();

	}

}
