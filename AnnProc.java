import javax.annotation.processing.*;
import java.util.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.Diagnostic;

@SupportedSourceVersion(SourceVersion.RELEASE_13)
public class AnnProc extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);
    }
    @Override
    public boolean process(Set<? extends TypeElement> set,
                           RoundEnvironment roundEnv) {
        //System.out.println("Called process " + set);

        processProbAnn(roundEnv);
        processDependProbAnn(roundEnv);
        return true;
    }
    private void processProbAnn(RoundEnvironment roundEnv) {
        // Process the annotation
        Set<? extends Element> annotatedElements =
                roundEnv.getElementsAnnotatedWith(Prob.class);

        for (Element element : annotatedElements) {
            if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement el = (ExecutableElement) element;
                Prob prob = el.getAnnotation(Prob.class);
                System.out.println("Event: " + prob.event());
                System.out.println("Outcome: " + prob.outcome());
                System.out.println("Value: " + prob.val());
                System.out.println();
            }
        }
    }

    private void processDependProbAnn(RoundEnvironment roundEnv) {
        // Process the annotation
        Set<? extends Element> annotatedElements =
                roundEnv.getElementsAnnotatedWith(DependProbs.class);
        //System.out.println("set size " + annotatedElements.size());
        for (Element element : annotatedElements) {
            if (element.getKind() == ElementKind.METHOD) {
                ExecutableElement el = (ExecutableElement) element;
                DependProb[] dp = el.getAnnotationsByType(DependProb.class);
                System.out.println("Event: " + dp[0].event());
                System.out.println("Prob: " + dp[0].prob());
                System.out.println("Event: " + dp[1].event());
                System.out.println("Prob: " + dp[1].prob());

                System.out.println();
            }
        }
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> anns = new HashSet<>();
        anns.add("Prob");
        anns.add("OutcomeRange");
        anns.add("DependProb");
        anns.add("DependProbs");
        return anns;
    }
    /*
    @Override
    public SourceVersion getSupportedSourceVersion() {
        // Return the Java version supported
    }
    */

}