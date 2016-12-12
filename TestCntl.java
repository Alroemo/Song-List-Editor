/* //
Add search and sort performance test functionality to AlgoRhythm
This will include creating the following:
–A Test controller to manage the performance tests

The Test controller will have three representations of the Song data including: ArrayList (native), array, and one other Java collection of your choice
A Stopwatch to measure the performance of search and sort operations on the three different data representations
–A TestUI to run the tests and display test results

–TestUI will allow users to run timed tests for:
    Sorting the three different data representations
    Searching the three different representations

*/
package algorhythm;

import java.util.*;
import java.util.HashSet;
import java.util.Collections;

public class TestCntl {
    
    private ArrayList<Media> theMediaAL = null;
    private Media[] theMediaAR = null;    
    private Set <Media> theMediaSet = null;
    private TestUI theTestUI = null;
    private NavigationCntl theNavigationCntl = null;
    private Stopwatch sw = null;
    
    public TestCntl(NavigationCntl _theNavigationCntl){
        // Initialize the data
        theNavigationCntl = _theNavigationCntl;
        theTestUI = new TestUI(this);
        theMediaAR = new Media[]{};
        theMediaAL = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getMediaList().getListOfMedia();
        theMediaAR = theMediaAL.toArray(theMediaAR);
        theMediaSet = new HashSet(theMediaAL);
        sw = new Stopwatch();
        theTestUI.setVisible(true);
        
    }
    
    public long sortA(){
        Collections.shuffle(theMediaAL);
        sw.reset();
        sw.start();
        sortMediaByYearA();
        sw.stop();
        return sw.getElapedTime();
        
    }
    public void sortMediaByYearA(){
        String compareMediaYear = "0";
        String currentMediaYear = "0";
        ArrayList<Media> sortedListOfMedia = new ArrayList();
        for(int i = 0; i < theMediaAR.length; i++){
            currentMediaYear = theMediaAR[i].getYear();
            if(currentMediaYear.compareTo(compareMediaYear) > 0)
            {
                sortedListOfMedia.add(theMediaAR[i]);
                compareMediaYear = currentMediaYear;
            }
        }
    }
    
    public long sortAL(){
        Collections.shuffle(theMediaAL);
        sw.reset();
        sw.start();
        sortMediaByYearAL();
        sw.stop();
        return sw.getElapedTime();
    }
    
    public void sortMediaByYearAL(){
        String compareMediaYear = "0";
        String currentMediaYear = "0";
        ArrayList<Media> sortedListOfMedia = new ArrayList();
        for(int i = 0; i < theMediaAL.size(); i++){
            currentMediaYear = theMediaAL.get(i).getYear();
            if(currentMediaYear.compareTo(compareMediaYear) > 0)
            {
                sortedListOfMedia.add(theMediaAL.get(i));
                compareMediaYear = currentMediaYear;
            }
        }
    }
    
    public long sortSet(){
        sw.reset();
        sw.start();
        sortMediaByYearSet();
        sw.stop();
        return sw.getElapedTime();
        
    }
    public void sortMediaByYearSet(){
        
        String compareMediaYear = "0";
        String currentMediaYear = "0";
        ArrayList<Media> sortedListOfMedia = new ArrayList(theMediaSet);
        Collections.sort(sortedListOfMedia);
    }
    
    public void getNavigationCntl(){
        theTestUI.setVisible(false);
        theTestUI.dispose();
        this.theNavigationCntl.getNavigationCntl();
    }
    
}
