# User Guide
Team Name: AY2021S1-CS2103T-T09-4

GrrenTea is a **desktop app for learning a new language, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AB3 can get your contact management tasks done faster than traditional GUI apps. In this UG, we will be assuming that you are practising Japanese (Hiragana).

- Table of Contents
  - [Viewing help: help](#viewing-help-help)
  - [Adding a new entry: add](#adding-a-new-entry-add)
  - [Listing all entries: list](#listing-all-entries-list)
  - [Editing an entry: edit](#editing-an-entry-edit)
  - [Deleting an entry: delete](#deleting-an-entry-delete)
  - [Clearing all entries: clear](#clearing-all-entries-clear)
  - [Exiting the program: exit](#exiting-the-program-exit)
  - [Saving the data](#saving-the-data)
  - [FAQ (WIP)](#faq-wip)
  - [Command summary](#command-summary)


### Viewing help: `help`

Shows a message explaining how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a new entry: `add`

Format: `add <STRING IN ENGLISH> | <STRING IN JAPANESE>`

Adds a new entry to the word bank.

Examples:

- `add Hello | おはようございます`
- `add Why aren’t they here yet? | どうして彼らはまだここにいないの`

### Listing all entries: `list`

Format: `list`

Lists all entries in the word bank with their respective indexes.

### Editing an entry: `edit`

Format: `edit <INDEX> [e/<STRING IN ENGLISH>] [f/<STRING IN JAPANESE>]`

Edits the entry whose index is `INDEX`, replacing its original English string with `<STRING IN ENGLISH>` and its original Japanese string with `<STRING IN JAPANESE>`. Note that you may provide either `<STRING IN ENGLISH>` or `<STRING IN JAPANESE>`, or both and only the one(s) provided will replace the original(s).

**Note:** to get the indexes of the entries, you may run `list` - the index of each entry is shown beside its respective entry in the output of running the `list` command.

Examples:

- `edit 1 [e/Cup]` edits the English string to `Cup` of `entry#1`.
- `edit 2 [e/Book] [f/ほん]` edits the English string to `Book` and the Japanese string to `ほん` of `entry#2`.

### Deleting an entry: `delete`

Format: `edit <INDEX>`

Delete the entry whose index is `INDEX`.

**Note:** to get the indexes of the entries, you may run `list` - the index of each entry is shown beside its respective entry in the output of running the `list` command.

Examples:

- `edit 1 [e/Cup]` edits the English string to `Cup` of `entry#1`.
- `edit 2 [e/Book] [f/ほん]` edits the English string to `Book` and the Japanese string to `ほん` of `entry#2`.

### Clearing all entries: `clear`

Format: `clear`

Deletes all entries from the word bank.

### Exiting the program: `exit`

Format: `exit`

Exits the program.

### Saving the data

Entries ares saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

---

## FAQ (WIP)

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous GreenTea home folder.

---

## Command summary

| Action     | Format, Examples                                                                                                      |
| ---------- | --------------------------------------------------------------------------------------------------------------------- |
| **Add**    | `add <STRING IN ENGLISH> | <STRING IN JAPANESE>` <br> e.g., `add Hello | おはようございます`                          |
| **Clear**  | `clear`                                                                                                               |
| **Delete** | `delete INDEX`<br> e.g., `delete 3`                                                                                   |
| **Edit**   | `edit <INDEX> [e/<STRING IN ENGLISH>] [f/<STRING IN JAPANESE>]`<br> e.g.,`edit 1 [e/Cup]`, `edit 2 [e/Book] [f/ほん]` |
| **List**   | `list`                                                                                                                |
| **Help**   | `help`                                                                                                                |
