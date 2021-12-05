package edu.neu.madsea.kristenhyman.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "project_table")
public class Project {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "artistName")
    private String artistName;

    @ColumnInfo(name = "budget")
    private Float budget;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "emailAddress")
    private String emailAddress;

    @ColumnInfo(name = "location")
    private String location;


    @ColumnInfo(name = "projectType")
    private String projectType;

    @ColumnInfo(name = "venue")
    private String venue;


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


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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


    public static Project createProject(String artistName, String description, String dueDate, String time) {
        Project gig = new Project();
        gig.setBudget(5.00f);
        gig.setVenue("boston");
        gig.setEmailAddress("kristen@gmail");
        gig.setProjectType("videography");
        gig.setLocation("NYC");
        gig.setTime(time);
        gig.setArtistName(artistName);
        gig.setDescription(description);
        gig.setDate(dueDate);

        return gig;
    }


}
