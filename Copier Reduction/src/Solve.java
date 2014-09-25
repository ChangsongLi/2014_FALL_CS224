import java.util.Scanner;


public class Solve {

	public void solve(){
		Scanner scan = new Scanner( System.in );
		String s;
		while( !( s = scan.nextLine()).equals("0 0 0 0") ){
			Scanner scan2 = new Scanner(s);
			int c1 = scan2.nextInt();
			int c2 = scan2.nextInt();
			int p1 = scan2.nextInt();
			int p2 = scan2.nextInt();
			int f1;
			int f2;
			
			if( c1 > c2 ){
				if( p1 > p2 ){
					f1 = p1 * 100 / c1;
					f2 = p2 * 100 / c2;
					
					if(f1 > 100 && f2 > 100){
						f1 = 100;
						f2 = 100;
					}
					
					if( f1 > f2 )
						System.out.println( f2 + "%" );
					else
						System.out.println( f1 + "%" );
				}
				else{
					f1 = p2 * 100 / c1;
					f2 = p1 * 100 / c2;
					
					if(f1 > 100 && f2 > 100){
						f1 = 100;
						f2 = 100;
					}
					
					if( f1 > f2 )
						System.out.println( f2 + "%" );
					else
						System.out.println( f1 + "%" );
				}
			}
			else{
				if( p1 > p2 ){
					f1 = p1 * 100 / c2;
					f2 = p2 * 100 / c1;
					
					if(f1 > 100 && f2 > 100){
						f1 = 100;
						f2 = 100;
					}
					
					if( f1 > f2 )
						System.out.println( f2 + "%" );
					else
						System.out.println( f1 + "%" );
				}
				else{
					f1 = p1 * 100 / c1;
					f2 = p2 * 100 / c2;
					
					if(f1 > 100 && f2 > 100){
						f1 = 100;
						f2 = 100;
					}
					
					if( f1 > f2 )
						System.out.println( f2 + "%" );
					else
						System.out.println( f1 + "%" );
				}
			}
		}
	}
	public static void main(String[] args) {
		Solve s = new Solve();
		s.solve();
	}

}
