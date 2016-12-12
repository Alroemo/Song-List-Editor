package algorhythm;

public class NavigationCntl {
        
    private MainMenuUI theMainMenuUI = null;
    private MediaCntl theMediaCntl = null;
    private TestUI theTestUI = null;
    private TestCntl theTestCntl = null;
    
    public NavigationCntl(){
        System.out.println("Made it to NavigationCntl");
        theMainMenuUI = new MainMenuUI(this);
        theMainMenuUI.setLocationRelativeTo(null);
        theMainMenuUI.setVisible(true);
        
    }
    
    public void getMediaCntl(){
        theMainMenuUI.setVisible(false);
        theMediaCntl = new MediaCntl(this);
    }
    
    public void getTestCntl(){
        theMainMenuUI.setVisible(false);
        theTestCntl = new TestCntl(this);
    }
    
    public void getNavigationCntl(){
        if(theMainMenuUI == null){
            theMainMenuUI = new MainMenuUI(this);
            theMainMenuUI.setLocationRelativeTo(null);
            theMainMenuUI.setVisible(true);
        }else{
            theMainMenuUI.setVisible(true);
        }
    }
    
    public void importMedia(){
        ExternalDataCntl theExternalDataCntl = new ExternalDataCntl();
    }
    
}
