package edu.neu.madsea.kristenhyman.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


public interface APIDao {

    LiveData<List<Project>> getAllGigs();

    void postProject(Project project);


    }


