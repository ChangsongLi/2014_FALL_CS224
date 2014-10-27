import java.math.BigInteger;


public class PowerDigitSum {

	public static void main(String[] args) {
		
			BigInteger number = new BigInteger("2");
			int power = 1000;
			
			String numStr = number.pow(power).toString();
			long answer = 0;
			
			for(int j=0;j<numStr.length();j++)
			{
				answer+=Character.getNumericValue(numStr.charAt(j));
			}		
			System.out.println("Answer is :"+answer);

		
	}

}
