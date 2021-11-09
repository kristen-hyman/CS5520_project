package edu.neu.madsea.kristenhyman.data;

import static edu.neu.madsea.kristenhyman.data.ToDo.createTodo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.  In a real
 * app, consider exporting the schema to help you with migrations.
 */

@Database(entities = {ToDo.class}, version = 1, exportSchema = false)
abstract public class ToDoDatabase extends RoomDatabase {

    abstract ToDoDao toDoDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile ToDoDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ToDoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ToDoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ToDoDatabase.class, "word_database")
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
                ToDoDao dao = INSTANCE.toDoDao();
                dao.deleteAll();

                ToDo todo1 = createTodo("task1", "description1", "11/3/2021",
                        "11/2/2021");
                dao.insert(todo1);

                ToDo todo2 = createTodo("task2", "description2", "11/5/2021",
                        "11/2/2021");
                dao.insert(todo2);
            });
        }
    };
}
