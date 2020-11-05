---
layout: page
title: Gabriel Sim's Project Portfolio Page
---

## Project: GreenTea

GreenTea is a desktop app for learning a new language, optimized for use via a Command Line Interface (CLI) 
while still having the benefits of a Graphical User Interface (GUI) created with JavaFX.
It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

* **New Feature**: Implemented the basic quizzing system including new commands such as the PlayCommand, StopCommand and AnswerCommand. 
(Pull requests [\#106](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/106) [\#185](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/185))
  * What it does: Allows the user to quiz themselves on the different entries they have added to the GreenTea.
  * Justification: This feature is essentially the core of the application. The entire application is built around this compulsory feature including other features such as 
  statistics and switching tabs.
  * Highlights: This implementation was incredibly difficult to implement because it utilised portions of logic, model and ui. Implementing this feature allowed
  me to understand the inner working of AddressBook and allowed me to greater help my teammates with their work by communicating to them what is and is not technically
  feasible in this product. This enchancement also affected what code can be added to the future and what existing code can be removed. Modifying the implementation to
  allow the program to switch between play mode and command mode also required deep analysis of design alternatives.
  * Credits: I wrote this by myself but I utilized the existing commands created by my teammate, Melanie.

* **New Feature**: Split the UI to hold both deck list and entry list. (Pull requests [\#67](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/67))
  * What it does: Allows the user to observe both the deck list and the entry list which is essential for GreenTea to be an intuitive application.
  * Justification: This feature allowed the user to observe a more intuitive user interface. It also allowed the team to develop  the tabbing feature which meant 
  that more data/features can be stored in each of the tabs
  * Highlights: This implementation was difficult to implement because it required knowledge it utilised portions of logic, model and UI. Specifically, understanding how
  obervablelist was used and modifying it was a challenging task.
  * Credits: I wrote this by myself but I utilized the existing commands created by my teammate, Melanie.
  
* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&zFR=false&tabType=authorship&tabAuthor=gabrielsimbingyang&tabRepo=AY2021S1-CS2103T-T09-4%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)

* **Project management**:
  * Team leader
  * Managed workload and guided teammates with their contributions by providing step by step instructions when possible
    (Pull requests [\#72](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/72))
  * Led group meetings and discussion and set expectations such as datelines for tasks
  * Reported bugs and gave meaningful feedback to the team 
    (examples: [1](https://github.com/AY2021S1-CS2103T-T09-4/tp/issues/183), [2](https://github.com/AY2021S1-CS2103T-T09-4/tp/issues/40), [3](https://github.com/AY2021S1-CS2103T-T09-4/tp/issues/38))
  * Managed releases `v1.3` - `v1.4` (3 releases) on GitHub

* **Enhancements to existing features**:
  * Wrote additional tests for existing features such as PlayCommand, StopCommand, TestCommand and Leitner.java
  (Pull requests [\#188](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/188) [\#185](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/185) 
  * Updated the GUI color scheme 
  (Pull requests [\#61](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/61) [\#44](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/44))
  * Fix several critical bugs such as the Select Command bug and the Answer Command Bug 
  (Pull requests [\#180](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/180) [\#72](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/72))

* **Documentation**:
  * User Guide:
    * Added documentation for the Chapter 1, What is GreenTea [\#126](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/126) 
    * Added documentation for the Chapter 2, About [\#126](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/126)
    * Added documentation for the Chapter 3, Getting Started [\#126](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/126) [\#189](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/189)
    * Added documentation for the Chapter 8, FAQ  [\#126](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/126)
    * Added documentation for the Chapter 9, Command Summary  [\#126](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/126)
    * Did tweaks to existing documentation of Chapter 4, Using this Guide [\#189](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/189)
  * Developer Guide:
    * Added several diagrams to the developer guide 
    (Pull requests [\#104](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/104) [\#109](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/109))
  * Others:
    * Added the Leitner System psuedo code for team reference 
    (Pull requests [\#65](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/65))
    

* **Community**:
  * Contributed to forum discussions (examples: [1](https://github.com/nus-cs2103-AY2021S1/forum/issues/291), [2](https://github.com/nus-cs2103-AY2021S1/forum/issues/137), [3](https://github.com/nus-cs2103-AY2021S1/forum/issues/384))