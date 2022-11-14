# Pre-Conditions

In case you want to run the tests written for Daft assignment please:

- Install Java (Jdk or Jre at least version 8 - reference https://www.oracle.com/ie/java/technologies/javase/javase8-archive-downloads.html)
- Install any of the Java Ide's (Eclipse, IntellyJ or NetBeans)
- Install Maven managment system (unless you have Eclipse IDE with Maven built in plugin) official reference: https://maven.apache.org/download.cgi


### After pre-conditions are completed:
- download (zip file)/ or clone the framework from git repository
- unpack the framework (if you have chosen the download option)
- open the you own IDE preference and open the cloned or unziped project
- navigate to the pom.xml file and click load button (mostly in the top right corner of the IDE's) - that allows you to download all the dependencies that will be used in the framework (dependencies are all needed jars and libraries needed for that project to be run on the IDE)
- once all the dependencies are downloadted navigate to the src/test/DaftTest/DaftE2ETest file and run the test (click play button in top right corner or right click mouse and run the test)
- The test will run and browser will open runing automating process presented in the test description
-  Test results can be found in few places, but the easiest one is in the:
   a) root direction/ Test.pdf,
   b) the other one is placed in the html report in the root/reports/date/*.html


### Test Description - test case:

User is to open Daft homepage (www.daft.ie ),
search for a Sale Ad in county Dublin,
check that there are results for this location,
apply the “garage” keyword filter,
check that there are results for that filter,
then open one search result to check that the filter was applied correctly
(check that the “garage” keyword is there on that advert).

### In the testng.xml file we can provide what browser we will use to run the test, also we can set the parallel testing in that file and other settings.

### Additional functionality added to that framework like: - date Driven testing etc. but that is not the purpose of that assignment


