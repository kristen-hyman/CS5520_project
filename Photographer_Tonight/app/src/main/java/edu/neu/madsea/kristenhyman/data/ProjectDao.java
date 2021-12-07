package edu.neu.madsea.kristenhyman.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
    public interface ProjectDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * FROM project_table ORDER BY artistName ASC")
    //this would be getGigs() return liveData of list of the gigs
    // separate impl
    //this method would go and do teh okhttp get request as teh JSON
    // tell GSON to
    LiveData<List<Project>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Project project);

    @Query("DELETE FROM project_table WHERE artistName = :inputTaskTitle")
    int deleteByTaskTitle(String inputTaskTitle);

    @Query("DELETE FROM project_table")
    void deleteAll();
}


