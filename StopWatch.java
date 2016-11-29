public class Stopwatch{
  private long startTime;
  private long stopTime;
  private long elapedTime;
  
  public Stopwatch(){
    reset();
  }
  
  public void reset(){
    this.elapedTime = 0;
    this.startTime = 0;
    this.stopTime = 0;
  }
  
  public void start(){
    this.startTime = System.currentTimeMillis();
    
  }
  
  public void stop(){
    this.stopTime = System.currentTimeMillis();
    this.elapedTime = (stopTime - this.startTime);
  }

}
