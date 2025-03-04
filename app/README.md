
**Part 1:** 

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

**Part 2:**

- Created entities package
- Created database package
- Created Excursion.java in entities package
- Created Vacation.java in entities package
- Created VacationDAO.java in dao package
- created ExcursionDAO.java in dao package
- Created VacationDatabaseBuilder in database package
- Created Repository.java in database package
- Added repository to VacationList.java on lines 24 and 58
- Added template code to test database in VacationList.java on lines 58-69

**Part 3:**

- Created vacation_list_item.xml in layout package
- Created excursion_list_item.xml in layout package
- removed scrollview and linearlayout from activity_vacation_list.xml 
- Updated activity_vacation_details.xml with a scrollview and multiple textViews and EditTexts from line 11-96
- Added recyclerview to activity_vacation_details.xml on lines 110-117
- Added Recyclerview to activity_vacation_list.xml on lines 23-32
- Created VacationAdapter.java in UI package
- Created ExcursionAdapter.java in UI package
- Added RecyclerView to VacationList.java on lines 45-51
- Added code to show recyclerview, update, and save to vacation table on database to VacationDetails.java on lines 28-40, 48-121
- added menu_vacation_details.xml to menu package
- removed landscape xml files so i can refresh once code is complete

**Part 4:**

- Updated activity_excursion_details.xml to include detail form on lines 10-59
- Added onOptionsItemSelected in ExcursionDetails.java on lines 137-193
- Added inflator in ExcursionDetails.java on lines 132-135
- Added variables in ExcursionDetails.java on lines 38-53
- Added code for datePicker in ExcursionDetails.java on lines 60-123
- Added updateLabelStart in ExcursionDetails.java on lines 126-130
- Added code for delete menu item in VacationDetails.java on lines 122-142
- Added onResume to VacationDetails.java on lines 146-158
- Added 2 variables to VacationDetails.java on lines 34-35
- Created menu_excursion_details.xml in menu package
- Created MyReceiver.java in UI package
- added numAlert variable to MainActivity.java on line 18
- Added layout details to activity_excursion_details.xml on lines 9-74


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