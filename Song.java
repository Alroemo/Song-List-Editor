package algorhythm;

public class Song extends Media{
    
    private String spotifyURL = "";
    
   
    public Song(){
        System.out.println("Called: Song()");
    }
    
    public Song(String importSongString){
        super(importSongString);
        String delimiter = "\\t";
        String[] tempSongArray = importSongString.split(delimiter);
        this.spotifyURL = tempSongArray[4];
    }
    
    public Song(String newTitle, int newLength, String newArtist){
        super(newTitle, newLength, newArtist);
        // System.out.println("Called: Song(String newTitle, int newLength, String newArtist)");
    }
    
    public static int getFakeNumber(){
        return 100;
    }
    
    public String toString(){
        String songString = super.toString();
        return songString;
    }
    
    public boolean equals(Object theObject){
        Song song2Compare = (Song) theObject;
        if(this.toString().equals(song2Compare.toString())){
            return true;
        }else{
            return false;
        }
    }
    
    public int compareTo(Object otherObject){
        int result = 0;
        Song otherSong = (Song) otherObject;
        result = this.toString().compareTo(otherSong.toString());
        return result;
    }

    
}
