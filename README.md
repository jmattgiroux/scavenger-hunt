# Scavenger-Hunt


Program Description: 


Screenshots:

![ScreenShot 1](https://github.com/jmattgiroux/scavenger-hunt/blob/master/Screenshot1.png)

![Screenshot 2](https://github.com/jmattgiroux/scavenger-hunt/blob/master/Screenshot2.png)





Project Plan Document: https://drive.google.com/file/d/1AZamZZdtZesQSDiQNKk-OPkwCMsLyOcn/view?usp=sharing

Learning Resources: 
	https://developer.android.com/studio/run/emulator - Guide to using Android Virtual Device emulators.
	https://developer.android.com/guide - Great source for Android Studio tutorials and documentation.

Environment first time setup:

    1. Install software listed under "Development Environment Requirements" in this README file
	
	1.1 Complete this tutorial if you haven't used Android Studio before: https://developer.android.com/training/basics/firstapp
	1.2 An extra tutorial: https://codelabs.developers.google.com/codelabs/build-your-first-android-app/#0
	1.3 Link to a course: https://developer.android.com/courses/fundamentals-training/overview-v2
	
    2. Install Android Virtual Device according to AVDSetup screenshots in References/EnvironmentSetup/
	
    3. Follow steps under Environment Setup Cycle section in this README file
	
    4. Complete Collaboration tests in References/EnvironmentSetup/ 


Environment Setup Cycle:

    1. Pull from main branch through Git
	
    2. Open Android Studio wait for processes to happen (see the bottom bar for progress. 
	If any message shows up in the event log in red, post a screenshot on the team slack and try to fix it with google).
    
	3. Import Settings from settings zip if you haven’t already 
	(and that you have the right virtual device selected in the AVD manager) – restart if prompted.
    
	4. Update Android Studio, Gradle, etc, if prompted 
	(check the bottom bar of Android Studio for updates or messages).

    5. Wait for Indexing, Gradle to set up 
	(see the bottom bar to see the progress).

    6. Open emulator for the Android Virtual Device.

    7. Wait for processes to happen (see the bottom bar for progress. 
	If any message shows up in the event log in red, please post a screenshot 
	on the team slack and try to fix it with google).

    8. Run unit tests to see if update messed anything up 
	(if it does, post a screenshot on the team slack and try to fix it with google).

    9. Do test driven development until the feature is done 
	(Commit after writing the unit test, then after writing code that passes the unit test you wrote).

    10. After feature is implemented and passes all tests on your branch, pull from the main branch.

    11. Make sure all tests pass (both for your new feature and any new stuff you imported from main).

    12. Confirm with Team lead, then push to Main.

Development Environment Requirements:
Hardware Capabilities:

    8 gb ram recommended (for running the Android Virtual Device emulator)

    20 gb storage disk space recommended (1 Android Virtual Device alone can take up almost 10 gb of storage space)

Software Installed:

    git version 2.25.1 or later

    Android Studio version 4.0.2 or later
		Release Notes: https://developer.android.com/studio/releases
		Troubleshooting: https://developer.android.com/studio/troubleshoot

    openJDK version 11.0.8 or later (comes bundled with Android Studio)

