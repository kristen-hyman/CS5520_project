package edu.neu.madsea.kristenhyman.data;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.neu.madsea.kristenhyman.databinding.ProjectItemViewBinding;

/**
 * adapted from Adrienne
 * https://github.com/ahope/cs5520_project/blob/main/todo-list/app/src/main/java/edu/northeastern/cs5520/todo_adrienne/data/
 */

/**
 * This class holds the data collection, and allows the data to be mapped to the ViewHolder.
 * In this case, it "knows" the ToDoRepo (or, some collection of Project objects), and when is appropriate,
 * maps a specific Project object to a ViewHolder to display that Project instance.
 * The adapter binds the view model to the view.
 */
public class ProjectItemRecyclerViewAdapter extends ListAdapter<Project, ProjectItemViewHolder> {

    public ProjectItemRecyclerViewAdapter() {
        super(new ProjectDiff());
    }

    /**
     * RecyclerView calls this method whenever it needs to create a new ViewHolder.
     * The method creates and initializes the ViewHolder and its associated
     * View, but does not fill in the view's contents -
     *  the ViewHolder has not yet been bound to specific data.
     */
    @NonNull
    @Override
    public ProjectItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectItemViewHolder(ProjectItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),
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
    public void onBindViewHolder(@NonNull ProjectItemViewHolder holder, int position) {
        // This is how we bind the UI to a specific task
        holder.bind(getItem(position));

        //ProjectViewModel currentModel = models.get(position);
        //((ProjectItemViewHolder) holder).bind(currentModel.getProjectCreated());
       //((ProjectItemViewHolder) holder).bind(models.get(position));
    }



    public static class ProjectDiff extends DiffUtil.ItemCallback<Project> {

        @Override
        public boolean areItemsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Project oldItem, @NonNull Project newItem) {
            return oldItem.getArtistName().equals(newItem.getArtistName());
        }

    }

}