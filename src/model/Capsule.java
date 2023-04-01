package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Capsule{

    private String id;
    private String type;
    private String description;
    private String workerName;
    private String workerCharge;
    private String lection;
    private boolean approveStatus;
    private boolean isPublished;
    private Calendar publishDate;

    public Capsule(String id, String type, String description, String workerName, String workerCharge, String lection){

        this.id = id;
        this.type = type;
        this.description = description;
        this.workerName = workerName;
        this.workerCharge = workerCharge;
        this.lection = lection;
        this.approveStatus = false;
        this.isPublished = false;

    }

    public String getId(){
        return id;
    }
    
    public boolean getApproveStatus(){
        return approveStatus;
    }

    public boolean getIsPublished(){
        return isPublished;
    }

    public Calendar getPubilishDate(){
        return publishDate;
    }
    public void setIsPublished(boolean newPublishedStatus){
        this.isPublished = newPublishedStatus;
    }
    public void setApproveStatus(boolean newStatus){
        this.approveStatus = newStatus;
    }

    public void setPublishDate(Calendar newPublishDate){
        this.publishDate = newPublishDate;
    }

}