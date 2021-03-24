# BTP400 Winter 2021: Assignment 1 - (20%)

```
Prof. Eden Burton
School of Software Design and Data Science, Seneca College of Applied Arts and Technology
Winter 2021
```
## Due Monday March 15, 2021 - 11:30 pm

### Instructions
Please read the instructions carefully and follow the naming conventions specified for each question. Solutions must be submitted in the Blackboard Dropbox created for Assignment 1.

Note that the deadline is strictly enforced. The system tracks the exact time that submissions are uploaded. There is a 10% per day penalty for late submissions.

### Additional Notes
- You must provide appropriate test case classes with your solution. Document any assumptions you make about the requirements. You will have to organize your code in a way such that the JUnit test runner does not require user input. Test classes must be written using the JUnit5 standard.

- Will be required to present and explain their solution to the professor during the lab period.

- You may use any IDE for development but note that demonstrations and professor testing will be done exclusively on the command line.

- Software artifacts (source code and accompanying documentation) should clearly indicate each member’s contributions to the project.

## Case Description

Your task is to build a system that models a car assembly line. A car goes through a set of stations, with each station tasked with doing a part of the assembly process. The car is completely built when it has passed through all stations required.

- when a car is ordered by a customer, it is associated with a job. The job should store an ordered list of the assembly tasks required for the car to be produced.
- a task can be considered either mandatory or optional
- a task can be identified as initial, intermediate, or final
- a car be ordered with optional features so it is possible for cars to require different assembly tasks.
- A job should be checked (before assembly) to make sure that its assembly task list is valid. Without getting too complex, it should ensure the following properties.
- no task shall occur more than once in the job list
- all mandatory tasks shall be on the list
- a task at the beginning of the list is initial
- a task at the end is final

- each station is configured to do a single task and runs in its own process. Stations that do initial tasks accept jobs from an input file and push jobs out to other stations. Stations doing final tasks accept input jobs and write to a “completed” job report after they have been processed. Finally, intermediate stations accept and push jobs to other stations. For the simulation to be realistic, the processing should take a reasonable amount of time. This can be simulated using the Thread.sleep() static method. They shall also be able to be placed on or offline.
- a task is done using a set of consumable set of materials. For example, ”an attach door” task may require a door, 4 bolts, and 4 screws. Your solution should model the fact that after a task is completed, the inventory of these items is reduced by the appropriate amount. A station cannot complete a task if insufficient supplies are available.
- multiple stations can do the same task. This feature can be used for load-balancing or fail-over purposes.
- jobs move from station to station via TCP sockets. The method of transfer is a design decision you can make.
- jobs originate in initial task stations. Their contents are read in from an input file. You are to design a file format that satisfies the program requirements.
- job status should be logged at each station. It should be possible to query the status of a particular job (ie what stage(s) of assembly has completed thus far). Job processing failures should be logged as well.
- the system shall provide a JavaFX-based GUI to access data at each station. It should at least support the following actions:
- view and update inventory levels
- change input listening port
- change output socket parameters
- switch between on and offline states


![above case desc](https://user-images.githubusercontent.com/34140955/112237268-b1802080-8c18-11eb-9157-b9975095ce08.png)

## Case Description

The picture above illustrates a possible workflow. The” Get Chassis” station begins the workflow and is an initial station that accepts jobs coming into the system. Jobs flow through the system until they reach the final” Engrave VIN” station. When a job requires the” Install Gear Box” task completed, it can go to either of the stations processing those tasks. The” Install Collision Sensors” task is an optional one, so only jobs which have ordered that feature will be sent to its associated station.

## Deliverables

- an executable jar(s) for a station
- files that can be used to run/test your application
- a document which provides instructions on how to run and test your simulation
- a document which explains your system design and assumptions/design decisions. You are encouraged to use UML, DFD, or other diagram types to help the reader visualize your solution.

## Marking Criteria
- functionality ...Does the system actually work? Does it satisfy the requirements?
- testing...is your testing strategy enough to test the robustness of the system? Solely unit testing will not be sufficient for a program of this scope.
- system design ...is your solution flexible? Can your assembly line be reconfigured without code changes? Have you applied class design concepts in a way so that the program is easily maintainable and so that required changes can be handled with minimal code changes?
- does your documentation provide enough detail so that someone can run/test your solution without assistance.


