package edu.neu.madsea.kristenhyman;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/ToDoItemRepository.java
 */
public class ProjectItemView extends ConstraintLayout {


    public ProjectItemView(Context context) {
        super(context);
        setupView(context);
    }

    public ProjectItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView(context);
    }

    public ProjectItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupView(context);
    }

    private void setupView(Context context) {
        // Inflate the view from the layout resource.
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.project_item_view, this, true);
    }



}