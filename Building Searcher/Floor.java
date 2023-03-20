class Floor{
public boolean [] [] rooms;
public final int DIMENSION = 10;
public int floorNumber;
Floor(int z)
{  
   floorNumber = z;
   rooms = new boolean [DIMENSION][DIMENSION];
   for (int i = 0; i< DIMENSION; i++)
   {
      for (int j = 0; j<DIMENSION; j++)
      {
         rooms[i][j] = false;
      }
   }   
      
}//end constructor

void setTrue(int x, int y)
{
   rooms[x][y] = true;
}

void setFalse(int x, int y)
{
   rooms[x][y] = false;
}


}