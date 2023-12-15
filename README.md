AI-Enhanced-Flashcards

AI-Enhanced Flashcards is a dynamic study tool that blends a user-friendly flashcard interface with AI-powered hints and analytics. Built on Firebase, it enables users to create, study, and track their learning with insights on time and hint usage, optimizing each study session.





Prerequisites


NOTE: I apologize in advance. Setting up the Firebase project instance may be a bit of a pain. If you get everything set up correctly, running this application should work great. But I get it can be a lot. I have provided a lot of 
YouTube tutorials are below if you get stuck. I have also created a YouTube video demo of my project just in case you want to check that out instead of setting things up. Thanks!  Video link: https://www.youtube.com/watch?v=6qvis2pEO0g

NOTE: my API key for Open Ai's language model may also expire by the time you get to run this. I have replaced it with a new one as of new to hopefully avoid this issue. 

Before installing and running the application, ensure you have the following prerequisites installed:

    1. Android Studio: The latest version of Android Studio, which includes all the necessary tools to build an Android app. You can download it from Android Studio. https://developer.android.com/studio

    2. Jetpack Compose: Jetpack Compose is integrated into Android Studio. Make sure you have the latest version of Android Studio to use Jetpack Compose.

    3.  Firebase Account and Setup: Since the application uses Firebase, you will need a Google account to access the Firebase Console and set up the necessary Firebase services for the application. Follow the detailed instructions in the 'Setting Up Firebase' section below.

    4. An Android Device or Emulator: To run the application, you will need either a physical Android device or an emulator set up in Android Studio.

    5. Kotlin SDK: the Kotlin plugin is usually included in Android Studio. However, if it's not installed or if an update is required, Android Studio will prompt you to download and install it. You can check the Kotlin version and update it via Tools -> Kotlin -> Configure Kotlin Plugin Updates in Android Studio.







Installation
Setting Up Android Studio and Jetpack Compose

    Install Android Studio: Download and install Android Studio from the official website.
    Configure Jetpack Compose:
        Open Android Studio.
        Create a new project or open an existing one.
        Ensure your project uses Jetpack Compose by checking the dependencies in your build.gradle file.



Setting Up Firebase Using Firebase Assistant in Android Studio

NOTE: Professor Ditton here at USU has created a great video on how to hook up your Firebase instance. Here is the link if that helps: https://usu.instructure.com/media_objects/m-MPKzwSdnhpYFpXK9BPL89c8A8E2qX58/redirect?bitrate=218043

Step 1: Open Firebase Assistant

    Open Android Studio: Start Android Studio and open your project.
    Access Firebase Assistant: Click on 'Tools' in the menu bar at the top, then select 'Firebase'. This will open the Firebase Assistant pane on the right side of the Android Studio window.

Step 2: Connect to Firebase

    Connect Your App to Firebase:
        In the Firebase Assistant pane, you will see a list of Firebase services.
        Select Cloud Firestore, and then select Get Started with Cloud Firestore
        Click on the link for the selected service, such as 'Get started with Cloud Firestore'. This will open a dialog to connect your app to a Firebase project.
        Either select an existing Firebase project or create a new one.
        You can follow the prompts to connect your app to the Firebase project.


NOTE: All SDKs should already be added since I added them in my code. But if you are lacking any, click the "Add the cloud Firestore SDK to your app" button that appears when you try to connect your app to Firebase. 










Download the Project. 

You can download this project in two different ways. 

1. By cloning my repo https://github.com/SatchelF/AI-Enhanced-Flashcards

2. Or download the code I submitted for this assignment. 




Opening the Project

Open the cloned project in Android Studio:

    Start Android Studio.
    Select 'Open an Existing Project' and navigate to your cloned repository.

Syncing and Building the Project

    Once the project is open in Android Studio, sync it with Gradle files by clicking 'Sync Now' in the toolbar.
    Build the project by selecting 'Build' > 'Make Project'.


Cloning the Repository

Clone the application repository to your local machine:

bash

git clone https://github.com/yourusername/your-app-name.git

Opening the Project

Open the cloned project in Android Studio:

    Start Android Studio.
    Select 'Open an Existing Project' and navigate to your cloned repository.

Syncing and Building the Project

    Once the project is open in Android Studio, sync it with Gradle files by clicking 'Sync Now' in the toolbar.
    Build the project by selecting 'Build' > 'Make Project'.





Running the Application
Using an Emulator

    Set Up an Emulator:
        In Android Studio, open the AVD Manager by clicking on 'Tools' > 'AVD Manager'.
        Create a new Virtual Device or select an existing one.
        Choose a device definition and a system image (preferably the latest API level).
        Finish the setup and launch the emulator.

    Run the Application:
        With the emulator open, run the application by clicking the 'Run' button in Android Studio.

Using an Android Device

    Enable Developer Options and USB Debugging:
        On your Android device, go to 'Settings' > 'About phone' and tap 'Build number' seven times to enable Developer Options.
        Return to the main Settings menu, then go to 'System' > 'Advanced' > 'Developer options'.
        Enable 'USB debugging'.

    Connect Your Device:
        Connect your Android device to your computer using a USB cable.
        Allow USB debugging access on your device if prompted.

    Run the Application:
        Android Studio should detect your device.
        Select your device from the target device dropdown.
        Click the 'Run' button in Android Studio to install and launch the application on your device.



Tutorials/Demos/Repos: 
Git repo: https://github.com/SatchelF/AI-Enhanced-Flashcards

Setting up emulator: https://www.youtube.com/watch?v=GhuiNcOEv1A

Download Andriod Studio: https://www.youtube.com/watch?v=DM783YA0vbc

Add firebase to Andriod Project: https://firebase.google.com/docs/android/setup

Professor Dittions Firebase Tutorial:  https://usu.instructure.com/media_objects/m-MPKzwSdnhpYFpXK9BPL89c8A8E2qX58/redirect?bitrate=218043

Demo of my project: https://www.youtube.com/watch?v=6qvis2pEO0g
