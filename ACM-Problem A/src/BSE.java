import java.util.Scanner;


public class BSE {

	public static void main(String[] args) {
		BSE b = new BSE();
		b.solve();
	}

	long[] data = new long[20];
	long[] height = new long[20];
	
	private void solve() {		
		Scanner scan = new Scanner(System.in);
		fillHeight();
		int c = 1;
		while(scan.hasNextLong()){
			long num = scan.nextLong();
			int row = 0;
			long output = 0;
			while( num > 0 ){
				num = num - height[row];
				output = output + data[row];
				row++;
			}
			output = output + row * num;
			System.out.println("Case " + c + ": "+ output);
			c++;
		}
		scan.close();
	}
	
	private void fillHeight(){
		for( int i= 0; i < height.length; i++ ){
			height[i] = (long)Math.pow( 2, i );
			data[i] = (i + 1) * height[i];
		}
	}

}
