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

        LiveData<List<ToDo>> allTodos = ToDoRepository.getAllTodos();
        List<ToDo> allTodosList = (List<ToDo>) ToDoRepository.getAllTodos();

        //for (ToDo todo : ToDoRepository.getAllTodos()) {
        for (ToDo todo : allTodosList) {
            ToDoItemViewBinding todoBinding = ToDoItemViewBinding.inflate(inflater, binding.todoItemsLayout, true);
            todoBinding.setTodoTask(todo);

            (todoBinding.titleTextView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, todo.getTaskTitle(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
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