# Updated To-Do App

This week, I refactored my To-Do App code to follow the recommended app architechture:

<img width="566" alt="Screen Shot 2021-10-13 at 3 40 19 PM" src="https://user-images.githubusercontent.com/33691856/137222324-005b894e-7c45-49f8-a734-eb66507c55ae.png">

I made the following updates to the code:

- Set up data binding in app (added to gradle file)
- Created a ToDo class and a repository that holds a collection of ToDos that can be added to
- Set up the view model (which uses the repository - it can read and write to the repository)
    - When you want to persist to a database, you can do it in view model
- Set up all of UI components to use the view model
- Set up fragment/activity to use view model and binding.
    - XML and java classes are now putting data in the view model and reading from the view model NOT passing by bundles or intents. 

After making these updates, my app followed the suggested architecture, but did not implement a database. The next step I took was to update the repository
of data to utilize a Room database for persistence. 

I am currently working on completing this update. So far, I have created the ToDoDatabase and ToDoDao. I also updated the ToDoRepository to connect to the room database (ToDoDatabase) to obtain data. 

I am having trouble ensuring that my ToDoItemRecyclerViewAdapter is implemented correctly. I struggled with updating this class to work with the database updates. Specifically, I struggled with fully understanding what the constructor was doing as well as with implementing the onBindViewHolder() function. I also am getting an error in the MainActivity_ListView on my application:
`java.lang.NullPointerException: Attempt to invoke virtual method 'void androidx.lifecycle.LiveData.observe(androidx.lifecycle.LifecycleOwner, androidx.lifecycle.Observer)' on a null object reference at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3639)`

This error is referring to this line of code:
```
        mToDoViewModel.getAllToDos().observe(this, todos -> {
            adapter.submitList(todos);
        });
 ```
 
I have tried working through debugging to see why I am getting this null pointer exception but have come to a roadblock. I am planning to continue reviewing my code and trying to debug until I can go to OH to get some additional support.
