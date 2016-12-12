package algorhythm;

import java.util.ArrayList;

public class SongList {
    
    private ArrayList<Song> theSongList = new ArrayList();
    
    public void addNewSong(Song newSong){
        theSongList.add(newSong);
    }
    
}
