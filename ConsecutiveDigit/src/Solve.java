import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;


public class Solve {
	
	private final MathContext mc = new MathContext(1000);
	private BigDecimal sub;
	
	public void solve(){
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		
		for( int i = 0; i < num; i++ ){
			// get the data
			String str = scan.nextLine();
			Scanner s = new Scanner(str);
			int numerator = s.nextInt();
			int denominator = s.nextInt();
			int beginning = s.nextInt();
			int ending = s.nextInt();
			
			// get the BigDecimal number presetation 
			// of the digits after decimal point
			
			BigDecimal dec = getFP(numerator,denominator);
			
			// convert it to Base 7 number and print it form position
			// beginning to ending.
			String output = getOutput(beginning, ending,dec);	
			System.out.println("Problem set "+(i+1)+": "+numerator+ " / "+denominator+", base 7 digits " + beginning+" through "+ ending+": "+output );
			
		}
	}
	
	private String getOutput(int beginning, int ending, BigDecimal dec ){
		String output = "";
		for( int j = 0; j < ending + 1; j++ ){
			int position = -(j + 1);
			int digit = getDigitAtPos( dec, position );
			dec = dec.subtract(sub);
			if( beginning <= j){
				output = output + digit;
			}
		}
		return output;
	}
	
	private BigDecimal getFP( int numerator, int denominator){
		BigDecimal n = new BigDecimal(numerator);
		BigDecimal d = new BigDecimal(denominator);
		BigDecimal bd = n.divide(d,mc);
		bd = bd.subtract(new BigDecimal( bd.toBigInteger()));
		
		return bd;
	}
	
	private int getDigitAtPos( BigDecimal num, int position ){
		BigDecimal seven = new BigDecimal(7);
		BigDecimal powOfSeven = seven.pow(position,mc);
		for(int i = 6; i >= 0; i-- ){
			sub = powOfSeven.multiply(new BigDecimal(i));
			if( num.compareTo(sub) >= 0 ){
				
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Solve s = new Solve();
		s.solve();
	}

}
