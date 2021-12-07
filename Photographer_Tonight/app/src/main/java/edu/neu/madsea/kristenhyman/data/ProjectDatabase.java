package edu.neu.madsea.kristenhyman.data;

import static edu.neu.madsea.kristenhyman.data.Project.createProject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Project.class}, version = 5, exportSchema = false)
abstract public class ProjectDatabase extends RoomDatabase {

    abstract ProjectDao projectDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile ProjectDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ProjectDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProjectDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProjectDatabase.class, "project_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    /**
     * Override the onCreate method to populate the database.
     * For this sample, we clear the database every time it is created.
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                ProjectDao dao = INSTANCE.projectDao();
                dao.deleteAll();

                Project gig1 = createProject("ARTIST1", "Boston", "Middle East", "12/1/20201",
                        "5", "looking for photographers!", "kristen@gmail.com");
                dao.insert(gig1);

            });
        }
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);

            System.out.println("database opened");
        }
    };

}
