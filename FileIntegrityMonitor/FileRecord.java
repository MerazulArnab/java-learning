public class FileRecord {
    private String fileName;
    private String originalHash;

    public FileRecord(String fileName, String originalHash){
        this.fileName = fileName;
        this.originalHash = originalHash;
    }

    public String getFileName(){
        return fileName;
    }

    public String getOriginalHash(){
        return originalHash;
    }
}
