import java.util.Random;
class DiceCup
{
final int NUM_OF_PINS = 9;

public char roll(int numOfDice)
{ 

   int pinsLeft = numOfDice;
   Random r = new Random();   
   int currentDie;
   
   for(int i =0;i<numOfDice;i++)
      {  
         currentDie = r.nextInt(6);
         //currentDie = 1;
         //currentDie = 0;
         //System.out.print((i+1)+":"+currentDie+ " ");
         if(currentDie != 0)
            pinsLeft--;
      }
   
      if (numOfDice == NUM_OF_PINS && pinsLeft ==0)
         return 'X';
      else if (pinsLeft == 0)
         return '/';
      else if (pinsLeft == numOfDice)
         return '-'; 
      else 
         return  Integer.toString(numOfDice - pinsLeft).charAt(0);


}

public static void main(String args[])
{
DiceCup temp = new DiceCup();
System.out.println(temp.roll(10));
System.out.println(temp.roll(3));
System.out.println(temp.roll(1));



}




}