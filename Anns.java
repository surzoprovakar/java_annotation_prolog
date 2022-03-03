import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface OutcomeRange {
	Class ann();	
	int min();
	int max();
}

@interface Prob {
	String event() default "";	
	int outcome();
	int val();
}

@Repeatable(DependProbs.class)
@interface DependProb {
	String event();	
	Prob prob();
}
