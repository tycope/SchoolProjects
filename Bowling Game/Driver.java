class Driver
{

   public static void main(String[] args) 
   {
      assert args.length == 1 : "Usage: java Driver ##";
 //     assert args.length > 100 : "Usage: java Driver ##(1-99)";

      if(args.length!=1)
      {
         System.out.println("Usage: java Driver ##(1-99)");
         System.exit(1);
      }
      int players = Integer.parseInt(args[0]);
      if(players < 1 || players > 99)
      {
         System.out.println("Usage: java Driver ##(1-99)");
         System.exit(1);
      }
      else
      {
         BowlingGame game = new BowlingGame(players);
         game.run();
         game.print(); 
      }      
      
   }






}