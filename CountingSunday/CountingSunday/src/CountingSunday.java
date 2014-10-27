
public class CountingSunday {
	public static void main(String[] arg){
		CountingSunday cs = new CountingSunday();
		cs.solve();
	}
	public void solve(){
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		int firstDay = 2;
		int count = 0;
		for(int i = 1901; i <= 2000; i++){
			if(leapYear(i) == -1){
				for( int j = 0; j < 12; j++){
					if(firstDay == 7)
						count++;
					if( m[j] == 31 ){
						firstDay = firstDay + 3;
					}
					else if( m[j] == 30 ){
						firstDay = firstDay + 2;
					}
					else{
					}
					if(firstDay > 7)
						firstDay = firstDay % 7;
				}
				
			}
			else{
				for( int j = 0; j < 12; j++){
					if(firstDay == 7)
						count++;
					if( m[j] == 31 ){
						firstDay = firstDay + 3;
					}
					else if( m[j] == 30 ){
						firstDay = firstDay + 2;
					}
					else{
						firstDay++;
					}
					if(firstDay > 7)
						firstDay = firstDay % 7;
				}		
			}
		}
		System.out.println(count);
	}
	
	public int leapYear( int i ){
		if( i % 4 == 0 ){
			if( i % 100 != 0 )
				return 0;
			else if( i % 400 == 0 )
				return 0;
			else
				return -1;
		}else{
			return -1;
		}
	}
}
