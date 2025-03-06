# VACATION PLANNER APPLICATION

## PURPOSE:

This project was to get myself aquainted to developing an application using a software development kit.

In this class, I learned:
  - How to build a basic android application
  - How to develop a GUI through the android SDK
  - How to build, manage and manipulate a database through the SDK
  - Utilize an emulator to run and troubleshoot mobile applications
  - How to sign an APK and deploy the application
What I created:
  - This application is a way to manage vacations and excursions.
  - It gives you the functionality to add as many vacations or excursions as you like.
  - It also gives you the ability to create notifications for those vacations and excursions
  - You can share details of your adventures to friends via the share feature in the application!

## DIRECTIONS:

1. From the home screen, click on the 'Enter' button on the bottom right to reach the Vacation List page.
2. On the Vacation List page, click the '+' button on the bottom right to progress to the Vacation Details page and add a new Vacation to the application. 
   - On the Vacation List page, you can add sample data to the application by clicking the top right menu button and selecting 'sample'
3. On the Vacation Details page you can:
   - Fill out the vacation details, including the name, hotel, start date and end date of the vacation.
   - Save the vacation using the top right menu button and selecting 'Save Vacation'
   - Share the vacation using the top right menu button and selecting 'Share Vacation'
   - Delete the vacation using the top right menu button and selecting 'Delete Vacation'
   - Create a notification for the start of the vacation by selecting the top right menu button and selecting 'Create Start Notification'
   - Create a notification for the end of the vacation by selecting the top right menu button and selecting 'Create End Notification'
4. Once you have completed these steps, on the Vacation Details page you can select the '+' button to progress to the Excursion Details page.
5. On the Excursion Details page, you can:
   - Complete the forms for an excursion, including the excursion name and date
   - Save the excursion using the top right menu button and selecting 'Save Excursion'
   - Share the excursion using the top right menu button and selecting 'Share Excursion'
     - You can also add a note that will be sent when you share the excursion.
   - Delete the excursion using the top right menu button and selecting 'Delete Excursion'
   - Create a notification for the excursion by selecting the top right menu button and selecting 'Create Notification'
6. Once completed, your excursions will be listed on the Vacation details page and will be selectable to edit or delete.
7. Vacations will be listed on the Vacations List page and will also be selectable to edit or delete.

## ANDROID VERSION

The signed APK is deployed with a minimum android version of 26 and a target android version of 35

## GIT REPOSITORY LINK

https://gitlab.com/wgu-gitlab-environment/student-repos/sja1383/d308-mobile-application-development-android.git
















