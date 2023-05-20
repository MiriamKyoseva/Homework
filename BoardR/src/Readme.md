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
CreateBoardItem ; hladilnik prazen ; 2023-05-30
```
```
Item was created: "hladilnik prazen", [Open | 2023-05-30]
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
Assignee was changed from me to you for task buy a banica
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
```
DisplayLocalHistory ; buy a banica
```
```
[2023-05-20 11:22:15] Item was created: Task "buy a banica", [To Do | 2023-05-30] Assignee: me
[2023-05-20 11:22:28] Assignee was changed from me to you for task "buy a banica"
[2023-05-20 11:22:42] Due Date for "buy a banica" was changed from 2023-05-30 to 2023-05-25
[2023-05-20 11:22:49] "buy a banica" status was changed from To Do to In Progress
[2023-05-20 11:22:57] "buy a banica" status was changed from In Progress to To Do
===
```
#### DisplayEventLog
```
DisplayEventLog
```
```
[2023-05-20 13:17:36] Item was created: "hladilnik prazen", [Open | 2023-05-30]
[2023-05-20 13:17:36] Item was created: Task "buy a banica", [To Do | 2023-05-30] Assignee: me
[2023-05-20 13:17:36] Item was created: Issue "banica", banica is gone [Open | 2023-05-30]
[2023-05-20 13:17:36] "banica" was changed to "voidd"
[2023-05-20 13:17:36] Assignee was changed from me to you for task "buy a banica"
[2023-05-20 13:17:36] Due Date for "buy a banica" was changed from 2023-05-30 to 2023-05-25
[2023-05-20 13:17:36] "buy a banica" status was changed from To Do to In Progress
[2023-05-20 13:17:36] "buy a banica" status was changed from In Progress to To Do
===
```
#### BoardAddItem
```
BoardAddItem ; voidd
```
```
"voidd" was added to the Board
```
#### BoardRemoveItem
```
BoardRemoveItem ; voidd
```
```
"voidd" was removed from the Board
```
#### BoardPrintList
```
BoardPrintList
```
```
"hladilnik prazen", [Open | 2023-05-30]
Task "buy a banica", [To Do | 2023-05-25] Assignee: you
===
```
#### BinPrintList
```
BinPrintList
```
```
Issue "voidd", banica is gone [Open | 2023-05-30]
===
```
#### ClearBin
```
Clear Bin
BinPrintList
```
```
Bin was emptied.
===
```
#### Exit
- Exit the program.