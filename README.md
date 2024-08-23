This project was created using roadmap.sh's Task Tracker CLI project outline.
  - Can be found here: https://roadmap.sh/projects/task-tracker

## Description
This project is a simple command line task tracker app which stores the data within a JSON file. It has functions to add, update, mark a task in progress/done/to do, list tasks and delete tasks.

## How to run
- Clone repository
```bash
git clone https://github.com/FulgurStrike/TaskTrackerCLI.git
```
- cd into root of the directory
```bash
cd TaskTrackerCLI
```
- Run jar file
```
java -jar TaskTrackerCLI.jar
```

## Commands
```bash
task-cli add Task
#Output: Task added successfully (ID: 1)

task-cli list
#Output: All tasks from TaskList file
task list-todo
#Output: Lists all to-do tasks
task-cli list-in-progress
#Output: Lists all in-progress tasks
task-cli list-done
#Output: Lists all done tasks

task-cli update 1 UpdatedTasks

task-cli mark-done 1
task-cli mark-in-progress 1
task-cli mark-todo 1

task-cli delete 1
```
