package edu.neu.madsea.kristenhyman.data;

import androidx.room.TypeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeStampConverter {

    public static DateTimeFormatter isoDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @TypeConverter
    public static String fromLocalDateTime(LocalDateTime value) {
        if (value != null) {
//            return value.format(localDateTimeFormatter);
            return value.format(isoDateTimeFormatter);
        } else {
            return "";
        }
    }

    @TypeConverter
    public static LocalDateTime fromString(String value) {
        if (value != null) {
            if (value.equalsIgnoreCase(""))
                return LocalDateTime.now();
            LocalDateTime thing;
            try {
//                thing = LocalDateTime.from(localDateTimeFormatter.parse(value));
                thing = LocalDateTime.from(isoDateTimeFormatter.parse(value));
            } catch(Exception e) {
                thing = null;
            }
            return thing;

        } else {
            return LocalDateTime.now();
        }
    }

}
