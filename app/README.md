
B.  Create an Android mobile application, compatible with Android 8.0 and higher. The application must use the Room Framework as an abstraction layer over the local SQLite database to save the data. The application must include the following functional requirements:

- Created UI Package
- Created dao package
- Put MainActivity.java in UI package
- Created ExcursionDetails.java in UI Package
- Created VacationList.java in UI package
- Created VacationDetails in UI package
- Created onOptionsItemsSelected method in VacationList.Java on line 49-67
- Created FloatingActionButton and set onClickListener in MainActivity.java on lines 27-36
- Created FloatingActionButton and set onClickListener in VacationList.java on lines 31-38
- Updated themes.xml to show Action bar
- Updated build.gradle:app with Room dependencies
- Updated build.gradle:D308 Jacobson with RoomVersion
- Updated AndroidManifest.xml with parentActivityName for each java file in UI package
- Updated Layout on activity_vacation_list.xml
- Updated Layout on activity_vacation_details.xml
- Updated Layout on activity_main.xml
- 
    1.  Create a user option to enter, update and delete vacations.

        a.  Allow the user to add as many vacations as desired.

        b.  Implement validation so that a vacation cannot be deleted if excursions are associated with it.


    Note: The vacations and excursions are not pre-populated in the database, but are instead added by the user.


    2.  Include the following details for each vacation:

        •  title (e.g., Bermuda Trip, Spring Break, London Trip)

        •  hotel or other place where you will be staying

        •  start date

        •  end date

    3.  Include features that allow the user to do the following for each vacation:

        a.  Display a detailed view of the vacation, including all vacation details. This view can also be used to add and update the vacation information.

        b.  Enter, edit, and delete vacation information.

        c.  Include validation that the input dates are formatted correctly.

        d.  Include validation that the vacation end date is after the start date.

        e.  Include an alert that the user can set which will trigger on the start and end date, displaying the vacation title and whether it is starting or ending.

        f.  Include sharing features so the user can share all the vacation details via a sharing feature (either e-mail, clipboard or SMS) that automatically populates with the vacation details.

        g.  Display a list of excursions associated with each vacation.

        h.  Add, update, and delete as many excursions as needed.

    4.  Include the following details for each excursion:

        •  The excursion title (e.g., Snorkeling, Hiking, Bus Tour, Cooking Lesson)

        •  The excursion date

    5.  Include features that allow the user to do the following for each excursion:

        a.  Display a detailed view of the excursion, including the title, and date

        b.  Enter, edit, and delete excursion information.

        c.  Include validation that the input dates are formatted correctly.

        d.  Include an alert that the user can set that will trigger on the excursion date, stating the excursion title.

        e.  Include validation that the excursion date is during the associated vacation.


    Note: If you do not commit with a message and push when you complete each of the tasks listed above, you will have to decompose their application to make the commits and pushes, even if it is already complete.


C.  Design the application to include the following information, including appropriate GUI (graphical user interface) elements (e.g., navigation, input, and information) for each layout:

    •  home screen

    •  list of vacations

    •  list of excursions associated with a vacation

    •  detailed vacation view

    •  detailed excursion view


D.  Create a storyboard to demonstrate application flow that includes each of the menus and screens from part B.


E.  Provide screenshots of generating the signed APK to demonstrate that you have created a deployment package. Include the signed APK file with your submission.


    Note: Verify that all the required functions of your application are working by executing the APK file. If the app is modified, regenerate the APK so it includes all the revisions.


F.  Create a Readme file including:

    •  title and purpose of the application

    •  directions for how to operate the application and reach all the rubric aspects

    •  to which android version the signed APK is deployed

    •  a link to the git repository


G.  Demonstrate professional communication in the content and presentation of your submission.