package ss.week1;
/**
 * 
 * @author marije.linthorst
 * Models a student with a test score
 */
public class StudentScore {
	// Named constants:
	public int score;
	public boolean passed;
	
	// constructor:
	public StudentScore (int a) {
		score = a;
		}
	// queries:
	public int score () {
		return score;
		}
		
	public boolean passed (int score) {
		return score>=70;
		}
		
}
