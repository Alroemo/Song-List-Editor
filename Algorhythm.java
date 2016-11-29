public class Algorhythm {

  public static main(){
    Stopwatch sw = new StopWatch();
    sw.start();
    SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel();
    sw.stop();
    System.out.println(sw.getElapedTime());
  }
}
