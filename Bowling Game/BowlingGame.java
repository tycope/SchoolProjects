import java.util.ArrayList;

class BowlingGame
{
private int playerCount;
ArrayList<Player> players;

BowlingGame(int numOfPlayers)
{
   playerCount = numOfPlayers;
   
   players = new ArrayList<Player>();
   for(int i=1;i<=numOfPlayers;i++)
   {
      Player temp = new Player(i);
      players.add(temp);
   }  
}
//neither of these methods have pre/post conditions as they have no parameters and return nothing. assertions not used
void run()
{
   for (int i =0;i<10;i++)//10 rounds
   {
      for(int j=0; j<players.size();j++)
      {
         players.get(j).playRound(i);
      }
   }
}

void print()
{
   System.out.println("NAME|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10  |");
   System.out.println("----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----|");
   for(int i =0; i< players.size();i++)
   {
      players.get(i).printScore();
      System.out.println("|---------------------------------------------------------------|");
   }
}



}