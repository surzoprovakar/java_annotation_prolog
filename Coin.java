import java.lang.annotation.Repeatable;
@interface ProbabilityUniverse {}

@interface ProbFair {
  Type type();
  int val();
}

@interface ProbFaces {
  Faces face();
  int val();
}
@Repeatable(DependProbs.class)
@interface DependProb {
  Type type();
  ProbFaces prob();
}

@ProbabilityUniverse
enum Faces {
  Head,
  Tail
}

@ProbabilityUniverse
enum Type {
  Fair,
  Biased
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
 
  @ProbFair(type=Type.Fair, val=90)
  @DependProb(type=Type.Fair, prob=@ProbFaces(face=Faces.Head, val=50))
  @DependProb(type=Type.Biased, prob=@ProbFaces(face=Faces.Head, val=60))
  public static native float probHeads();
 
  private final static float thresholdHeads;

}
