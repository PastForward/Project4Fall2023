package project4fall2023;

/**
 * This is the Location Class
 * @author Aron Kabai-Tokes
 */
public class Location implements Comparable<Location> {
    
    private String description;
    private LinkedBag<Location> neighbors;
    
    /**
     * initializes description and neighbors linked list
     * @param initDescription the description of the location
     */
    public Location(String initDescription) {
        description = initDescription;
        neighbors = new LinkedBag<>();
    }
    
    /**
     * Gets the location's description 
     * @return the description of the location
     */
    public String getDescription() {
        return this.description;
    } 
    
    
    /**
     * gets and returns if the location is a neighbor
     * @param otherLocation the location to test if its a neighbor
     * @return true if otherLocation is a neighbor, false otherwise
     */
    public Boolean isNeighbor(Location otherLocation) {
        return neighbors.exists(otherLocation);
    }
    
    /**
     * Compares description fields
     * @param otherLocation the location to compare to
     * @return 0 if exactly the same, greater than or less than 0 if it 
     * lexicographically proceeds or precedes the otherLocation description
     */
    @Override
    public int compareTo(Location otherLocation) {
        return this.description.compareTo(otherLocation.getDescription());
    }
    
    /**
     *  Compares one location to another to determine equality
     * @param otherLocation the location to compare to
     * @return true if the same, false otherwise
     */
    public Boolean equals(Location otherLocation) {
        return this.description.equals(otherLocation.getDescription());
    }
    
    /**
     * Adds a location to the neighbors linked list
     * @param neighbor the location to make a neighbor 
     */
    public void addNeighbor(Location neighbor) {
        neighbors.add(neighbor);
    }
    
    /**
     * Textual representation of location using just the description
     * @return the description of this location
     */
    @Override
    public String toString() {
        return description;
    }
    
    /**
     * Gets the number of neighbors in the linked list
     * @return the number of neighbors in the linked list
     */
    public int numNeighbors() {
        return neighbors.getSize();
    }
    
    /**
     * Gets the Lister from the neighbors linked list
     * @return list of neighbors
     */
    public Lister<Location> neighbors() {
        return neighbors.iterator();
    }
    
}
