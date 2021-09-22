TwoActivities Summary:

In this assignment, we learned how to create an app with multiple activities that connect and send information back and forth between eachother.
This is completed with the help of an `Intent` - which lets you interact with other components of the app. 

The code can be found here: https://github.com/kristen-hyman/CS5520_project/tree/main/TwoActivities

Screenshots:  
<img width="411" alt="HW 2 1 ENTERING MSG" src="https://user-images.githubusercontent.com/33691856/134414881-678cb284-7a0d-43e1-93de-56a46dc04801.png">
  
<img width="404" alt="HW 2 1 SENT" src="https://user-images.githubusercontent.com/33691856/134414899-2da4bcb7-eb3a-4015-9bd4-6744e9435fd0.png">



TwoActivitiesLifeCycle Summary:
In this assignment, we navigated between activities and inside and outside of our app, to view different states in the Activity lifecycle. 
The lifecycle methods are onCreate(), onStart(), onPause(), onRestart(), onResume(), onStop(), onDestroy().
A key point noted in this assignment is that when orientation changes, sometimes activity data can be lost. To avoid this, you can
restore the instance state in onCreate().


Homework:
Github: https://github.com/kristen-hyman/CS5520_project/tree/main/CounterHomework

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

Implicit Intents Summary:
In this homework, we used implicit intent to activate an Activity if we knew the action, but not the specific app or Activity that would handle that action.
 If there is more than one available Activity that can handle the action, the system provides a chooser so the user can pick one.

Screenshots:  
<img width="404" alt="Screen Shot 2021-09-22 at 2 24 22 PM" src="https://user-images.githubusercontent.com/33691856/134424340-9be65340-b03c-4375-a403-e6f075e57e56.png">
  
<img width="403" alt="Screen Shot 2021-09-22 at 2 21 49 PM" src="https://user-images.githubusercontent.com/33691856/134424348-6d0fb43d-17f4-4b67-a12d-91e575e5e080.png">




