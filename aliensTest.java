
public class aliensTest {
	public static void main(String[] args) {
		int total = 0;
		int survived = 0;
		while(true) {
			survived+=isSurvived();
			total++;
			System.out.println(total);
			System.out.println((double)survived/total);
			System.out.println(Math.pow(2-((double)survived/total), 2));
		}
	}
	public static int isSurvived() {
		int numAliens = 1, numAliensB4, numDays = 0;
		while(true) {
			numAliensB4 = numAliens;
			for(int i = 0; i<numAliensB4; i++) {
				numAliens+=(int)(Math.random()*4)-1;
			}
			numDays++;
			if(numAliens<=0) {
				return 0;
			}
			if(numAliens>10000000) {
				return 1;
			}
		}
	}
}
