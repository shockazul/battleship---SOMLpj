# Battleship
Battleship

This Battleship game, developed by Rakan Kandah, was written in Java as a solo project. 
The AI's algorithm is original, along with everything else in the code. 
Note, the algorithm is not perfect (further proof that I am the sole developer). 

How the AI works: 
Getting a computer to think like a human is hard (and that's an understatement!). 
The goal of this independent project was to develop a natural algorithm for the computer to follow. There's no sense in making the computer act like a computer.


To start, the AI searches the board by selecting random positions. Once a ship is located, it follows this procedure: DOWN, UP, LEFT, RIGHT. 
If a ship of length 3 is vertical, and the computer finds the first position (top), then it will have sunk the entire ship in one turn (best and easiest case). 
The computer will simply go down and hit all three ships in one go.
X <--
X
X

H <--
H
H

However, the computer is not always so lucky. Sometimes, it'll randomly select the middle position.
X 
X <--
X 
This is when the algorithm becomes a bit more complicated. The computer, by default, goes down first. This means it misses the top portion of the ship and only hits the bottom. 
To fix this issue, I developed a marker-like system for the computer. The computer marks a hit position as T if it's traveled there more than once. This will prevent it from
constantly returning to that spot. The process is demonstrated below.
X       
X <-- Computer lands here
X

X 
H <--Marks as first hit then goes down
H (Marked hit then goes down)
O (Marked miss, returns to the original location (first hit))

X 
H <-- Computer goes down again 
T (MARK AS T) No need to keep going down. Returns to the original location.
O

O
H 
H <-- Computer knows not to go down now (thanks to the T) and instead travels upward, marks a hit, followed by a miss. Now the ship is sunk.
T
O
The computer knows a ship is sunk when there is a miss (O) on both ends. It is then safe for the computer to move on and select a new random position.
There are more elegant ways of executing this algorithm (I'm sure), but this was what I'd imagined in my head. It made perfect sense to me, and so I went with it. 

* * *  
I mentioned earlier, the AI is not perfect. I need to work on fixing a logic error (demonstrated below). 

X X X 
^
Computer first checks down.
H X X 
O
Then up.
O
H X X 
O
Then left.
  O
O H X X 
  O
Finally, right.
  O
O H H X 
  O
There is no issue with the above process. The computer does not know where the second portion of the ship is located, so it has to go through all possibilities.
It is unlucky, but not faulty. However, on the second iteration, the logic will become faulty. 
The computer will still act as if it does not know which direction the ship is oriented (although a human would).
It'll continue going down, up, left, right until the ship is sunk. This wastes 3 good turns. I'm still working on a solution to combat this issue.

If you'd like to try the game out, please feel free!
You'll need to have java installed on your computer, but besides that, it's fairly simple to run.

~ Rakan Kandah