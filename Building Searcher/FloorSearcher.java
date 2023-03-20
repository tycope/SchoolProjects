class FloorSearcher extends Thread
{

Floor current;
private boolean exit = false;
// ----------------------------------------------
public FloorSearcher(Floor toSearch)
{
this.current = toSearch;
} // End constructor


// ----------------------------------------------
@Override
public void run()
{
   System.out.println("Searching floor: " + current.floorNumber);
   for( int i = 0; i<current.DIMENSION;i++)
   {  
      if(exit)
      break;
      for( int j = 0; j<current.DIMENSION;j++)
      {  
         if(exit)
            break;
         if(current.rooms[i][j] == true)
         {
            System.out.println("Found! Person hiding at: " + i + ", " + j + " on floor: " + current.floorNumber);
         }
      }
   }

} // End method

void killThread()
{
   exit = true;
}

} // End class