import java.util.Scanner;


public class Cipher {
	int[] po;
	
	private void solve(){
		Scanner scan = new Scanner( System.in );
		String s;
		while( !(s = scan.nextLine()).equals("0 0 0") ){
			Scanner scan2 = new Scanner(s);
			int key1 = scan2.nextInt();
			int key2 = scan2.nextInt();
			int key3 = scan2.nextInt();
			
			s = scan.nextLine();
			char[] str = s.toCharArray();
			
			str = shift(str, 1, key1);
			str = shift(str, 2, key2);
			str = shift(str, 3, key3);
			
			for(int i = 0; i < str.length; i++){
				System.out.print(str[i]);
			}
			System.out.println();
			scan2.close();
		}
		scan.close();
		
	}
	
	
	private char[] shift( char[] s, int group, int key ){
		po = new int[s.length];
		int count = 0;
		for( int i = 0; i < s.length; i ++){
			if(check(group,s[i])){
				po[count] = i;
				count++;
			}
			
		}
		char[] arr = new char[s.length];
		int c = 0;
		for( int i = 0; i < s.length; i++ ){
			if(check(group,s[i])){
				arr[i] = s[po[(c-key+count)%count]];
				c++;
			}
			else{
				arr[i] = s[i];
			}
		}
		return arr;
	}
	
	private boolean check( int i, char c ){
		if(i == 1){
			if( c <='i' && c >='a' )
				return true;
			else
				return false;
		}else if( i == 2 ){
			if( c <= 'r' && c >= 'j' )
				return true;
			else
				return false;
		}
		else{
			if( (c >= 's' && c <= 'z') || c == '_' )
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		Cipher c = new Cipher();
		c.solve();

	}

}
