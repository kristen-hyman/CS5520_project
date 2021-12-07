package edu.neu.madsea.kristenhyman.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "project_table")
public class Project {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "artistName")

    @SerializedName(value = "artist_name_text", alternate = "artist_name")
    private String artistName;

    @ColumnInfo(name = "budget")
    @SerializedName(value = "budget_number", alternate = "budget")
    private Float budget;

    @ColumnInfo(name = "date")
    @SerializedName(value = "date_date", alternate = "date")
    private String date;

    @ColumnInfo(name = "description")
    @SerializedName(value = "description_text", alternate = "description")
    private String description;

    @ColumnInfo(name = "emailAddress")
    @SerializedName(value = "email_text", alternate = "email")
    private String emailAddress;

    @ColumnInfo(name = "location")
    @SerializedName(value = "location_text", alternate = "location")
    private String location;


    @ColumnInfo(name = "projectType")
    @SerializedName(value = "type_of_project_text", alternate = "type_of_project")
    private String projectType;

    @ColumnInfo(name = "venue")
    @SerializedName(value = "venue_text", alternate = "venue")
    private String venue;

    @ColumnInfo(name = "Created Date")
    @SerializedName(value = "Created Date", alternate = "createdDate")
    private String createdDate;

    @ColumnInfo(name = "Created By")
    @SerializedName(value = "Created By", alternate = "createdBy")
    private String createdBy;

    @ColumnInfo(name = "Modified Date")
    @SerializedName(value = "Modified Date", alternate = "modifiedDate")
    private String modifiedDate;

    @ColumnInfo(name = "_id")
    @SerializedName(value = "_id", alternate = "id")
    private String _id;

    public static Project createProject(String artistName, String description, String dueDate, String venue) {
        Project gig = new Project();
        gig.setBudget(5.00f);
        gig.setEmailAddress("kristen@gmail");
        gig.setProjectType("videography");
        gig.setLocation("NYC");
        gig.setArtistName(artistName);
        gig.setDescription(description);
        gig.setDate(dueDate);
        gig.setVenue(venue);

        return gig;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modified_date) {
        this.modifiedDate = modifiedDate;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


}
