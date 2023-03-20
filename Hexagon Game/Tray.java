import java.util.ArrayList;

class Tray
{
   ArrayList<Hexagon> inSolution = new ArrayList<Hexagon>();
   Tray()
   {
       
      Hexagon temp = new Hexagon('1','6','2','4','5','3');//D
      inSolution.add(temp);
      for(int i=0;i<6;i++)
         {
            temp = new Hexagon(' ',' ',' ',' ',' ',' ');
            inSolution.add(temp);
         }
       temp = new Hexagon('1','6','5','4','3','2');//A
       inSolution.add(temp);
       temp = new Hexagon('1','4','3','6','5','2');//B
       inSolution.add(temp);       
       temp = new Hexagon('1','6','4','2','5','3');//C
       inSolution.add(temp);       
       temp = new Hexagon('1','6','5','3','2','4');//E
       inSolution.add(temp);       
       temp = new Hexagon('1','4','6','2','3','5');//F
       inSolution.add(temp);
       temp = new Hexagon('1','2','3','4','5','6');//G
       inSolution.add(temp);
   }

   void swap(int locationA, int locationB)
   {
      Hexagon temp = inSolution.get(locationA);
      inSolution.set(locationA, inSolution.get(locationB));
      inSolution.set(locationB, temp);
   }
   
   void rotate(int location)
   {
      inSolution.get(location).rotate();
   
   }
   
   boolean checkForWin()
   {
   boolean flag = true;
   for(int i = 1; i <= 6; i++)
   {
      if(inSolution.get(0).nums[i-1] != inSolution.get(i).nums[(i+2)%6])
         flag = false;
   }
   if(inSolution.get(1).nums[2] != inSolution.get(2).nums[5])
      flag =false;
   if(inSolution.get(2).nums[3] != inSolution.get(3).nums[0])
      flag =false;
   if(inSolution.get(3).nums[4] != inSolution.get(4).nums[1])
      flag =false;
   if(inSolution.get(4).nums[5] != inSolution.get(5).nums[2])
      flag =false;
   if(inSolution.get(5).nums[0] != inSolution.get(6).nums[3])
      flag =false;
   if(inSolution.get(6).nums[1] != inSolution.get(1).nums[4])
      flag =false;         
 
   return flag;
   }

}