[//]: # (**Part 1:** )

[//]: # ()
[//]: # (- Created UI Package)

[//]: # (- Created dao package)

[//]: # (- Put MainActivity.java in UI package)

[//]: # (- Created ExcursionDetails.java in UI Package)

[//]: # (- Created VacationList.java in UI package)

[//]: # (- Created VacationDetails in UI package)

[//]: # (- Created onOptionsItemsSelected method in VacationList.Java on line 49-67)

[//]: # (- Created FloatingActionButton and set onClickListener in MainActivity.java on lines 27-36)

[//]: # (- Created FloatingActionButton and set onClickListener in VacationList.java on lines 31-38)

[//]: # (- Updated themes.xml to show Action bar)

[//]: # (- Updated build.gradle:app with Room dependencies)

[//]: # (- Updated build.gradle:D308 Jacobson with RoomVersion)

[//]: # (- Updated AndroidManifest.xml with parentActivityName for each java file in UI package)

[//]: # (- Updated Layout on activity_vacation_list.xml)

[//]: # (- Updated Layout on activity_vacation_details.xml)

[//]: # (- Updated Layout on activity_main.xml)

[//]: # ()
[//]: # (**Part 2:**)

[//]: # ()
[//]: # (- Created entities package)

[//]: # (- Created database package)

[//]: # (- Created Excursion.java in entities package)

[//]: # (- Created Vacation.java in entities package)

[//]: # (- Created VacationDAO.java in dao package)

[//]: # (- created ExcursionDAO.java in dao package)

[//]: # (- Created VacationDatabaseBuilder in database package)

[//]: # (- Created Repository.java in database package)

[//]: # (- Added repository to VacationList.java on lines 24 and 58)

[//]: # (- Added template code to test database in VacationList.java on lines 58-69)

[//]: # ()
[//]: # (**Part 3:**)

[//]: # ()
[//]: # (- Created vacation_list_item.xml in layout package)

[//]: # (- Created excursion_list_item.xml in layout package)

[//]: # (- removed scrollview and linearlayout from activity_vacation_list.xml )

[//]: # (- Updated activity_vacation_details.xml with a scrollview and multiple textViews and EditTexts from line 11-96)

[//]: # (- Added recyclerview to activity_vacation_details.xml on lines 110-117)

[//]: # (- Added Recyclerview to activity_vacation_list.xml on lines 23-32)

[//]: # (- Created VacationAdapter.java in UI package)

[//]: # (- Created ExcursionAdapter.java in UI package)

[//]: # (- Added RecyclerView to VacationList.java on lines 45-51)

[//]: # (- Added code to show recyclerview, update, and save to vacation table on database to VacationDetails.java on lines 28-40, 48-121)

[//]: # (- added menu_vacation_details.xml to menu package)

[//]: # (- removed landscape xml files so i can refresh once code is complete)

[//]: # ()
[//]: # (**Part 4:**)

[//]: # ()
[//]: # (- Updated activity_excursion_details.xml to include detail form on lines 10-59)

[//]: # (- Added onOptionsItemSelected in ExcursionDetails.java on lines 137-193)

[//]: # (- Added inflator in ExcursionDetails.java on lines 132-135)

[//]: # (- Added variables in ExcursionDetails.java on lines 38-53)

[//]: # (- Added code for datePicker in ExcursionDetails.java on lines 60-123)

[//]: # (- Added updateLabelStart in ExcursionDetails.java on lines 126-130)

[//]: # (- Added code for delete menu item in VacationDetails.java on lines 122-142)

[//]: # (- Added onResume to VacationDetails.java on lines 146-158)

[//]: # (- Added 2 variables to VacationDetails.java on lines 34-35)

[//]: # (- Created menu_excursion_details.xml in menu package)

[//]: # (- Created MyReceiver.java in UI package)

[//]: # (- added numAlert variable to MainActivity.java on line 18)

[//]: # (- Added layout details to activity_excursion_details.xml on lines 9-74)

[//]: # ()
[//]: # (  **Recommited because last commit shows entire readme file instead of just part 4**)

[//]: # ()
[//]: # ()
[//]: # (**Fixing broken code and crashes:**)

[//]: # (- Removed a repeated method in ExcursionDetails.java on line 115)

[//]: # (- Rearranged some code in ExcursionDetails.java to make it more organized)

[//]: # (- Fixed save error in ExcursionDetails.java by moving variable from line 132 to line 138)

[//]: # (- Removed spinner as it was causing issues and didn't need to use it in activity_excursion_details.xml)

[//]: # (- Changed formatting of objects in activity_vacation_details.xml)

[//]: # (- Added onResume to excursionDetails.java on line 208)

[//]: # (- fixed syntax in VacationAdapter.java as it was causing dates to show as null, lines 73-74)

[//]: # (- deleted item in menu_vacation_list.xml that wasnt used currently)

[//]: # (- added intent.putExtra lines in VacationDetails.java on lines 92-94)

[//]: # (- Rearranged code on VacationDetails.java)

[//]: # (- Added validation code to dates on VacationDetails.java and ExcursionDetails.java)

[//]: # (- Added lines of code to VacationList.java on lines 75-77)

[//]: # ()
[//]: # (**Completing the Requirements**)

[//]: # (- Completed B1 in previous Parts 1-4)

[//]: # (- Completed B2 in previous parts 1-4)

[//]: # (- Completed B3 parts a,b,g,h on Parts 1-4)

[//]: # (- Completed B3 parts c,d, under "Fixing broken code and crashes:")

[//]: # (- Completed B4 in previous Parts 1-4)

[//]: # (- Completed B5 part a,b,c,d in previous parts 1-4)

[//]: # (- Added Delete functionality to ExcursionDetails.java on lines 210-220 completing B5 part b)

[//]: # (- Added alert code to VacationDetails.java on lines 247-283, completing B3 part e)

[//]: # (- Added share code to VacationDetails.java on lines 311-329, completing B3 part f)

[//]: # (- B3 completed)

[//]: # (- B5 part c, d completed in previous parts)

[//]: # (- Fixed line 76 of ExcursionDetails.java to align with ExcursionAdapter.java Intent)

[//]: # (- Fixed line 95 of VacationDetails.java to align with ExcursionAdapter.java and ExcursionDetails.java Intent)

[//]: # (- B5 part e complete)

[//]: # (- B5 complete)

[//]: # (- C complete during parts 1-4)

[//]: # (- D, E, and F will be created later)

[//]: # (- Part D - Storyboard completed.)

[//]: # (- Part E - Completed)

[//]: # (- Part F - Completed)
