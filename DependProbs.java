import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface DependProbs{
	DependProb[] value();
}
