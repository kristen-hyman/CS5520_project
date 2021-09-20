# Assignment 1


Lesson 1.1 main takeaways:

1. All code and resources for the app are located within the app and res folders. The res folder holds resources, such as layouts, strings, and images. 
2. String resources allow for you to quickly/easily avoid using magic strings and ensure that you only have to change hard-coded strings in one place.
3. You must edit the AndroidManifest.xml file to add features components and permissions to your Android app. 
4. You can use the Emulator to create a virtual device to run your app. The emulator shows you what the formating/functionality will look like on an actual device.

Lesson 1.1 Github Link:

Lesson 1.1 Screenshot:
<img width="750" alt="HW 01 1 - Hello World App Screenshot" src="https://user-images.githubusercontent.com/33691856/134040130-fa75cd8a-239f-4c71-8aaf-aa14bf2809bb.png">

Lesson 1.1 HW Questions:

Question 1
What is the name of the layout file for the main activity?
activity_main.xml

Question 2
What is the name of the string resource that specifies the application's name?
app_name


Question 3
Which tool do you use to create a new emulator?
AVD Manager

Question 4
Assume that your app includes this logging statement:
Log.i("MainActivity", "MainActivity layout is complete");
You see the statement "MainActivity layout is complete" in the Logcat pane if the Log level menu is set to which of the following? (Hint: multiple answers are OK.)
Verbose
Debug


Lesson 1.2A/1.2B takeaways:
1.  A LinearLayout is one of the most common layouts as it is easy to use. It is often used to arrange UI elements horizontally or vertically.
2.  A RelativeLayout allows for views to be positioned/aligned relative to eachother.
3.  You can use the Orientation in Editor button and to create a Landscape Variation. A new layout file is created for the new orientation.


Lesson 1.2A/1.2B Github Link:

Lesson 1.2A/1.2B Screenshot:
<img width="405" alt="HW 01 2 - Linear Layout" src="https://user-images.githubusercontent.com/33691856/134043289-641ffa85-2187-4205-813f-66c62f042b07.png">


Lesson 1.2A/1.2B HW Questions:
Question 1
Which two layout constraint attributes on the Zero Button position it vertically equal distance between the other two Button elements? (Pick 2 answers.)

app:layout_constraintBottom_toTopOf="@+id/button_count"
app:layout_constraintTop_toBottomOf="@+id/button_toast"

Question 2
Which layout constraint attribute on the Zero Button positions it horizontally in alignment with the other two Button elements?
app:layout_constraintLeft_toLeftOf="parent"

Question 3
What is the correct signature for a method used with the android:onClick XML attribute?
public void callMethod(View view)

Question 4
The click handler for the Count Button starts with the following method signature:
public void countUp(View view)

Which of the following techniques is more efficient to use within this handler to change the Button element's background color? Choose one:
Use the view parameter that is passed to the click handler with setBackgroundColor(): view.setBackgroundColor()


Lesson 1.3 takeaways:
1. You can use a ScrollView to scroll a single View (such as a TextView).
2. You can nest a ViewGroup such as LinearLayout within the ScrollView, which allows you to scroll everything that is inside the LinearLayout.

Lesson 1.3 Github Link:

Lesson 1.3 Screenshots:
<img width="470" alt="HW 01 3 - Scrolling" src="https://user-images.githubusercontent.com/33691856/134054619-386baeed-3e94-4095-9c92-60807e3c6350.png">
<img width="467" alt="HW 01 3 - TextView" src="https://user-images.githubusercontent.com/33691856/134054633-bbb96c91-3f62-48d5-bbca-d6209a78e7eb.png">


Lesson 1.3 HW Questions:
