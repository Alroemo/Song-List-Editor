package algorhythm;

public class Stopwatch {
    
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
    
    public void stop(){
        this.stopTime = System.currentTimeMillis();
        this.elapedTime = (this.stopTime - this.startTime);
    }
    
    public void start(){
        this.startTime = System.currentTimeMillis();
    }
    

    /**
     * @return the startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the stopTime
     */
    public long getStopTime() {
        return stopTime;
    }

    /**
     * @param stopTime the stopTime to set
     */
    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * @return the elapedTime
     */
    public long getElapedTime() {
        return elapedTime;
    }

    /**
     * @param elapedTime the elapedTime to set
     */
    public void setElapedTime(long elapedTime) {
        this.elapedTime = elapedTime;
    }
    
    
    
    
}
