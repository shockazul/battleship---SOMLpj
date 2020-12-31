# Battleship
Battleship

This Battleship game, developed by Rakan Kandah, was written in Java as a solo project. 
The AI's algorithm is original, along with everything else in the code. 

How the AI works: 
Getting a computer to think like a human is hard (and that's an understatement!). 
The goal of this independent project was to develop a natural algorithm for the computer to follow. There's no sense in making the computer act like a computer.


To start, the AI searches the board by selecting random positions. Once a ship is located, it follows this procedure: DOWN, UP, LEFT, RIGHT; this process will continue until the ship is sunk or the computer misses. 
If a ship of length 3 is vertical, and the computer finds the first position (top), then it will have sunk the entire ship in one turn (best and easiest case because the computer always goes DOWN first.)
Below is an example of the procedure. X represents an unmarked ship. H represents a hit; and O represents a miss.

X <--Computer starts here (marks as hit)
X
X

H <-- Computer goes down
H * Computer marks as hit; goes down
H * Computer marks as hit; goes down
O * Miss

However, the computer is not always so lucky. Sometimes, it'll randomly select the middle position (as shown below).

X 
X <--
X 

This is when the algorithm becomes a bit more complicated. The computer, by default, goes down first. This means it misses the top portion of the ship and only hits the bottom. 
To fix this issue, I developed a marker-like system for the computer. The computer marks a hit position as T if it's traveled there more than once. This will prevent it from
constantly returning to that spot. 
The process is demonstrated below.
X       
X <-- Computer lands here (Marks as first hit)
X

X 
H <--Computer goes down
H (Marked hit then goes down)
O (Marked miss, returns to the original location (first hit)); *Note, when the computer misses, it returns to the first known hit.*

X 
H <-- Computer goes down again 
T (Computer has been here before; MARK AS T; return to first known hit)
O

O
H 
H <-- Computer knows not to go down now (thanks to the T) and instead travels upward, marks a hit, followed by a miss. 
T
O
Now the ship is sunk; however, the computer is not yet finished. Everytime the computer misses, it travels back to the first known hit. Since it just missed the position at the very top, the computer has to return to the original hit. From there, it knows it cannot travel down (because of the T) so it tries to go up. However, the computer knows it's been there before, so it marks it as a T. 
O
T 
H <-- 
T
O
Now, because the computer has nowhere to go (up/down) it knows the ship has been sunk. It is now safe for the computer to move on and select a new random position.

There are more elegant ways of executing this algorithm (I'm sure), but this was what I'd imagined in my head. It made perfect sense to me, and so I went with it. 

Recent fixes & improvements:
  Updated AI 12/28/20
  Updated random ship generator 12/30/20
      

~ Rakan Kandah
