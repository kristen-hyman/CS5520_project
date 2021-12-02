package edu.neu.madsea.kristenhyman.data;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.neu.madsea.kristenhyman.ToDoViewModel;
import edu.neu.madsea.kristenhyman.databinding.ToDoItemViewBinding;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/
 */

/**
 * This class holds the data collection, and allows the data to be mapped to the ViewHolder.
 * In this case, it "knows" the ToDoRepo (or, some collection of ToDo objects), and when is appropriate,
 * maps a specific ToDo object to a ViewHolder to display that ToDo instance.
 * The adapter binds the view model to the view.
 */
public class ToDoItemRecyclerViewAdapter extends ListAdapter<ToDo, ToDoItemViewHolder> {

    public ToDoItemRecyclerViewAdapter() {
        super(new ToDoItemRecyclerViewAdapter.TodoDiff());
    }

    /**
     * RecyclerView calls this method whenever it needs to create a new ViewHolder.
     * The method creates and initializes the ViewHolder and its associated
     * View, but does not fill in the view's contents—the ViewHolder has not yet been bound to specific data.
     */
    @NonNull
    @Override
    public ToDoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoItemViewHolder(ToDoItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    /**
     * RecyclerView calls this method to associate a ViewHolder with data.
     * The method fetches the appropriate data and uses the data to fill in the view holder's layout.
     * For example, if the RecyclerView displays a list of names, the method might find the appropriate
     * name in the list and fill in the view holder's TextView widget.
     */
    @Override
    public void onBindViewHolder(@NonNull ToDoItemViewHolder holder, int position) {
        // This is how we bind the UI to a specific task
        holder.bind(getItem(position));

        //ToDoViewModel currentModel = models.get(position);
        //((ToDoItemViewHolder) holder).bind(currentModel.getTodoCreated());
       //((ToDoItemViewHolder) holder).bind(models.get(position));
    }
    public static class TodoDiff extends DiffUtil.ItemCallback<ToDo> {

        @Override
        public boolean areItemsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull ToDo oldItem, @NonNull ToDo newItem) {
            return oldItem.getTaskTitle().equals(newItem.getTaskTitle());
        }
    }

}