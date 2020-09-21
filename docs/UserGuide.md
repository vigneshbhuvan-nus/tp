---
layout: page
title: User Guide
---

AddressBook Level 3 (AB3) is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AB3 can get your contact management tasks done faster than traditional GUI apps. In this UG, we will be assuming that you are practising Japanese (Hiragana).

- Table of Contents
  - [Quick start (WIP)](#quick-start-wip)
  - [Features (WIP)](#features-wip)
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

---

## Quick start (WIP)

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `addressbook.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   - **`list`**: Lists all contacts.

   - **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01`: Adds a contact named `John Doe` to the Address Book.

   - **`delete`**`3`: Deletes the 3rd contact shown in the current list.

   - **`clear`**: Deletes all contacts.

   - **`exit`**: Exits the app.

1. Refer to the [Features](#features) below for details of each command.

---

## Features (WIP)

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

- Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

- Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as `` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

- Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

</div>

### Viewing help: `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a new entry: `add`

Format: `add <STRING IN ENGLISH> | <STRING IN JAPANESE>`

Adds a new wntry to the word bank.

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

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

---

## FAQ (WIP)

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

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
