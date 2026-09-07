public class LogEntry{
    private String date;
    private String time;
    private String event;
    private String username;
    private String ipAddress;

    public LogEntry(String date, String time, String event, String username,String ipAddress){
        this.date = date;
        this.time=time;
        this.event= event;
        this.username= username;
        this.ipAddress= ipAddress;
    }

    public String getEvent(){
        return event;
    }
    public String getIpAddress(){
        return ipAddress;
    }
}