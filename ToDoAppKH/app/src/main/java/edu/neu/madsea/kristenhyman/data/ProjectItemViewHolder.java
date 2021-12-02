package edu.neu.madsea.kristenhyman.data;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import edu.neu.madsea.kristenhyman.databinding.ToDoItemViewBinding;
/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/
 */

// ViewHolder provides all the functionality for your list items
// The ViewHolder is a wrapper around a View that contains the layout for an individual item in the list.
// view holder is a wrapper around a View, and that view is managed by RecyclerView
public class ToDoItemViewHolder extends RecyclerView.ViewHolder {

    public ToDoItemViewBinding binding;
    public TextView titleTextView;

    public ToDoItemViewHolder(ToDoItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void bind(Project project) {
        binding.setTodoDetail(project.getDescription());
        binding.setTodoTitle(project.getTaskTitle());
        binding.setTodoTask(project);
        binding.executePendingBindings();
    }


}