import java.io.IOException;
class Display
{
   Tray inSolution;

   Display(Tray trayToPrint)
   {
      inSolution = trayToPrint;
   
   }

   public void draw(int score) throws IOException, InterruptedException
   {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
      System.out.println("Current Score: " + score);  
      drawTray();
      printInstructions();



   
   }
   private void printInstructions()
   {
      System.out.println("\nPress X to exit\nPlease select a tile(A-M)");
      System.out.println("Then press R to rotate or select a Tile to swap with.(A-M)\n");
      
   }
   
   private void drawTray()
   {
      System.out.println("         __ __            ");
      System.out.println("        /  " + inSolution.inSolution.get(1).nums[0] + "  \\          ");
      System.out.println("  __ __/ " + inSolution.inSolution.get(1).nums[5] + " B " + inSolution.inSolution.get(1).nums[1] + " \\__ __    ");
      System.out.println(" /  " + inSolution.inSolution.get(6).nums[0] + "  \\ " + inSolution.inSolution.get(1).nums[4] + "   " + inSolution.inSolution.get(1).nums[2] + " /  " + inSolution.inSolution.get(2).nums[0] + "  \\  ");
      System.out.println("/ " + inSolution.inSolution.get(6).nums[5] + " G " + inSolution.inSolution.get(6).nums[1] + " \\__" + inSolution.inSolution.get(1).nums[3] + "__/ " + inSolution.inSolution.get(2).nums[5] + " C " + inSolution.inSolution.get(2).nums[1] + " \\ ");
      System.out.println("\\ " + inSolution.inSolution.get(6).nums[4] + "   " + inSolution.inSolution.get(6).nums[2] + " /  " + inSolution.inSolution.get(0).nums[0] + "  \\ " + inSolution.inSolution.get(2).nums[4] + "   " + inSolution.inSolution.get(2).nums[2] + " / ");
      System.out.println(" \\__" + inSolution.inSolution.get(6).nums[3] + "__/ " + inSolution.inSolution.get(0).nums[5] + " A " + inSolution.inSolution.get(0).nums[1] + " \\__" + inSolution.inSolution.get(2).nums[3] + "__/  ");
      System.out.println(" /  " + inSolution.inSolution.get(5).nums[0] + "  \\ " + inSolution.inSolution.get(0).nums[4] + "   " + inSolution.inSolution.get(0).nums[2] + " /  " + inSolution.inSolution.get(3).nums[0] + "  \\  ");
      System.out.println("/ " + inSolution.inSolution.get(5).nums[5] + " F " + inSolution.inSolution.get(5).nums[1] + " \\__" + inSolution.inSolution.get(0).nums[3] + "__/ " + inSolution.inSolution.get(3).nums[5] + " D " + inSolution.inSolution.get(3).nums[1] + " \\ ");
      System.out.println("\\ " + inSolution.inSolution.get(5).nums[4] + "   " + inSolution.inSolution.get(5).nums[2] + " /  " + inSolution.inSolution.get(4).nums[0] + "  \\ " + inSolution.inSolution.get(3).nums[4] + "   " + inSolution.inSolution.get(3).nums[2] + " / ");
      System.out.println(" \\__" + inSolution.inSolution.get(5).nums[3] + "__/ " + inSolution.inSolution.get(4).nums[5] + " E " + inSolution.inSolution.get(4).nums[1] + " \\__" + inSolution.inSolution.get(3).nums[3] + "__/  ");
      System.out.println("       \\ " + inSolution.inSolution.get(4).nums[4] + "   " + inSolution.inSolution.get(4).nums[2] + " /         ");
      System.out.println("        \\__" + inSolution.inSolution.get(4).nums[3] + "__/          ");
      System.out.println();
      System.out.println("  __ __     __ __     __ __     __ __     __ __     __ __  ");
      System.out.println(" /  " + inSolution.inSolution.get(7).nums[0] + "  \\   /  " + inSolution.inSolution.get(8).nums[0] + "  \\   /  " + inSolution.inSolution.get(9).nums[0] + "  \\   /  " + inSolution.inSolution.get(10).nums[0] + "  \\   /  " + inSolution.inSolution.get(11).nums[0] + "  \\   /  " + inSolution.inSolution.get(12).nums[0] + "  \\ ");
      System.out.println("/ " + inSolution.inSolution.get(7).nums[5] + " H " + inSolution.inSolution.get(7).nums[1] + " \\ / " + inSolution.inSolution.get(8).nums[5] + " I " + inSolution.inSolution.get(8).nums[1] + " \\ / " + inSolution.inSolution.get(9).nums[5] + " J " + inSolution.inSolution.get(9).nums[1] + " \\ / " + inSolution.inSolution.get(10).nums[5] + " K " + inSolution.inSolution.get(10).nums[1] + " \\ / " + inSolution.inSolution.get(11).nums[5] + " L " + inSolution.inSolution.get(11).nums[1] + " \\ / " + inSolution.inSolution.get(12).nums[5] + " M " + inSolution.inSolution.get(12).nums[1] + " \\");
      System.out.println("\\ " + inSolution.inSolution.get(7).nums[4] + "   " + inSolution.inSolution.get(7).nums[2] + " / \\ " + inSolution.inSolution.get(8).nums[4] + "   " + inSolution.inSolution.get(8).nums[2] + " / \\ " + inSolution.inSolution.get(9).nums[4] + "   " + inSolution.inSolution.get(9).nums[2] + " / \\ " + inSolution.inSolution.get(10).nums[4] + "   " + inSolution.inSolution.get(10).nums[2] + " / \\ " + inSolution.inSolution.get(11).nums[4] + "   " + inSolution.inSolution.get(11).nums[2] + " / \\ " + inSolution.inSolution.get(12).nums[4] + "   " + inSolution.inSolution.get(12).nums[2] + " /");
      System.out.println(" \\__" + inSolution.inSolution.get(7).nums[3] + "__/   \\__" + inSolution.inSolution.get(8).nums[3] + "__/   \\__" + inSolution.inSolution.get(9).nums[3] + "__/   \\__" + inSolution.inSolution.get(10).nums[3] + "__/   \\__" + inSolution.inSolution.get(11).nums[3] + "__/   \\__" + inSolution.inSolution.get(12).nums[3] + "__/ ");
   }

}