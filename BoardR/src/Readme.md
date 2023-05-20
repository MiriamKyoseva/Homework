## BoardR
### Description
After finishing the required tasks for BoardR part 2 (EventLog class; features to Board) I decided to challenge myself to understand how Workshop - Cosmetics shop 1 works.
In particular, how the engine, commands, and commandFactory work.

There are 3 items that can be added to the Board:
- BoardItem
- Issue
- Task

I added 10 commands (for now) and I give examples for input and output.
### Commands
#### CreateBoardItem 
Constrains:
- Title's length should be between 5 and 50 symbols.
- Title should not be the same as the title of existing item.
- Due Date should not be in the past.

```
CreateBoardItem ; banica ; 2023-05-30
```
```
Item was created: 'banica', [Open | 2023-05-30]
```
#### CreateTask
Constrains:
- Assignee's length of name should be between 2 and 30 symbols.
- Assignee in theory can be changed, but such a command isn't implemented yet.
```
CreateTask ; buy a banica ; me ; 2023-05-30
```
```
Item was created: Task "buy a banica", [To Do | 2023-05-30] Assignee: me
```
#### OpenIssue
Constrains:
- Description's length should be between 5 and 60 symbols.
- Description cannot be changed.
```
OpenIssue ; banica ; banica is gone ; 2023-05-30
```
```
Item was created: Issue "banica", banica is gone [Open | 2023-05-30]
```
#### ChangeItemTitle
Constrains:
- New title should not be the same as the current one.

```
ChangeItemTitle ; banica ; voidd
```
```
"banica" was changed to "voidd".
```
#### ChangeAssignee
Constrains:
- New assignee should not be the same as the current one.
```
ChangeAssignee ; buy a banica ; me ; you
```
```
Assignee was changed from teo to mei for task buy a banica
```
#### ChangeItemDueDate
```
ChangeItemDueDate ; buy a banica ; 2023-05-25
```
```
Due Date for "buy a banica" was changed from 2023-05-30 to 2023-05-25
```
#### AdvanceItemStatus
```
AdvanceItemStatus ; buy a banica
```
```
"buy a banica" status was changed from To Do to In Progress
```
#### RevertItemStatus
```
RevertItemStatus ; buy a banica
```
```
"buy a banica" status was changed from In Progress to To Do
```
#### ViewItemInfo
```
ViewItemInfo ; buy a banica
```
```
Task "buy a banica", [To Do | 2023-05-25] Assignee: you
```
#### DisplayLocalHistory
- Here for whatever reason the first log is flawed; Like, wtf. Assignee null. Gotta fix it, but it's 5 AM and I need sleep.
```
DisplayLocalHistory ; buy a banica
```
```
[2023-05-20 04:56:45] Item was created: Task "buy a banica", [Open | 2023-05-30] Assignee: null
[2023-05-20 04:56:45] Item was created: Task "buy a banica", [To Do | 2023-05-30] Assignee: me
[2023-05-20 04:57:03] Assignee changed from me to you
[2023-05-20 04:57:12] Due Date for "buy a banica" was changed from 2023-05-30 to 2023-05-25
[2023-05-20 04:57:55] "buy a banica" status was changed from To Do to In Progress
[2023-05-20 04:58:01] "buy a banica" status was changed from In Progress to To Do
===
```
#### Exit
- Exit the program.