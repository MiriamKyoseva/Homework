## BoardR
### Description
After finishing the required tasks for BoardR part 2 (EventLog class; features to Board) I decided to challenge myself to understand how Workshop - Cosmetics shop 1 works.
In particular, how the engine, commands, and commandFactory work.

There are 3 items that can be added to the Board:
- BoardItem
- Issue
- Task

I added 4 commands (for now) and I give examples for input and output.
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
- New title should not be the same as the current title.

```
ChangeItemTitle ; banica ; voidd
```
```
"banica" was changed to "voidd".
```
#### Exit
- Exit the program.