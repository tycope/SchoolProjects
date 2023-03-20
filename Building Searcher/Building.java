import java.util.*;
class Building
{
   int floorCount;
   ArrayList<Floor> floors;
   Building(int numFloors)
   {
      floorCount = numFloors;
      floors = new ArrayList<Floor>();
      for(int i = 0; i< numFloors;i++) //america is the only country that starts on floor 1. 
         {
            Floor temp = new Floor(i);
            floors.add(temp);
         }
      this.Hide();
   }// end constructor

   public void Hide()
   {
      Random rand = new Random();
      int z = rand.nextInt(floorCount); //floor
      int x = rand.nextInt(10);         //row
      int y = rand.nextInt(10);         //column
      Floor temp = floors.get(z);
      System.out.println("Hidden at: " + x + ", " + y + " on floor " + z + ".");

            
      temp.setTrue(x,y);
   }

   public void Search()
   {  
      FloorSearcher temp;
   
      for(int i = 0;i<floorCount;i++)
      {
         temp = new FloorSearcher(floors.get(i));
         temp.start();
      }
   
   }



}