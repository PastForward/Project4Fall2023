package project4fall2023;

/**
 *
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 */
public class HouseGraph extends LinkedGraph
{
    // establish rooms
    private final Location kitchen = new Location("Kitchen");
    private final Location pantry = new Location("Pantry");
    private final Location diningRoom = new Location("Dining Room");
    private final Location backFoyer = new Location("Back Foyer");
    private final Location frontFoyer = new Location("Front Foyer");
    private final Location study = new Location("Study");
    private final Location livingRoom = new Location("Living Room");      
    private final Location stairs = new Location("Stairs");
    private final Location upstairsHallway = new Location("Upstairs Stairs Hallway");
    
    // establish the "home" (a.k.a. "starting") location
    private final Location homeLocation = frontFoyer;
    
    /**
     * Constructor (pun intended) builds a house as a LinkedGraph
     */
    public HouseGraph()
    {
        // add rooms to graph - first floor
        addVertex(kitchen);
        addVertex(pantry);
        addVertex(diningRoom);
        addVertex(backFoyer);
        addVertex(frontFoyer);
        addVertex(study);
        addVertex(livingRoom);
        // add rooms to graph - second floor
        addVertex(stairs);
        addVertex(upstairsHallway);
        // you add 5 more rooms
        
        // Add each edge (this undirected Graph has 7 edges,
        //                  so we add 14 edges)
        addEdge(kitchen,pantry);
        addEdge(pantry,kitchen);

        addEdge(pantry,diningRoom);
        addEdge(diningRoom,pantry);

        addEdge(diningRoom,frontFoyer);
        addEdge(frontFoyer,diningRoom);

        addEdge(kitchen,backFoyer);
        addEdge(backFoyer,kitchen);

        addEdge(backFoyer,frontFoyer);
        addEdge(frontFoyer,backFoyer);

        addEdge(frontFoyer,livingRoom);
        addEdge(livingRoom,frontFoyer);

        addEdge(backFoyer,study);
        addEdge(study,backFoyer);          
        
        // connect and build second floor
        addEdge(frontFoyer, stairs);
        addEdge(stairs, frontFoyer);
        
        addEdge(stairs, upstairsHallway);
        addEdge(upstairsHallway, stairs);
    }
    
    /**
     * the getHomeLocation method returns "a" location as the starting point
     * @return a Location that is the "home"(starting) location
     */
    public Location getHomeLocation()
    {
        return homeLocation;
    }
    
    
}
