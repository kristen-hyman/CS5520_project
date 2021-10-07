package edu.neu.madsea.kristenhyman.data;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.neu.madsea.kristenhyman.databinding.ToDoItemViewBinding;
/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/
 */

public class ToDoItemViewHolder extends RecyclerView.ViewHolder {

    public ToDoItemViewBinding binding;
    public TextView titleTextView;

    public ToDoItemViewHolder(ToDoItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void bind(ToDo toDo) {
        binding.setTodoDetail(toDo.getDescription());
        binding.setTodoTitle(toDo.getTaskTitle());
        binding.setTodoTask(toDo);
        binding.executePendingBindings();
    }


}