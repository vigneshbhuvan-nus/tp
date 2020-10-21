# User Guide
Team Name: AY2021S1-CS2103T-T09-4 Since: August 2020

## Table of Contents
  1. [What is GreenTea?](#1-what-is-greentea)
  2. [About This Document](#2-about-this-document)
  3. [Quick Start](#3-quick-start)
  4. [Deck Commands](#4-deck-commands)
     1. [Creating a New Deck](#creating-a-new-deck-new)
     2. [Deleting a Deck](#deleting-a-deck)
     3. [Selecting a Deck](#selecting-a-deck)
     4. [Clearing all Decks](#clearing-all-decks)
  5. [Entry Commands](#5-entry-commands)
     1. [Adding an Entry](#adding-a-new-entry)
     2. [Editing an Entry](#editing-an-entry)
     3. [Deleting an Entry](#deleting-an-entry)
  6. [Play Commands](#6-play-commands)
  7. [Statistics Commands](#7-play-commands)
  8. [Extra Commands](#8-extra-commands)
  8. [Data Sharing](#9-exit-commands)
  9. [Command Summary](#10-command-summary)
  10. [FAQ](#11-faq)
  
## 1. What is GreenTea? (Gabriel)

GreenTea is a **desktop app for learning a new language, optimized for use via a Command Line Interface** (CLI) while 
still having the benefits of a Graphical User Interface (GUI). It adopts the Leitner flashcard system, a proven method
to helps users retain memory in the context of learning a new language. This app is perfect for users who wish to 
optimise their time learning a new language. In this User Guide (UG), you will learn about the various commands and 
actions that would allow you to use GreenTea seamlessly.

## 2. About This Document (Gabriel)

Welcome to the GreenTea User Guide!

I am proud that you have taken your first few steps towards optimising your learning. We at GreenTea know that
learning a new language can be __hard__ and __intimidating__. Trust us when we say we know __exactly__ what you're
going through and we feel __frustrated__ just as much you do. 

That's why here at GreenTea, we have come up with this neat little
user guide to help __you__ hit the ground running. With this foolproof User Guide, learning a new 
language will be as relaxing as drinking a hot cup of Green Tea.

## 3. Quick Start (Gabriel)

Before you can start using GreenTea, you will need to ensure that [Java 11](https://www.java.com/en/)
is installed on your computer. 

To start using GreenTea: 

1. Download the latest jar file [here](https://github.com/AY2021S1-CS2103T-T09-4/tp/releases/new)
2. Copy the jar file to your folder of choice (we recommend on your desktop!)
3. Double-Click the file to start the application! 

## 4. Deck Commands (Gabriel)

Decks are the foundation to GreenTea. A deck is simply a list of translation
you write into GreenTea. A deck can be your favourite Chinese idioms, a list of beverages in Japanese,
or even some romantic phrases in French!

### Creating a new deck: `new`

Creates a new deck that can store entries of word-translation pairs.

Format: `new <NAME OF NEW DECK`

Examples: - `new Japanese-Animals`

### Removing a deck: `remove`

Removes a particular deck from GreenTea

Format: `remove <INDEX OF DECK>`

**Note:** to get the index of a deck, you may view it on the GUI. It would be the number displayed beside a particular deck

Examples: `remove 1`


### Selecting a deck: `select`

Selects a deck to perform deck-level operations on

Format: `select <INDEX OF DECK>`

**Note:** to get the index of a deck, you may view it on the GUI. It would be the number displayed beside a particular deck

Examples: `select 1`


## 5. Entry Commands (Gabriel)

Entries are what make up a deck. They are the words or phrases that you wish to memorise in GreenTea.
An entry is made up of two parts; the `word` and the `translation`. The `word` is written in the 
language you are most familiar and the `translation` is written in the language you wish to learn. In 
this User Guide, we will be assuming the language for `word` will be in English.

Fun fact: Did you know GreenTea supports over 100 languages including Telugu, Welsh and Xamtanga? To
see if your chosen language is supported, click [here!](http://www.unicode.org/charts/index.html)

### Adding a new entry: `add`

Adds a new entry to the word bank.

Format: `add w/<WORD> t/<TRANSLATION>`

Examples:

- `add w/Fruits t/果物`
- `add w/Why aren’t they here yet? t/どうして彼らはまだここにいないの`

### Listing all entries: `list`

Lists all entries in the word bank with their respective index.

Format: `list`

### Editing an entry: `edit`

Edits an entry whose index is `<INDEX>`, replacing the original word with `<WORD>` and its translation with `<TRANSLATION>`.
You may provide either `<WORD>` or `<TRANSLATION>`, or both and only the one(s) provided will replace the original(s).

Format: `edit <INDEX> w/<WORD> t/<TRANSLATION>` OR `edit <INDEX> w/<WORD>` OR `edit <INDEX> t/<TRANSLATION>`

**Note:** to get the index of an entry, you may run `list` - the index would be shown beside its respective entry

Examples:

- `edit 1 w/hello` edits the word in  `entry#1` to `hello`.
- `edit 1 t/こんにちは` edits the translation in  `entry#1` to `こんにちは`
- `edit 1 w/hello t/こんにちは` edits the word and translation in  `entry#1` to `hello` and `こんにちは` respectively.

### Deleting an entry: `delete`

Delete the entry whose index is `INDEX`.

Format: `delete <INDEX>`



**Note:** to get the index of an entry, you may run `list` - the index would be shown beside its respective entry

### Clearing all entries: `clear`

Clears all entries from the word bank.

Format: `clear`


### Viewing help: `help` 

Shows a cheat-sheet of commands in addition to a link to this User Guide.

Format: `help`

### Exiting the program: `exit`

Exits the program.

Format: `exit`

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
| **Help**   | `help`                                                                                                                |
| **New**    | `new <NAME OF NEW DECK>`  e.g. `new Japanese-Animals`                                                                 |
| **Remove** | `remove <INDEXOF DECK>` e.g. `remove 1`                                                                               |
| **Select** | `select <INDEXOF DECK>` e.g. `select 1`                                                                               |
|*****************************************************************                                                                   |
|**Select a Deck before Using the following Commands**                                                                               | 
|*****************************************************************                                                                   |
| **Add**    | `add w/<WORD> t/<TRANSLATION>` e.g. `add w/Hello t/hola`                                                              |
| **List**   | `list`                                                                                                                |
| **Edit**   | `edit <INDEX> w/<WORD> t/<TRANSLATION>` OR `edit <INDEX> w/<WORD>` OR `edit <INDEX> t/<TRANSLATION>`                  |
|            |   e.g. `edit 1 w/hello t/こんにちは` OR `edit 1 w/hello` OR `edit 1 t/こんにちは`                                      |
| **Delete** | `delete <INDEX>` e.g. `delete 3`                                                                                      |
| **Clear**  | `clear`                                                                                                               |
| **Exit**   | `exit`                                                                                                                |




