package project4fall2023;

/**
 *  This is the main driver for Project4Fall2023
 * @author Aron Kabai-Tokes
 */
import java.util.Scanner;

public class Project4Fall2023 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Lister<Location> neighborsList;
        Location newLocation;
        boolean CONTINUE;
        int input;
        int count;
        
        CONTINUE = true;
        HouseGraph houseGraph = new HouseGraph();
        Location currentRoom = houseGraph.getHomeLocation();
        
        do {
            System.out.println("\nYou are currently in room "
                    + currentRoom.getDescription());
            System.out.println("neighbors of "
                    + currentRoom.getDescription()
                    + " are: ");
            neighborsList = currentRoom.neighbors();
            count = 1;

            while(neighborsList.hasNext()) {

                newLocation = neighborsList.next();
                System.out.print(count + "-" + newLocation.getDescription());

                if (neighborsList.hasNext())
                    System.out.print(", ");
                count++;

            }
        
            System.out.print("\n\nWhere would you like to go? (-1 to exit): ");
            
            input = scanner.nextInt();
            
            if (input == -1) {
                CONTINUE = false;
            } else if (input < 1 || input > currentRoom.numNeighbors()) {
                System.out.println("\noops! not a neighbor");
            } else {
                
                neighborsList = currentRoom.neighbors();
                count = 1;
                while(neighborsList.hasNext()) {
                    newLocation = neighborsList.next();
                    if (input == count)
                        currentRoom = newLocation;
                    count++;
                }
            }
            
            
        } while(CONTINUE);
        System.out.println("Good bye!");
    }
}
