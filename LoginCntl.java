
package algorhythm;

public class LoginCntl {
    
    private UserList theUserList;
    private  LoginUI theLoginUI;
    private NavigationCntl theNavigationCntl;
    
    public LoginCntl(){
        // theUserList = new UserList();
        theUserList = SerializedDataCntl.getSerializedDataCntl().getSerializedDataModel().getUserList();
        theLoginUI = new LoginUI(this);
        theLoginUI.setLocationRelativeTo(null);
        theLoginUI.setVisible(true);
    }
    
    public void requestNavigationCntl(){
        theLoginUI.setVisible(false);
        theNavigationCntl = new NavigationCntl();
    }
    
    public boolean requestAuthenticate(String usernameToCheck, char[] passwordToCheck){
        boolean authenticated = theUserList.authenticate(usernameToCheck, passwordToCheck);
        return authenticated;
    }
     
}
