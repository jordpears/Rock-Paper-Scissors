# Rock-Paper-Scissors
Java implementation of rock paper scissors in command line


### Assumptions:
The player will input the n number of games they wish to play and will then proceed to play that many games.
The player should have the power to cleanly quit the game during those n plays.

### Design choices and rationale:
I extracted the core logic into two files for ease of testing and separation of duties:
`RockPaperScissorsController` - this file is handling the input and output of the game as it interfaces with the player

`RockPaperScissorsService` - this file is handling any game logic, such as working out winner and generating computer move

The files in `util` package are smaller utility functions or enums that encapsulate a player action or game result.
I also added an abstraction layer over the scanner to enable easier testing by avoiding exposing the System.in buffer.
The PrettyHandUtil is just a container for the strings representing both left and right hands, and a method to obtain them.

I also added tests for the controller and service utilising mocking and Junit5.

The only dependencies I have are Junit5, Mockito and a plugin for a newer version surefire to ensure the tests run through mvn.

### Running:
_Built with Java11_

#### compile and run tests:
`mvn clean test`

#### run the game in terminal:
`mvn exec:java -Dexec.mainClass=Main`

Alternatively import the project into your IDE and run through there - main is located in Main.java