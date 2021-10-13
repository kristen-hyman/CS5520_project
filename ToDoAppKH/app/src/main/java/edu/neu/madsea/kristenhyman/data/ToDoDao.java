package edu.neu.madsea.kristenhyman.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.neu.madsea.kristenhyman.data.ToDo;

@Dao
    public interface ToDoDao {

        // LiveData is a data holder class that can be observed within a given lifecycle.
        // Always holds/caches latest version of data. Notifies its active observers when the
        // data has changed. Since we are getting all the contents of the database,
        // we are notified whenever any of the database contents have changed.
        @Query("SELECT * FROM todo_table ORDER BY taskTitle ASC")
        LiveData<List<ToDo>> getAlphabetizedWords();

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(ToDo toDo);

        @Query("DELETE FROM todo_table")
        void deleteAll();
    }



