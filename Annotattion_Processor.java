import java.lang.reflect.Method;

public class Annotattion_Processor {

    public static void getAnnotation() {

        try {
            Class c = Coin.class;

            Method[] methods = c.getMethods();
            Method method = null;
            for (Method m : methods) {
                if(m.getName().equals("probHeads")) {
                    method = m;
                }
            }

            System.out.println("Annotation Paramter for OutcomeRange");
            OutcomeRange out = method.getAnnotation(OutcomeRange.class); 
            System.out.println("Annotatin class: " + out.ann());
            System.out.println("Min range: " + out.min());
            System.out.println("Max range: " + out.max()); 
            System.out.println();
            
            System.out.println("Annotation Paramter for Prob");
            Prob prob = method.getAnnotation(Prob.class); 
            System.out.println("Event: " + prob.event());
            System.out.println("Outcome: " + prob.outcome());
            System.out.println("Value: " + prob.val()); 
            System.out.println();

            System.out.println("Annotation Paramter for DependProbs");
            DependProbs depend1 = method.getAnnotation(DependProbs.class); 
            System.out.println("Event: " + depend1.value());
            

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        getAnnotation();
    }
}
