package edu.neu.madsea.kristenhyman.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ResponseResult {

    private int cursor;
    private List<Project> results;
    private int remaining;
    private int count;

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public List<Project> getData() {
        List<Project> filteredList;
                filteredList = results.stream()
                .filter(gig -> gig.getDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());


        return filteredList;

    }


    public void setData(List<Project> results) {
        this.results = results;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
