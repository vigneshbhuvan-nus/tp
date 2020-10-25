# User Guide

Team Name: AY2021S1-CS2103T-T09-4 Since: August 2020

## Table of Contents

- [1. What is GreenTea? (Gabriel)](#1-what-is-greentea-gabriel)
- [2. About This Document (Gabriel)](#2-about-this-document-gabriel)
- [3. Let's Get Started (Gabriel)](#3-lets-get-started-gabriel)
- [4. Features (Melanie)]()
    - [4.1 Deck Commands (Melanie)](#4-deck-commands-melanie)
      - [4.1.1 Creating a deck: new](#creating-a-deck-new)
      - [4.1.2 Removing a deck: remove](#removing-a-deck-remove)
      - [4.1.3 Selecting a deck: select](#selecting-a-deck-select)
    - [4.2. Entry Commands (Vignesh)](#5-entry-commands-gabriel)
      - [4.2.1 Adding a new entry: add](#adding-a-new-entry-add-vignesh)
      - [4.2.2 Editing an entry: edit](#editing-an-entry-edit-vignesh)
      - [4.2.3 Deleting an entry: delete](#deleting-an-entry-delete-vignesh)
    - [4.3. FlashCard Commands (Georgie)](#6-play-commands-georgie)
      - [4.3.1 Editing an entry: edit](#editing-an-entry-edit-vignesh)
      - [4.3.2 Deleting an entry: delete](#deleting-an-entry-delete-vignesh)
    - [4.4. Extra Commands (Georgie)](#8-extra-commands-georgie)
      - [4.4.1 Viewing help: help](#viewing-help-help)
      - [4.4.2 Exiting the program: exit](#exiting-the-program-exit)
- [5. Data Analytics (Melanie)]()
- [6. FAQ (Gabriel)](#10-faq-gabriel)
- [7. Command Summary (Melanie)](#11-command-summary-gabriel)

# 1. What is GreenTea? (Gabriel)

GreenTea is a **desktop app for learning a new language, optimized for use via a Command Line Interface** (CLI) while
still having the benefits of a Graphical User Interface (GUI). It adopts the Leitner flashcard system, a proven method
to helps users retain memory in the context of learning a new language. This app is perfect for users who wish to
optimise their time learning a new language. In this User Guide (UG), you will learn about the various commands and
actions that would allow you to use GreenTea seamlessly.

![GreenTea](images/Placeholder.png)

# 2. About This Document (Gabriel)

Welcome to the GreenTea User Guide!

I am proud that you have taken your first few steps towards optimising your learning. We at GreenTea know that
learning a new language can be **hard** and **intimidating**. Trust us when we say we know **exactly** what you're
going through and we feel **frustrated** just as much you do.

That's why here at GreenTea, we have come up with this neat little
user guide to help **you** hit the ground running. With this foolproof User Guide, learning a new
language will be as relaxing as drinking a hot cup of Green Tea.

# 3. Let's Get Started (Gabriel)

Before you can start using GreenTea, you will need to ensure that [Java 11](https://www.java.com/en/)
is installed on your computer.

To start using GreenTea:

1. Download the latest jar file [here](https://github.com/AY2021S1-CS2103T-T09-4/tp/releases/new)
2. Copy the jar file to your folder of choice (we recommend on your desktop!)
3. Double-Click the file to start the application. The GUI should appear in a few seconds
![GreenTea](images/Placeholder.png)
4. Typing the commands into the command box and pressing enter will execute the commands \
e.g. Typing `new Japanese Animals` will create a new Deck called Japanese Animals 
5. Try typing these commands to start playing with GreenTea \
    - `new Japanese Animals`: Creates a new Deck called `Japanese Animals`
    - `select 1` selects the first Deck `Japanese Animals`
    - `add w/Dolphin t/Iruka`: Adds a new Entry into the selected deck with the word `Dolphin` and the translation `Iruka`
    - `edit 1 t/イルカ`: Edits first Entry and change the existing translation `Iruka` into `イルカ`
6. Refer to [Chapter 4 Features](#features) for a detailed explanation for each command.

# 4. Features

## 4.1 Deck Commands (Melanie)

Decks are the foundation to GreenTea. A deck is simply a list of words and translation
you write into GreenTea. A deck can be your favourite Chinese idioms, a list of beverages in Japanese,
or even some romantic phrases in French!

### 4.1.1 Creating a deck: `new`

Creates a new empty deck of entries

Format: `new <NAME OF NEW DECK>`

Examples: `new Japanese-Animals`,
`new Korean Dramas`

### 4.1.2 Removing a deck: `remove`

Removes a particular deck from GreenTea

Format: `remove <INDEX OF DECK>`

**Note:** to get the index of a deck, you may view it on the GUI. It would be the number displayed beside a particular deck

Example: `remove 1`

### 4.1.3 Selecting a deck: `select`

Selects a deck to perform entry-level operations on

Format: `select <INDEX OF DECK>`

**Note:** to get the index of a deck, you may view it on the GUI. It would be the number displayed beside a particular deck

Examples: `select 1`

## 4.2 Entry Commands (Gabriel)

Entries are what make up a deck. They are the words or phrases that you wish to memorise in GreenTea.
An entry is made up of two parts; the `word` and the `translation`. The `word` is written in the
language you are most familiar and the `translation` is written in the language you wish to learn. In
this User Guide, we will be assuming the language for `word` will be in English.

Before you start adding a new entry, remember to [select a deck first!](#selecting-a-deck-select)

Fun fact: Did you know GreenTea supports over 100 languages including Telugu, Welsh and Xamtanga? To
see if your chosen language is supported, click [here!](http://www.unicode.org/charts/index.html)

### 4.2.1 Adding a new entry: `add` (Vignesh)

Adds a new entry to the word bank.

Format: `add w/<WORD> t/<TRANSLATION>`

Examples:

- `add w/Fruits t/果物`
- `add w/Why aren’t they here yet? t/どうして彼らはまだここにいないの`

### 4.2.2 Editing an entry: `edit` (Vignesh)

Edits an entry whose index is `<INDEX>`, replacing the original word with `<WORD>` and its translation with `<TRANSLATION>`.
You may provide either `<WORD>` or `<TRANSLATION>`, or both and only the one(s) provided will replace the original(s).

Format: `edit <INDEX> w/<WORD> t/<TRANSLATION>` OR `edit <INDEX> w/<WORD>` OR `edit <INDEX> t/<TRANSLATION>`

**Note:** to get the index of an entry, you may run `list` - the index would be shown beside its respective entry

Examples:

- `edit 1 w/hello` edits the word in `entry#1` to `hello`.
- `edit 1 t/こんにちは` edits the translation in `entry#1` to `こんにちは`
- `edit 1 w/hello t/こんにちは` edits the word and translation in `entry#1` to `hello` and `こんにちは` respectively.

### 4.2.3 Deleting an entry: `delete` (Vignesh)

Delete the entry whose index is `INDEX`.

Format: `delete <INDEX>`

**Note:** to get the index of an entry, you may run `list` - the index would be shown beside its respective entry

## 4.3 Play Commands (Georgie)

## 4.3.1 Play Commands (Georgie)

## 4.3.2 Play Commands (Georgie)
Starts a quiz with questions from the selected deck. This also causes a transition from the `LOBBY` to `QUIZ` phase and the command is only allowed to be executed while in the `LOBBY` phase.

Format: `play d/<DECK_ID>`

Examples:

- `play d/1`

## 4.4 Extra Commands (Georgie)

These are some commands in the pipeline to be implemented:

### 4.4.1 Viewing help: `help`

Shows a cheat-sheet of commands in addition to a link to this User Guide.

Format: `help`

### 4.4.2 Exiting the program: `exit`

Exits the program.

Format: `exit`

## 5. Data Analytics (Melanie)

## 6. FAQ (Gabriel)

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous GreenTea home folder.

---

## 7. Command Summary (Gabriel)

| Action                                                                                             | Format  <img width=00/>                                                                           |Examples <img width=400/>|Remarks|
| -------------------------------------------------------------------------------------------------- | -----------------------------------------------------------------------------------|--------|--------|
| **New**                                                                                            | `new <NAME OF NEW DECK>` | `new Japanese-Animals`   |Creates a New Deck With the Given Name          |
| **Remove**                                                                                         | `remove <INDEXOF DECK>`  |`remove 1`    |Removes the Deck with the Given Index          |
| **Select**                                                                                         | `select <INDEXOF DECK>`  |`select 1`    |Selects the Deck with the Given Index and Lists All It's Entries         |
| **Add**                                                                                            | `add w/<WORD> t/<TRANSLATION>` | `add w/Hello t/hola`       |Adds an Entry with the Given Word and Translation to the Selected Deck|
| **Edit**                                                                                           | `edit <INDEX> w/<WORD> t/<TRANSLATION>` <br/> OR `edit <INDEX> w/<WORD>` <br/> OR `edit <INDEX> t/<TRANSLATION>` | `edit 1 w/hello t/こんにちは` <br/> OR `edit 1 w/hello` <br/> OR `edit 1 t/こんにちは` | Edits the Entry with the Given Index Using the Given Values|
| **Delete**                                                                                         | `delete <INDEX>` | `delete 3`                                                                     | Deletes the Entry with the Given Index|
| **Play**                                                                                          | `play`                                                                                              |  | Starts a New FlashCard Game with the Selected Deck
| **Stop**                                                                                           | `stop`       | | Stops an Existing Game
| **Clear**                                                                                          | `clear`                                                                                              |  | Deletes All Decks and Entries
| **Help**                                                                                           | `help`       | | Opens Our User Guide in the Application|
| **Exit**                                                                                           | `exit`                                                                                               |  | Saves and Exits the Program
