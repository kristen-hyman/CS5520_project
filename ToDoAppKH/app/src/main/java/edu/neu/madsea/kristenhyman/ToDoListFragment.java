package edu.neu.madsea.kristenhyman;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import edu.neu.madsea.kristenhyman.data.ToDoItemRecyclerViewAdapter;
import edu.neu.madsea.kristenhyman.data.ToDoRepository;
import edu.neu.madsea.kristenhyman.data.ToDo;
import edu.neu.madsea.kristenhyman.databinding.FragmentToDoListBinding;
import edu.neu.madsea.kristenhyman.databinding.ToDoItemViewBinding;

/**
 *  Adapted from Adrienne
 */
public class ToDoListFragment extends Fragment {

    private FragmentToDoListBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentToDoListBinding.inflate(inflater, container, false);
        ToDoRepository repository = ToDoRepository.getToDoRepository(binding.getRoot().getContext());
        LiveData<List<ToDo>> allTodos = repository.getAllTodos();

        //create adapter
        ToDoItemRecyclerViewAdapter adapter = new ToDoItemRecyclerViewAdapter();

        //observe allTodos because that is the LiveData. (populate list)
        //so when the data changes we can send this to the adapter to make the change on the view
        allTodos.observe(getViewLifecycleOwner(), list -> adapter.submitList(list));

        // connecting the adapter and the recycler view so the data shows up
        binding.todoItemsRecyclerview.setAdapter(adapter);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}