
public class WinVersion {
    private boolean result;

// The method gets the version Windows and return true if this is Windows 10,
// or return false if this version of Windows is <10

    public boolean checkVersionWindows(){

        String versionWin = System.getProperties().get("os.name").toString();


        if (versionWin.substring(0,10).equals("Windows 10")){
            result = true;
        } else {
            result = false;
        }

        return result;
    }

}
