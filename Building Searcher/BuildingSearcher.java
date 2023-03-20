class BuildingSearcher
{

public static void main(String[] args)
{
int floors = 10;


Building toSearch; 

if(args.length == 0)
{
   System.out.println("Usage: BuildingSearcher [number of floors]");
//   System.exit(0);
}

//floors = Integer.valueOf(args[0]);
toSearch= new Building(floors);
toSearch.Search();

} // End main

} // End class