<h1>Activity: Section 3 Project 2</h1>

<h2>Overview:</h2>

Until now we have created ```Board``` and ```Square``` classes. The ```Board``` class maintains square objects as a 2 dimensional array. Since the ```Board``` class has an instance variable which contains square classes, we can say that ```Board``` and ```Square``` classes are [tightly coupled](http://stackoverflow.com/questions/2832017/what-is-the-difference-between-loose-coupling-and-tight-coupling-in-object-orien). 

Since things will soon become complex as we start adding new features, this is a good time to take a step back and understand the big picture. 


Let us once again think of the responsibilities of a board. We know that a  board must be able to create the minefield. What this also means is, it must be able to initialize itself with certain squares that are mines and several squares which are not mines. How should this be done ? 

We can adopt several strategies to initialize the board with mines. But to start with let's do the simplest thing that works. We can generate a random number while instantiating square objects. If the number is odd, we will mark the square as a mine, and if it is even we will not mark it as a mine.

Code Snippet 1 shown below, shows pseudo code which hints how you may achieve this.

    public Board() {
        this.squares = new Square[MAX_ROWS][MAX_COLS];
        for(int row=0; row<MAX_ROWS; row++) {
		    for(int col=0; col<MAX_COLS; col++) {
		        Square square = new Square();
		        // n = random_number_between_0_and_10
		        // if n is even:
		        //     square.setMine(true);
			    squares[row][col] = square;
		    }
	    }
    }

_**Code Snippet 1**_

Now that you have figured out a simple way of generating mines on the board, let's move ahead, and think of other responsibilities a board should have. These responsibilities will become methods in the ```Board``` class. The question we must ask oursleves is:  _What can a client code do with a Board object ?_ Shown below is a conversation you might have with a senior developer while tring to determine further responsibiities of the ```Board``` class.

 - _**(developer)**_ Should the ```Board``` class have any methods ?
 - _**(team lead)** Great question. But instead of answering your question directly, let me ask you a question first. Who do you think would be the client of the ```Board``` class ? By client, I mean, which class would use (invoke methods of) the ```Board``` class ?_
 - _**(developer)** Ummm, I think the UI class(es) would invoke methods on the ```Board``` class._
 - _**(team lead)** That's right. What do you think the UI class(es) would want to do with the Board ?_
 - _**(developer)** When a user performs an action on the UI, to mark a square or uncover it, the UI class would need to reflect that action on the square objects. Since the Board is a container of square objects, it would need to perform such operations on the Board._
 - _**(team lead)** That's great. So which methods do you think the ```Board``` class should have ?_
 - _**(developer)** Methods for manipulating ```Square``` objects ? Like ```uncover```  and ```mark``` ?_
 - _**(team lead)** Yes that's a good start. Eventually you might add a few more methods to it, but you don't need to worry about it right now. However, do remember that you will have to identify the square, in the method in Board._
 - _**(developer)** Thanks for your time._
 

<h2>Steps For This Activity</h2>

Your work in this activity is to complete the constructor of ```Board``` and the two methods we discussed above, that Board should have.

 1. Run ```BoardTest``` as a unit test and confirm that 7 tests fail 
 1. Complete the constructor of the ```Board``` class so that certain squares are initialized as mines
 1. Run ```BoardTest``` as a unit test and confirm that 3 tests pass and 7 tests fail. The numbers are the same from step one, but tests are different. This time the following tests should pass and the remaining will fail.
           ```testSquaresGridSize()```
           ```testSquaresNotNull()```
           ```testAtleastOneSquareShouldBeAMine``` (this is the new test which should now pass)
           Notice that an earlier test ```testUncoverSquaresWhichAreMines``` which was passing by default, has now started failing. This is because we actually have mines in the field now. 
 1. Implement the ```uncover()``` method in ```Board```
 1. Run ```BoardTest```. If the uncover method has been implemented properly, you should see 7 passing tests and 3 failing tests. We actually expect 6 tests to pass, which have been listed next: 
           ```testSquaresGridSize()```
           ```testquaresNotNull()```
           ```testAtleastOneSquareShouldBeAMine()```
           ```testUncoverSquaresWhichAreNotMines()```
           ```testUncoverSquaresWhichAreMines()```
           ```testUncoverSquaresWhichAreAlreadyUncovered()```
           **An additional test also passes by default:**
           ```testMarkSquaresWhichAreUncovered()```
 1. Implement the ```mark()``` method in ```Board```.
 1. Run ```BoardTest```. All tests should pass, if you have implemented the ```mark()``` method properly.
   
<h2>Learning Outcomes</h2>
 1. How to generate random numbers in a Java program.
 1. How to delegate responsibility of a certain functionality in a class to another class.
 1. How to instantiate complex state in a constructor of a class.

<h2>Questions to ponder</h2>
 1. Why did the unit test ```testUncoverSquaresWhichAreMines``` pass even though the method was not yet implemented ?

