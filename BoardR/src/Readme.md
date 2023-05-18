## BoardR
### Description
After finishing the required tasks for BoardR part 2 (EventLog class; features to Board) I decided to challenge myself to understand how Workshop - Cosmetics shop 1 works.
In particular, how the engine, commands, and commandFactory work. 

I added 2 commands (for now) and I give examples for input and output.
### Commands
#### CreateBoardItem 
Constrains:
- Title's length should be between 5 and 50 symbols.
- Title should not be the same as the title of existing item.
- Due Date should not be in the past.

```
CreateBoardItem banica 2023-10-10
```
```
Item 'banica', [Open | 2023-10-10] was created.
```
#### ChangeItemTitle
Constrains:
- New title should not be the same as the current title.

```
ChangeItemTitle banica banic
```
```
"banica" was changed to "banic".
```
#### Exit
- Exit the program.