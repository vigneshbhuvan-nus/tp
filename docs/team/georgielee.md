---
layout: page
title: Georgie Lee's Project Portfolio Page
---

## Project: Green Tea

GreenTea is a desktop app for learning a new language, optimized for use via a Command Line Interface (CLI)
while still having the benefits of a Graphical User Interface (GUI) created with JavaFX.
It is written in Java, and has about 10 kLoC.

Given below are my contributions to the project.

- **New Feature**: Implemented the statistics system, stats command, and performance tracking for each quiz

  Pull requests: [#125](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/125)

  - What it does: Tracks performance for each quiz attempt / game played, last login time and lets user view this information.
  - Justification: Allows users to better understand their strengths, weaknesses in words and quizzes and have a bird eye view of their general performance and other metrics.
  - Highlights:
    - This feature was modereately hard to implement as implementing it should not modify / interfere too much with the existing codebase as this wasn't so much of a "feature" but rather a "hook" / "middleware" to track existing usage, just like Google Analytics for websites / mobile apps.

* **New Feature**: Create statistics panel (UI) and implement efficient algorithm to aggregate results of most recent 10 quiz attempts.

  Pull requests: [#205](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/205), [#139](https://github.com/AY2021S1-CS2103T-T09-4/tp/pull/139)

  - What it does: Lets the user see their most recent 10 performance amongst all quiz or for a given quiz in a graph.
  - Justification: Displays statistics data in a meaningful and palatable way.
  - Highlights:
    - I implement a `O(k*log(numQuizzes))` runtime algorithm to extract the latest `k (=10)` attempts from `numQuizzes` lists of `QuizAttempts`. Wrote extensive randomized testing code to test the reliability and correctness of this algorithm. This algorithm is an improvement from the naive `O(numQuizzes*log(numQuizzes))` algorithm which resulted in a manifold performance boost.
    - UI-wise, it was quick to implement as fxml has an easy-to-use linechart plotting API.

* **Code contributed**: [RepoSense link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=geoboom&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

* **Project management**:

  - Managed releases `v1.3` - `v1,4` (2 releases) on GitHub

* **Enhancements to existing features**:

  - Add statistics panel, quizAttempts, questionAttempts, and statistics manager classes.
  - Wrote unit tests for statistics related code.

* **Documentation**:

  - User Guide:

    - Ported over initial user guide from docx -> md
    - Wrote user guide sections for `play` command and modified some parts of user guide related to statistics.

* **Contributions beyond the project team**:
  - Assisted in some forum issues [here](https://github.com/nus-cs2103-AY2021S1/forum/issues/1) and [here](https://github.com/nus-cs2103-AY2021S1/forum/issues/4).
