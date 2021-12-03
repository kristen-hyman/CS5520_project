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

    @ColumnInfo(name = "description")
    private String description;


    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "reminderDate")
    private String reminderDate;

    @ColumnInfo(name = "venue")
    private String venue;

    @ColumnInfo(name = "emailAddress")
    private String emailAddress;

    @ColumnInfo(name = "projectType")
    private String projectType;

    @ColumnInfo(name = "budget")
    private Float budget;

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


    public String reminderDate() {
        return reminderDate;
    }

    public void setReminderDate(String reminderDate) {
        this.reminderDate = reminderDate;
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


    public String getProjectType() { return projectType; }
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }


    public Float getBudget() { return budget; }
    public void setBudget(Float budget) {
        this.budget = budget;
    }


    public static Project createProject(String artistName, String description, String dueDate, String reminderDate) {
        Project gig = new Project();
        gig.setBudget(5.00f);
        gig.setVenue("boston");
        gig.setEmailAddress("kristen@gmail");
        gig.setProjectType("videography");
        gig.setReminderDate("12/02/2021");

        gig.setArtistName(artistName);
        gig.setDescription(description);
        gig.setDate(dueDate);

        return gig;
    }


}
