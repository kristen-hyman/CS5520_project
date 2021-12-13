package edu.neu.madsea.kristenhyman.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity(tableName = "project_table")
public class Project {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "artistName")

    @SerializedName(value = "artist_name_text", alternate = "artist_name")
    private String artistName;

    @ColumnInfo(name = "budget")
    @SerializedName(value = "budget_number", alternate = "budget")
    private String budget;

    @ColumnInfo(name = "date")
    @TypeConverters({TimeStampConverter.class})
    @SerializedName(value = "date_date", alternate = "date")
    private LocalDateTime date;

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


    public static Project createProject(String artistName, String location,
                                        String venue, LocalDateTime date,
                                        String budget, String description, String emailAddress) {
        Project gig = new Project();
        gig.setBudget(budget);
        gig.setEmailAddress(emailAddress);
        gig.setProjectType("Concert Photography");
        gig.setLocation(location);
        gig.setArtistName(artistName);
        gig.setDescription(description);
        //gig.setDate("2021-12-16T01:30:00.000Z");
        gig.setDate(date);
        gig.setVenue(venue);

        return gig;
    }

    public String getDateAsString() {
        return TimeStampConverter.fromLocalDateTime(this.date);
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

}
