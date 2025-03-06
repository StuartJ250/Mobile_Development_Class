
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

  **Recommited because last commit shows entire readme file instead of just part 4**


**Fixing broken code and crashes:**
- Removed a repeated method in ExcursionDetails.java on line 115
- Rearranged some code in ExcursionDetails.java to make it more organized
- Fixed save error in ExcursionDetails.java by moving variable from line 132 to line 138
- Removed spinner as it was causing issues and didn't need to use it in activity_excursion_details.xml
- Changed formatting of objects in activity_vacation_details.xml
- Added onResume to excursionDetails.java on line 208
- fixed syntax in VacationAdapter.java as it was causing dates to show as null, lines 73-74
- deleted item in menu_vacation_list.xml that wasnt used currently
- added intent.putExtra lines in VacationDetails.java on lines 92-94
- Rearranged code on VacationDetails.java
- Added validation code to dates on VacationDetails.java and ExcursionDetails.java
- Added lines of code to VacationList.java on lines 75-77

**Completing the Requirements**
- Completed B1 in previous Parts 1-4
- Completed B2 in previous parts 1-4
- Completed B3 parts a,b,g,h on Parts 1-4
- Completed B3 parts c,d, under "Fixing broken code and crashes:"
- Completed B4 in previous Parts 1-4
- Completed B5 part a,b,c,d in previous parts 1-4
- Added Delete functionality to ExcursionDetails.java on lines 210-220 completing B5 part b
- Added alert code to VacationDetails.java on lines 247-283, completing B3 part e
- Added share code to VacationDetails.java on lines 311-329, completing B3 part f
- B3 completed
- B5 part c, d completed in previous parts
- Fixed line 76 of ExcursionDetails.java to align with ExcursionAdapter.java Intent
- Fixed line 95 of VacationDetails.java to align with ExcursionAdapter.java and ExcursionDetails.java Intent
- B5 part e complete
- B5 complete
- C complete during parts 1-4
- D, E, and F will be created later
- Part D - Storyboard completed.
- 
