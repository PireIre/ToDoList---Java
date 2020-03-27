# USER MANUAL

This is the user manual for ToDo Application.

## 1.Main Menu

When the user starts the application, main menu is displayed:

> Welcome to TO-DO application
> Pending tasks: 7 | Completed tasks: 1
>
> Pick an option:
> ---------------------------------------------
> (1) Show Task List
> (2) Add New Task
> (3) Edit Task (remove, mark as done, update)
> (4) Save and Quit

On the top, user can see displayed number of tasks that
are pending and tasks that are already completed: 

> Pending tasks: 7 | Completed tasks: 1

If user selects an option that does not exist, a following message is displayed: 

> You have not entered a viable option. Let's try this again. 

If the user presses:

* 1: A Show menu is Displayed, which allows the user to sort 
list of tasks any way that is preferred 

* 2: User is able to add a new task 

* 3: an Edit Menu is Displayed with options on how to edit task.

* 4: The application quits and saves current list of tasks.

## 2. Show Menu: 

If user pressed (1), the show menu is displayed: 

> Here you can print list sorted by:
> (1): Print ALL
> (2): All tasks that are PENDING
> (3): All tasks that are DONE
> (4): Print task by PROJECT:
> (5): Due Date

List is printed in an order selected by the user.
(If 0 is pressed, user will go back to Main Menu)

Once list has been order, and once user presses Enter, the application returns to main menu. 

## 3. Add new Task

If the user pressed (2), he will start a process of adding a new
task into the list of tasks.

* Firstly, user will have to insert task title:
>Name of Task:
* Secondly user will assign this Task to a Project:
>Name of Project
* Lastly, user will need to correct the due date in correct format. 
>Due date? (MM-dd-yyyy)

If format is not correct, the application will report:
> Input of date was in wrong format. REQUIRED FORMAT: (MM-dd-yyyy) 

until the user enters "Due Date" in correct format. 

## 4. Edit Menu

Upon pressing (3) in Main Menu, user will be given following options: 

> Press (1) for removing items from the list
> Press (2) for marking tasks as done
> Press (3) for updating tasks

* If 0 is pressed, user will go back to Main Menu

* If user presses (1), the following message will appear.

>What of the below project do you want to delete? 

> 1. Example 1
> 2. Example 2

> Enter the number in front of the task you would like to delete

When user does not enter any of the number displayed, appropriate message will be displayed until he enters valiable number: 
> Task with selected index does not exist. Select number in front of task again:

When he selects valiable number, task will get removed. 

* If user presses (2), the following message will appear.

> What task do you want to mark as done?
> 1. Example 1         
> 2. Example 2            
>            
> Enter the number in front of the task

If user does not enter valiable index, same message will appear as it did before. 

When user enters valiable index, that task's status will be changed to DONE.


* If user presses (3), the he will be taken to Update Menu:

### 4.1. Update Menu

Update menu looks like this: 

> Press (1) for editing task name
> Press (2) for editing project name of a specific task
> Press (3) for editing due date of a task

ALl options are based on the same principle. Firstly, list of tasks will appear with indexes. Based on the selected index from the user, he/she will be able to change appropriate field. 
If 0 is pressed, user will go back to Main Menu

## 5. Save and Quit

If the user pressed (4) in Main Menu, the ToDo list will be saved in a file (This file will then be loaded when user starts the program from the beginning). Once the file is saved, program prints the following message and stops executing: 

> You have quit the application, your TO-DO list is saved.
> TASKS SAVED:

> * Example 1
> * Example 2

     