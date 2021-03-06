//Andrew Liu
//Programming Assignment 10
//Create a husky
//Husky
//Version 1.0
//3/6/2013
import java.util.*;
import java.awt.*;
public class Husky_liu1 extends Critter
{
/**
* int moveCounter is counting how many moves have been made
*/
	private int moveCounter;
/**
* int eatCounter is counting how many moves have been made since the last attack
*/
	private int eatCounter;
/**
* int lastMove is the direction the husky last moved in
*/
	private int lastMove;
/**
* Attack a is the last attack
*/
	private Attack a;
/**
* String appearance is the husky's current appearance
*/
	private String appearance;
/**
* boolean aggressive is whether or not the husky will act aggressively
*/
	private boolean aggressive;
/**
* boolean invisible is whether or not the husky will be "invisible"
*/
	private boolean invisible;
/**
* Constructor
* no parameters
*/
	public Husky_liu1()
	{
		invisible = false;
		aggressive = true;
		lastMove = 0;
	}
/**
* fight determines what attack the husky will use, which will beat all standard animals
* @param String opponent is the appearance of the opponent
* @return Attack is the Attack which has been selected
*/
	public Attack fight(String opponent)
	{
		Random rrr = new Random();
		Random rrrr = new Random();
		if(moveCounter < 150)
		{
			if(opponent.equals("S"))
			{
				a = Attack.POUNCE;
			}
			else if(opponent.equals("%"))
			{
				a = Attack.ROAR;
			}
			else if(opponent.equals(">")||opponent.equals("^")||opponent.equals("<")||opponent.equals("V"))
			{
					a = Attack.SCRATCH;
			}
			else if(opponent.equals("0")||opponent.equals("1")||opponent.equals("2")||opponent.equals("3")||opponent.equals("4")||opponent.equals("5")||opponent.equals("6")||opponent.equals("7")||opponent.equals("8")||opponent.equals("9"))
			{
				if(opponent.equals("0"))
				{
					a = Attack.SCRATCH;
				}
				else
				{
					a = Attack.ROAR;
				}
			}
			else
			{
			
				int attack = rrr.nextInt(3) + 1;
				if(attack == 1)
				{
					a = Attack.ROAR;
				}
				else if(attack == 2)
				{
					a = Attack.POUNCE;
				}
				else if(attack == 3)
				{
					a = Attack.SCRATCH;
				}
			}
		}
		else
		{
			int attackTwo = rrrr.nextInt(10) + 1;
			if(attackTwo == 1)
			{
				int attackThree = rrr.nextInt(3) + 1;
				if(attackThree == 1)
				{
					a = Attack.ROAR;
				}
				else if(attackThree == 2)
				{
					a = Attack.POUNCE;
				}
				else if(attackThree == 3)
				{
					a = Attack.SCRATCH;
				}
			}
			else
			{
				if(toString().equals("S"))
				{
					a = Attack.SCRATCH;
				}
				else if(toString().equals("%"))
				{
					a = Attack.POUNCE;
				}
				else if(toString().equals("^")||toString().equals("<")||toString().equals(">")||toString().equals("V"))
				{
					a = Attack.ROAR;
				}
				else if(toString().equals("0"))
				{
					a = Attack.ROAR;
				}
				else
				{
					a = Attack.POUNCE;
				}
			}
		}
		eatCounter = 0;
		return a;
	}
/**
* getColor gets the color of the husky
* no parameters
* @return Color is the color of the husky
*/
	public Color getColor()
	{
		return Color.BLACK;//always black
	}
/**
* toString returns the appearance of the animal
* no parameters
* @return String is the appearance
*/
	public String toString()
	{
		if(moveCounter < 125)
		{
			return ".";//appear as food when moves are less than 300
		}
		if(invisible)
		{
			appearance = " ";//if invisible, appear invisible
		}
		else
		{
			// String[] hString = {">","5","%","S"};//choose random appearance
// 			Random r = new Random();
// 			String temp = hString[r.nextInt(4)];
// 			if(temp.equals(">"))
// 			{
// 				if(lastMove == 1)
// 				{
// 					appearance = "^";
// 				}
// 				else if(lastMove == 2)
// 				{
// 					appearance = ">";
// 				}
// 				else if(lastMove == 3)
// 				{
// 					appearance = "V";
// 				}
// 				else if(lastMove == 4)
// 				{
// 					appearance = "<";
// 				}
// 				else if(lastMove == 0)
// 				{
// 					appearance = ">";
// 				}
// 			}
// 			else if(temp.equals("5"))
// 			{
// 				appearance = r.nextInt(10) + "";
// 			}
// 			else if(temp.equals("%"))
// 			{
// 				appearance = "%";
// 			}
// 			else
// 			{
// 				appearance = "S";
// 			}
			if(moveCounter >= 125 && moveCounter < 400)
			{
				appearance = "%";
			}
			else if(moveCounter >= 400 && moveCounter < 600)
			{
				if(lastMove == 1)
 				{
 					appearance = "^";
 				}
 				else if(lastMove == 2)
 				{
 					appearance = ">";
 				}
 				else if(lastMove == 3)
 				{
 					appearance = "V";
 				}
 				else if(lastMove == 4)
 				{
 					appearance = "<";
 				}
 				else if(lastMove == 0)
 				{
 					appearance = ">";
 				}
			}
			else if(moveCounter >= 600 && moveCounter < 800)
			{
				appearance = "5";
			}
			else if(moveCounter >= 800 && moveCounter < 1000)
			{
				appearance = "S";
			}
			else
			{
				appearance = "%";
			}
		}
		return appearance;
	}
/**
* eat returns whether or not to eat
* no parameters
* @return boolean is whether or not the animal will eat
*/
	public boolean eat()
	{
		boolean hEat = false;
		if(eatCounter < 4)//eat if less than 4 moves since an attack
		{
			hEat = true;
		}
		if(moveCounter > 300)//always eat after 300 moves
		{
			hEat = true;
		}
		return hEat;		
	}
/**
* getMove determines which direction the animal will move in.
* no parameters
* @return Direction is the direction the animal will move in
*/
	public Direction getMove()
	{
		int direct = 0;
		Random rr = new Random();
		Direction d = Direction.CENTER;
		Direction w = Direction.NORTH;
		Direction x = Direction.EAST;
		Direction y = Direction.SOUTH;
		Direction z = Direction.WEST;
		String north = super.getNeighbor(w);
		String east = super.getNeighbor(x);
		String south = super.getNeighbor(y);
		String west = super.getNeighbor(z);
		if(moveCounter > 300)
		{
			aggressive = false;
		}
		if(aggressive)//tries to get into fights if aggressive, but not eat
		{
			if(!(north.equals(" "))&&!(north.equals(".")))
			{
				d = w;
				lastMove = 1;
			}
			else if(!(east.equals(" "))&&!(east.equals(".")))
			{
				d = x;
				lastMove = 2;
			}
			else if(!(south.equals(" "))&&!(south.equals(".")))
			{
				d = y;
				lastMove = 3;
			}
			else if(!(west.equals(" "))&&!(west.equals(".")))
			{
				d = z;
				lastMove = 4;
			}
			else
			{
				d = Direction.WEST;
				lastMove = 4;	
			}
		}
		else
		{
			if(north.equals("."))//after 300 moves, eats as much as it can
			{
				d = w;
				lastMove = 1;
			}
			else if(east.equals("."))
			{
				d = x;
				lastMove = 2;
			}
			else if(south.equals("."))
			{
				d = y;
				lastMove = 3;
			}
			else if(west.equals("."))
			{
				d = z;
				lastMove = 4;
			}
			else
			{
				direct = rr.nextInt(4) + 1;
				if(direct == 1)
				{
					d = Direction.NORTH;
					lastMove = 1;
				}
				if(direct == 2)
				{
					d = Direction.EAST;
					lastMove = 2;
				}
				if(direct == 3)
				{
					d = Direction.SOUTH;
					lastMove = 3;
				}
				if(direct == 4)
				{
					d = Direction.WEST;
					lastMove = 4;
				}
			}
		}		
		moveCounter++;
		eatCounter++;
		return d;
	}
}