### Practical Task description
Develop a TODO list application that hs the following features:

1. User is able to create a new TODO list entry 
2. User is able to delete or check existing TODO entries
3. User is able to see Detailed description of TODO entry on a new screen
4. On a Detailed screen User can share the TODO entry to Twitter or Google Keep
5. User is able to access application Preference screen
6. User is able to select a color of his TODO list in application Preferences that will be stored after app exit

** Some more test cases and conditions **
* Device rotation on list screen doesn't change the list
* Strict Mode reports no errors
 
###---------(3 points)------------

7. TODO list items should be stored in the Device Storage: a file, Preferences or a database
  * All IO is executed asynchronously 

###---------(4 points)------------

8. Optional: On a Detailed screen User can edit TODO entries message
9. Optional: On a Detailed screen User can take a photo and attach it to the TODO entry
10. Optional: User should see attached picture in TODO list on Main Screen

** Some more test cases and conditions **
* Changes made on Detailed screen are reflected on list screen. Even if the device is rotated during editing.
* The list and the Detailed screen are implemented as Fragments. In Landscape mode both fragments are displayed simultaneosly, forming a Master-Detail view 


###---------(5 points)------------
11. Optional: Configure Firebase connection + authentication

###---------(6 points)------------
