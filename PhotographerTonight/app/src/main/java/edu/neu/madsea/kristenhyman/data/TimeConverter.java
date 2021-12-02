package edu.neu.madsea.kristenhyman.data;

import androidx.room.TypeConverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*
/ Adapted from Adrienne:
https://github.com/ahope/cs5520_project/blob/663f076461ac0cbe85cdbd4578b6d6148bb334b9/
todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/TimestampConverter.java#L16
 */
public class TimeConverter {

    public static DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @TypeConverter
    public static LocalDate fromString(String value) {
        if (value != null) {
            if (value.equalsIgnoreCase(""))
                return LocalDate.now();
            LocalDate timeConvert;
            try {
               timeConvert = LocalDate.from(localDateTimeFormatter.parse(value));
            } catch(Exception e) {
                timeConvert = null;
            }
            return timeConvert;

        } else {
            return LocalDate.now();
        }
    }
}
