package edu.neu.madsea.kristenhyman;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;

import edu.neu.madsea.kristenhyman.data.TimeConverter;
import edu.neu.madsea.kristenhyman.data.ToDo;

public class ReminderWorker extends Worker {

    private static final String CHANNEL_ID = "todoReminderChannel";
    private static final String GROUP_KEY_REMINDERS = "edu.northeastern.cs5520.todo_adrienne.TODO_REMINDERS";
    public static final String KEY_TITLE = "todo_title";
    public static final String KEY_DESC = "todo_desc";

    public ReminderWorker(
            @NonNull Context appContext,
            @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }

    private static final String TAG = ReminderWorker.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public Result doWork() {

        Context applicationContext = getApplicationContext();

        try {
            createNotificationChannel(applicationContext);
            sendNotification(applicationContext);

            // If there were no errors, return SUCCESS
            return Result.success();

        } catch (Throwable throwable) {

            // Technically WorkManager will return Result.failure()
            // but it's best to be explicit about it.
            // Thus if there were errors, we're return FAILURE
            Log.e(TAG, "Error ", throwable);
            return Result.failure();
        }
    }

    public static void sendNotification(Context context) {
        // Prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(context, NewToDoActivity.class);
        //intent.putExtra(NewToDoActivity.EXTRA_KEY_TODO_ID);

        PendingIntent pIntent = PendingIntent.getActivity(
                context,
                (int) System.currentTimeMillis(),
                intent,
                PendingIntent.FLAG_IMMUTABLE);

        Notification.Builder notificationBuilder;
        if (Build.VERSION.SDK_INT <= 25) {
            notificationBuilder = new Notification.Builder(context)
                    .setSmallIcon(R.drawable.ic_stat_name)
                    .setContentTitle("Simple Notification")
                    .setContentText("Subject:")
                    .setAutoCancel(true)
                    .setContentIntent(pIntent);
        } else {
            notificationBuilder = new Notification.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_stat_name)
                    .setContentTitle("You have something to do!")
                    .setContentText("testing")
                    .setAutoCancel(false)
                    .setGroup(GROUP_KEY_REMINDERS)
                    .setContentIntent(pIntent);
        }

        android.app.NotificationManager notificationManager =
                (android.app.NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */,
                notificationBuilder.build());
    }

    public static void createNotificationChannel(Context context) {
        // Have to create channel before you can send notifications

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = context.getString(R.string.channel_name);
            String description = context.getString(R.string.channel_description);
            int importance = android.app.NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            android.app.NotificationManager notificationManager = context.getSystemService(android.app.NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public static void scheduleWork(Context context, ToDo todo) {
        // work request and then enqueue

        String reminder = todo.reminderDate();
        LocalDate reminderTime = TimeConverter.fromString(reminder);
        LocalDateTime now = LocalDateTime.now();

        WorkRequest uploadWorkRequest =
                new OneTimeWorkRequest.Builder(ReminderWorker.class)
                        .setInitialDelay(reminderTime.atTime(9,0).toEpochSecond(ZoneOffset.UTC) - now.toEpochSecond(ZoneOffset.UTC), TimeUnit.SECONDS)
                        .build();
        WorkManager
                .getInstance(context)
                .enqueue(uploadWorkRequest);
    }
}
