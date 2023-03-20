class Hexagon
{
   char name;
   char [] nums;
   Hexagon n  = null;
   Hexagon ne = null;
   Hexagon se = null;
   Hexagon sw = null;
   Hexagon s  = null;
   Hexagon nw = null;
   
   Hexagon(char a, char b, char c, char d, char e, char f)
   {
      nums = new char[6];
      nums[0] = a;
      nums[1] = b;      
      nums[2] = c;
      nums[3] = d;      
      nums[4] = e;
      nums[5] = f;
   }
//needs more
   void rotate()
   {
      char temp =nums[0];
      for(int i =0 ; i<5 ; i++)
         {
            nums [i] = nums[i+1];
         }
         nums[5] = temp;
   }













}