import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface OutcomeRange {
	Class ann();	
	int min();
	int max();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Prob {
	String event() default "";	
	int outcome();
	int val();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(DependProbs.class)
@interface DependProb {
	String event();	
	Prob prob();
}

public class Coin {
	
	public void toss() {
		double val = Math.random();
		if (val >= thresholdHeads) { 	
			//example usage	
		}
	}

	static {
		thresholdHeads = probHeads();
	}

	@OutcomeRange(ann=Prob.class, min=0, max=1)
	@Prob(event="Fairness", outcome=1, val=90)
	@DependProb(event="Fair", prob=@Prob(outcome=1, val=50))
	@DependProb(event="Biased", prob=@Prob(outcome=1, val=60))
	public static native float probHeads();
	
	private final static float thresholdHeads;

}