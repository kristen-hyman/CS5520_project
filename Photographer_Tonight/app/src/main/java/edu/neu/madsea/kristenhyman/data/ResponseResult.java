package edu.neu.madsea.kristenhyman.data;

import java.util.List;

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
        return results;
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
