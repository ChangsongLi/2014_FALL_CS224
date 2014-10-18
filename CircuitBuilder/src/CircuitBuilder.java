/**
 * input the size height and wide of circuit board. To get possible ways
 * to connect two diagonal corners.
 *
 * Changsong Li
 */
import java.math.BigInteger;
import java.util.Scanner;


public class CircuitBuilder {
	
	private BigInteger[][] data;
	
	private void solve(){
		Scanner scan = new Scanner(System.in);
		data = new BigInteger[51][51];
		
		while( scan.hasNext() ){
			int h = scan.nextInt();
			int w = scan.nextInt();
			
			if( h == 0 && w == 0 )
				break;
			
				System.out.println("(" + h + " x " + w+"): "+ findOutput(h,w));
		}
		
		scan.close();
	}
	
	private BigInteger findOutput( int h, int w ){
		if(h == 1 || w == 1)
			return new BigInteger("1");
		else if( h == 2 && w == 2)
			return new BigInteger("2");
			
		if(data[h][w] != null){
			return data[h][w];
		}
		
		BigInteger result= findOutput( h - 1, w).add(findOutput(h, w-1));		
		data[w][h] = result;
		data[h][w] = result;
		
		return result;
	}

	public static void main(String[] args) {
		CircuitBuilder cb = new CircuitBuilder();
		cb.solve();

	}

}
