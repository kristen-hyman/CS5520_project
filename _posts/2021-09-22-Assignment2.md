TwoActivities Summary:

In this assignment, we learned how to create an app with multiple activities that connect and send information back and forth between eachother.
This is completed with the help of an `Intent` - which lets you interact with other components of the app. 

The code can be found here: https://github.com/kristen-hyman/CS5520_project/tree/main/TwoActivities

Screenshots:  
<img width="411" alt="HW 2 1 ENTERING MSG" src="https://user-images.githubusercontent.com/33691856/134414881-678cb284-7a0d-43e1-93de-56a46dc04801.png">
  
<img width="404" alt="HW 2 1 SENT" src="https://user-images.githubusercontent.com/33691856/134414899-2da4bcb7-eb3a-4015-9bd4-6744e9435fd0.png">



TwoActivitiesLifeCycle Summary:

Homework:
Question 1
If you run the homework app before implementing onSaveInstanceState(), what happens if you rotate the device? Choose one:
`The counter is reset to 0, but the contents of the EditText is preserved.`

Question 2
What Activity lifecycle methods are called when a device-configuration change (such as rotation) occurs? Choose one: 
` Android shuts down your Activity by calling onPause(), onStop(), and onDestroy(), and then starts it over again, calling onCreate(), onStart(), and onResume().`

Question 3
When in the Activity lifecycle is onSaveInstanceState() called? Choose one:
`onSaveInstanceState() is called before the onStop() method.`

Question 4
Which Activity lifecycle methods are best to use for saving data before the Activity is finished or destroyed? Choose one:
`onPause() or onStop()`
