import java.util.Random;
class Player
{
final int CHAR_ADJUST = 48;
final int NUM_OF_PINS = 9;

int playerNumber;

char[] firstThrows = new char[10];
char[] secondThrows = new char[10];
char thirdThrow;
boolean thirdNeeded =false;

int runningTotal = 0;
int redDie;

Random rand = new Random();

Player(int in)
{
   playerNumber = in;
}


void playRound(int round)
{
   //rolls ten dice. then rolls 10-pins left up dice for second roll
   int tempInt;
   DiceCup cup = new DiceCup();
   firstThrows[round] = cup.roll(NUM_OF_PINS);
   redDie = rand.nextInt(6);
   round = 10;
  
   assert round<10:"Round not valid";
   
   redDieHandler(firstThrows, round);
   
   if (firstThrows[round] != 'X' && round != 9)
   {
      assert NUM_OF_PINS-Character.getNumericValue(firstThrows[round]) > 0: "cannot pass a negative num";
      assert NUM_OF_PINS-Character.getNumericValue(firstThrows[round]) < NUM_OF_PINS: "must be less than max"; 
      
      secondThrows[round] = cup.roll(NUM_OF_PINS-Character.getNumericValue(firstThrows[round]));
      redDie = rand.nextInt(6);
      redDieHandler(secondThrows,round);
   }
   else if (round == 9)
   {
      if(firstThrows[round] != 'X')
         {
         secondThrows[round] = cup.roll(NUM_OF_PINS-Character.getNumericValue(firstThrows[round]));
         redDie = rand.nextInt(6);
         redDieHandler(secondThrows,round);
         }
      else if(firstThrows[round] == 'X')
         {
            thirdNeeded = true;
            secondThrows[round] = cup.roll(NUM_OF_PINS);
            redDie = rand.nextInt(6);
            redDieHandler(secondThrows,round);
            if(secondThrows[round] == 'X')
            {
               thirdThrow = cup.roll(NUM_OF_PINS);                  
            }
            else
               thirdThrow = cup.roll(NUM_OF_PINS-Character.getNumericValue(secondThrows[round]));
         }
      if(secondThrows[round] =='/')
      {
         thirdNeeded = true;
         thirdThrow = cup.roll(NUM_OF_PINS);
      }
//      System.out.println(thirdThrow);
      redDie = rand.nextInt(6);
      switch(redDie){
      case 0:
         if(thirdThrow == 'X')
            thirdThrow = '9';
         else if (thirdThrow == '/')
         {
         tempInt = '9' - secondThrows[round] + CHAR_ADJUST;
         thirdThrow = (char)tempInt;
         }
         else thirdThrow--;
      case 1:
         if(thirdThrow == 'X' || thirdThrow == '/')
            break;
         else 
            thirdThrow--;
      default:
      break;
      }
      if(thirdThrow=='0' || thirdThrow == ',' || thirdThrow=='+')
      thirdThrow='-';
   }
}

void redDieHandler(char current[],int round)
{
   int temp;
   switch(redDie)
   {
      case 0:
         if(current[round] == 'X')
            {
               current[round] = '9';
            }
         else if(current[round] == '/')
         {
            temp = '9' - firstThrows[round] + CHAR_ADJUST;
            current[round] = (char)temp;
         }
         else
            current[round]--;
         break;
      case 1:
         if(current[round] == 'X' || current[round] == '/')
            break;
         else 
            current[round]--;
         break;
      default:
         break;
   }

   if(current[round]=='0' || current[round] == ',' || current[round]=='+')
      current[round]='-';
   
}
char dashRemover(char isDash)
{
   if(isDash == '-')
      return '0';
   else
      return isDash;
}

int calculateScore(int round)
{
   assert round >= 0 : "round cannot be negative";
   final int MAX_SCORE = 30;
   int temp = 0;
   int finalFrameTotal =0;
   
   //turns '-' into 0
   firstThrows[round] = dashRemover(firstThrows[round]);
   secondThrows[round] = dashRemover(secondThrows[round]);
   thirdThrow = dashRemover(thirdThrow);

      //## just adds them
   if(Character.isDigit(firstThrows[round]) && Character.isDigit(secondThrows[round]))
   {
      return firstThrows[round] + secondThrows[round] - CHAR_ADJUST-CHAR_ADJUST;
   }
   //round 9 is actually simple. just count the pins knocked down.
   if(round == 9)
   {
      switch (thirdThrow)
      {
         case 'X':
            finalFrameTotal +=10;
            break;
         case '/':
            finalFrameTotal +=10;
            finalFrameTotal -=secondThrows[9] - CHAR_ADJUST; //if adding 10, have to take off the previous pins knocked down
            break;
         default:
            finalFrameTotal +=thirdThrow - CHAR_ADJUST;
      }
      
      switch (secondThrows[9])
      {
      case 'X':
         finalFrameTotal+=10;
         break;
      case '/':
         finalFrameTotal+=10;
         finalFrameTotal-=firstThrows[9] - CHAR_ADJUST;
         break;
      default:
         finalFrameTotal += secondThrows[9] - CHAR_ADJUST;
         break;
      }
      
      switch (firstThrows[9])
      {
      case 'X':
         finalFrameTotal+=10;
         break;
      default:
         finalFrameTotal += firstThrows[9] - CHAR_ADJUST;
         break;
      
      }
      return finalFrameTotal;
      
   }
      
   
   else 
   {  //slightly recursive to grab next frame's total
      if(firstThrows[round] == 'X')
      {
         if(secondThrows[round+1]=='/')
            return 20;
         temp = 10 + calculateScore(round+1);
         if(temp > MAX_SCORE)
            return MAX_SCORE;
         else 
            return temp;
      }
      
      else if(secondThrows[round] == '/')
      {
         if(firstThrows[round+1] == 'X')
            return 20;
         else if(firstThrows[round+1] == '-')
            return 10;
         else
            return 10 + firstThrows[round+1] - CHAR_ADJUST;
      }
   }
return 0;
}


void printScore()
{
//prints formatted display and calculates score as it goes
   System.out.print("| * |");
   for(int i = 0; i<9;i++)
   {
      System.out.print(" |"+firstThrows[i] + "|" + secondThrows[i] + "|");
   }
   System.out.print(firstThrows[9]+ "|" + secondThrows[9]+ "|");
   if(thirdNeeded)
   System.out.print(thirdThrow);
   else 
   System.out.print(" ");
   System.out.println("|");
   System.out.format("|#%-2d",playerNumber); 
   for(int i = 0; i<10;i++)
   {
      runningTotal += calculateScore(i);
      System.out.format("| %3d ",runningTotal);
   }
   System.out.println("|");
   }


public static void main(String[] args)
{
Player temp = new Player(1);
for(int i =1;i<11;i++)
{
temp.playRound(i);
}
//temp.playRound(1);


}



}