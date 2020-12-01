# CE-Projekt (UE05-07)

## Step 1: Setting up your environment

Get the application here: [Git](https://github.com/Waldpilzchen/CE05.git)
For this application to work on your PC/Laptop etc. you need to have a few things installed first.

- Java

- Maven

- Node.js

If you have already installed all three of those you can skip this step. If not here a three links, that help you find and install all of them.

- [Java](https://www.java.com/de/download/help/download_options.html#windows)

- [Maven](https://maven.apache.org/install.html)

- [Node.js](https://nodejs.org/en/download/)

It's also in your best interest to install a Java-IDE (eg. Visual Studio Code, Eclipse or IntelliJ). If you don't have one of those installed here are three more links that you will find helpful.

- [IntelliJ](https://www.jetbrains.com/idea/)

- [Visual Studio Code](https://code.visualstudio.com/)

- [Eclipse](https://www.eclipse.org/downloads/)



## Step 2: Starting up the backend

For the Web/Console Client to work, a few things need to be started beforehand. 

1. Open the folder "FahrradherstellerParent" in the IDE of you choice.

2. Wait a moment until the IDE built the project with maven.

3. Run /Fahrradhersteller/scr/main/java/at/jku/ce05/fahrradhersteller/FahrradherstellerApplication.java using the IDE

4. Run /FIBU/scr/main/java/at/jku/ce05/server/FIBUConfigurationRunServer.java using the IDE

5. Open the folders "Lieferant1" and "Lieferant2 " in the IDE of you choice.

6. Wait a moment until the IDE built the project with maven.

7. Run /Lieferant1/src/main/java/Lieferanten/LieferantenApplication.java using the IDE

8. Run /Lieferant2/src/main/java/Lieferanten/LieferantenApplication.java using the IDE

If you did all these steps you have successfully started all the backend components of the system.

## Step 3: Using the Console and Web Client

If you finished "Step 2" you can start the Console or the Web Client.

### Console Client

1. Open the Folder "ConsoleHttpClient" in the IDE of your choice.

2. Let the application be built by the IDE.

3. Run /ConsoleHTTPClient/src/main/java/BikeConfigurationClient.java

4. Use the Client

### Web Client

1. If you installed Visual Studio Code open the folder "/WebHTTPClient/webHTTPClient" with it.

2. If open you Terminal/CMD/bash/... and navigate to this folder.

3. Type in `npm install`

4. Wait until it's finished

5. To run the Client type in `npm run dev`

6. Use the Client
