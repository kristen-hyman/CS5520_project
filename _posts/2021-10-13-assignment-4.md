# Updated To-Do App

This week, I refactored my To-Do App code to follow the recommended app architechture:

<img width="566" alt="Screen Shot 2021-10-13 at 3 40 19 PM" src="https://user-images.githubusercontent.com/33691856/137222324-005b894e-7c45-49f8-a734-eb66507c55ae.png">

I made the following updates to the code:

- Set up data binding in app (added to gradle file)
- Created a ToDo class and a repository that holds a collection of ToDos that can be added to
- Set up view model (which uses the repository - it can read and write to the repository)
    - When you want to persist to a database, you can do it in view model
- Set up all of UI components to use the view model
- Set up fragment/activity to use view model and binding.
    - XML and java classes are now putting data in the view model and reading from the view model NOT passing by bundles or intents. 

After making these updates, my app followed the suggested architecture, but did not implement a database. The next step I took was to update the repository
of data to instead utilize a Room database for persistence. 
