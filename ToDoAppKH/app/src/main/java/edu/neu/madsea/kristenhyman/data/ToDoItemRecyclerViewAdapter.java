package edu.neu.madsea.kristenhyman.data;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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
 */
public class ToDoItemRecyclerViewAdapter extends RecyclerView.Adapter<ToDoItemViewHolder> {

    private List<ToDoViewModel> models = new ArrayList<>();

    /**
     * Adapter constructor
     *
     * @param viewModels
     *         A collection of viewmodels which will contain the data that will be used in each ViewHolder
     */
    public ToDoItemRecyclerViewAdapter(final List<ToDoViewModel> viewModels) {
        if (viewModels != null) {
            this.models.addAll(viewModels);
        }
    }

    @NonNull
    @Override
    public ToDoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ToDoItemViewHolder(ToDoItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoItemViewHolder holder, int position) {
        // This is how we bind the UI to a specific task
        ToDoViewModel currentModel = models.get(position);

        //((ToDoItemViewHolder) holder).bind(currentModel.getTodoCreated());

        //How do I get the todo item to bind?
       ((ToDoItemViewHolder) holder).bind(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

}