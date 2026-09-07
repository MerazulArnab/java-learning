public class User {
    
    private String username;
    private String password;
    private int failedAttempts;
    private boolean locked;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.failedAttempts = 0;
        this.locked = false;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getFailedAttempts(){
        return failedAttempts;
    }

    public void increaseFailedAttempts(){
        failedAttempts++;
    }

    public void resetFailedAttempts(){
        failedAttempts=0;

    }
    
    public boolean isLocked(){
        return locked;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
