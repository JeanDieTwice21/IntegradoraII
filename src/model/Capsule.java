package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Capsule{

    private String id;
    private Type type;
    private String description;
    private String workerName;
    private String workerCharge;
    private String lection;
    private boolean approveStatus;
    private boolean isPublished;
    private Calendar approveDate;
    

    public Capsule(String id, Type type, String description, String workerName, String workerCharge, String lection){

        this.id = id;
        this.type = type;
        this.description = description;
        this.workerName = workerName;
        this.workerCharge = workerCharge;
        this.lection = lection;
        this.approveStatus = false;
        this.isPublished = false;

    }

/**
 * This function returns the value of the "id" variable as a string.
 * 
 * @return The method `getId()` is returning a `String` value, which is the value of the variable `id`.
 */
    public String getId(){
        return id;
    }
    
/**
 * This function returns the approve status as a boolean value.
 * 
 * @return The method is returning the value of the boolean variable `approveStatus`.
 */
    public boolean getApproveStatus(){
        return approveStatus;
    }

/**
 * The function returns a boolean value indicating whether an item is published or not.
 * 
 * @return The method is returning a boolean value, specifically the value of the variable
 * "isPublished".
 */
    public boolean getIsPublished(){
        return isPublished;
    }

/**
 * This function returns the publish date of an object as a Calendar object.
 * 
 * @return The method `getPublishDate()` is returning a `Calendar` object, which represents the date
 * and time of publication.
 */
    public Calendar getApproveDate(){
        return approveDate;
    }

    public String getLection(){
        return lection;
    }
/**
 * This function sets the published status of an object.
 * 
 * @param newPublishedStatus a boolean value that represents the new published status that we want to
 * set for an object. If it is true, it means the object is published, and if it is false, it means the
 * object is not published. The method sets the value of the isPublished instance variable of the
 * object to the
 */
    public void setIsPublished(boolean newPublishedStatus){
        this.isPublished = newPublishedStatus;
    }
/**
 * The function sets the approve status to a new boolean value.
 * 
 * @param newStatus a boolean value that represents the new status to be set for the approveStatus
 * variable. If newStatus is true, it means the approval status is set to approved, and if it is false,
 * it means the approval status is set to not approved.
 */
    public void setApproveStatus(boolean newStatus){
        this.approveStatus = newStatus;
    }

/**
 * This function sets the publish date of an object to a new calendar date.
 * 
 * @param newPublishDate A Calendar object representing the new publish date to be set for an instance
 * variable called publishDate.
 */
    public void setApproveDate(Calendar approvedDate){
        this.approveDate = approvedDate;
    }

}