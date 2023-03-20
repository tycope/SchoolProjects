import java.io.IOException; 
import java.util.Scanner; 
class GameDriver
{

public static void main(String[] args)throws IOException, InterruptedException
{
   Hexagon current;
   Tray masterTray = new Tray();
   Display graphics = new Display(masterTray);
   Scanner in = new Scanner(System.in);
   
   int count = 1;
   char menuSelection = ' ';
   char target;
   int firstHex;
   int secondHex;
   
   
   while(menuSelection != 'X')
   {
   graphics.draw(count);
      if(masterTray.checkForWin())
      {
      System.out.println("Congrats! You have won with a score of: " + count+ "!");
      break;
      }
   menuSelection = Character.toUpperCase(in.next().charAt(0));
   if(menuSelection == 'X')
      break;
   target = Character.toUpperCase(in.next().charAt(0));
   firstHex  = menuSelection - 65;
   secondHex = target - 65;
   if(target == 'R')
      masterTray.rotate(firstHex);
   else
     masterTray.swap(firstHex,secondHex);
   count++;

   }   
   
   
   
 /*  while(true)
 //  {
   graphics.draw();
   Thread.sleep(1000);
   masterTray.swap(1,9);
   graphics.draw();
   Thread.sleep(1000);
   masterTray.rotate(0);
   graphics.draw();
 */

}

}