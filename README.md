# Battleship
***PLEASE NOTE: EVERYTHING (JAVA CODE, BASH SCRIPTS, ETC.) IS A WORK IN PROGRESS. I AM CONSTANTLY UPDATING THIS REPO TO FIX MISTAKES, AND IMPROVE EFFICIENCY/ CLARITY.***

This Battleship game, developed by Rakan Kandah, was written in Java as a solo project. 

The AI's algorithm is original, along with everything else in the code. In more recent updates, I've added a Dockerfile & bash scripts to make running the game on another machine easier. It's not perfect yet (I'm still learning how to use these technologies), but progress is being made! 

How the AI works: 
The goal of this independent project was to develop a natural algorithm for the computer to follow. There's no sense in making the computer act like a computer.


To start, the AI searches the board by selecting random positions. Once a ship is located, it follows this procedure: DOWN, UP, LEFT, RIGHT. This process will continue until the ship is sunk or the computer misses. 

If a ship of length 3 is vertical, and the computer finds the first position (top), then it will have sunk the entire ship in one turn. 

This is the best and easiest case because the computer always goes DOWN first. By the time it makes its first miss, the ship will already be destroyed. 

Below is an example of the procedure. `X` represents an unmarked ship. `H` represents a hit and `O` represents a miss. The `<--` represents the starting position (first hit) and never changes. 

`X <-- Computer starts here (marks as hit)`

`X`

`X`

***_______________________***

`H <-- Computer goes down`

`H * Computer marks as hit; goes down`

`H * Computer marks as hit; goes down`

`O * Miss`

***Note, when the computer misses, it returns to the first known hit. (This will be further explained in the next example).***

In the first example, the computer was lucky. It sank the entire ship in one turn; however, this is not always the case. 

Sometimes, it'll select the middle position instead (as shown below).

`X` 

`X <-- Computer starts here(marks as hit)`

`X `

This is when the algorithm becomes a bit more complicated. The computer, by default, goes down first. 

This means it misses the top portion of the ship and only hits the bottom. 

To fix this issue, I developed a marker-like system for the computer. The computer marks a hit position as "T" if it's traveled there more than once. This will prevent it from constantly returning to the same spot - instead allowing it to continue searching the area. The process is demonstrated below.

`X` 

`H <-- Computer goes down`

`H * Computer marks as hit; goes down`

`O * Computer marks as miss; returns to first known hit`

***_______________________***

`X `

`H <-- Computer goes down again`

`T * Computer has been here before; MARK POSITION AS T; return to first known hit (Note this does not waste a turn - it happens in the background.)`

`O`

***_______________________***

`O`

`H`

`H <-- Computer knows not to go down now (thanks to the T) and instead travels upward, marks a hit, followed by a miss.`

`T`

`O`

Now the ship is sunk; however, the computer is not yet finished. Every time the computer misses, it travels back to the first known hit. 

Since we just missed the position at the very top, the computer has to return to the original hit. 

From there, the computer knows it cannot travel down (because of the T) so it tries to go up. However, the computer knows it's been up before, so it marks that
position as a "T". Once the bottom and top are marked as "T" the computer has nowhere left to go (shown below). 

`O`

`T (marked as T after computer tries to go up here again).` 

`H <-- Computer cannot go down or up (there is no need to check left/right because this is a vertically oriented ship) so it knows its work is complete.`

`T`

`O`

Now that the ship is sunk, it is safe for the computer to move on.

The process is the identical for horizontally oriented ships (and ships of varying length). 

There are more elegant ways of executing this algorithm, but this was the design that came to me. Although it was not an easy algorithim to implement; I had to think of all the different possibilities to make the computer play the game in as natural a manner as possible. 

Recent fixes & improvements:
  Updated AI 12/28/20 (Computer now recognizes the orientation of a ship (horizontal/vertical) after a maximum of two hits). 
  
  Updated random ship generator 12/30/20 (All ships have a consistent size (XXX XX X) <-- three ships, all of varying lengths)
  
 NEED TO: 
  Finish deploying the game in the cloud (AWS ; EC2) so it's easier for others to try out.  
  
  Fix ship placement to prevent sticking (sometimes the ships all line up in a row/column EX: (XXX)(XX)(X) - three ships merged together) 

~ Rakan Kandah
