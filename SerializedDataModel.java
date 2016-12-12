package algorhythm;

import java.io.Serializable;

public class SerializedDataModel implements Serializable{
    
    private UserList theUserList;
    private MediaList theMediaList;
    
    
    public SerializedDataModel(){

       if(theUserList == null){
           //createTestSerializedDataModel();
           theUserList = new UserList(); 
       } 
       if(theMediaList == null){
           //createTestSerializedDataModel();
           theMediaList = new MediaList(); 
       } 
    }
    
    public UserList getUserList(){
        return theUserList;
    }
    
    public MediaList getMediaList(){
        return theMediaList;
    }
        
    public void setUserList(UserList newUserList){
        theUserList = newUserList;
    }
    
    public void setMediaList(MediaList newMediaList){
        theMediaList = newMediaList;
    }
      
}

