import java.math.BigInteger;


public class Driver {

	public static void main(String[] args) {
		BigInteger bi = new BigInteger("100");
		for(int i = 99; i > 0; i--){
			BigInteger bi2 = new BigInteger(""+i);
			bi = bi.multiply(bi2);
		}
		String s = bi.toString();
		long count = 0;
		for(int i = 0; i < s.length(); i++ ){
			count = count + ( s.charAt(i) - '0' );
		}
		System.out.println(count);
	}

}
