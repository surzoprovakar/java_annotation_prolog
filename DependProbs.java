import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface DependProbs{
	public DependProb[] value();
}
