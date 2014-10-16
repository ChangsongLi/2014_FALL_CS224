/**
 *  Problem 6 Alien Math, develop a base-12 addition program.
 *  
 *  Changsong Li
 *  
 */
import java.math.BigInteger;
import java.util.Scanner;


public class Solve {
	public void solve(){
		Scanner scan = new Scanner(System.in);
		String nums;
		while( !(nums = scan.nextLine()).equals("") ){
			String[] num = nums.split("\\s+");
			BigInteger num1 = new BigInteger(num[0], 12);
			BigInteger num2 = new BigInteger(num[1], 12);
			BigInteger result = num1.add(num2);
			System.out.println(result.toString(12).toUpperCase());
		}
		scan.close();
	}
	
	public static void main( String[] args ){
		Solve s = new Solve();
		s.solve();
	}
}
