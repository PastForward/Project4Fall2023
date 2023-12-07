package project4fall2023;

/**
 * This is the LinkedGraph class.
 * @author Aron Kabai-Tokes
 */
public class LinkedGraph {
    
    private LinkedBag<Location> vertexList;
    
    public LinkedGraph() {
        vertexList = new LinkedBag<>();
    }
    
    /**
     * adds a new Location to known graph by adding it to the vertexList
     * @param newVertex The new location to add
     */
    public void addVertex(Location newVertex) {
        vertexList.add(newVertex);
    }
    
    /**
     * Gets the size of the list of vertices
     * @return the number of vertices in the known graph
     */
    public int size() {
        return vertexList.getSize();
    }
    
    /**
     * adds an edge to the graph. If the source and destination are in the
     * known list of vertices, the second location is added as a neighbor 
     * to the first Location passed.
     * @param source the location to add an edge to
     * @param destination the edge to add to the vertices
     */
    public void addEdge(Location source, Location destination) {
        
        // if the source exists, add the desination to its list of neighbors
        if (vertexList.exists(source) && vertexList.exists(destination))    
            source.addNeighbor(destination);
    }
    
    /**
     * If the source and destination are in the known list of vertices, the 
     * second Location is checked to see if it is a neighbor of the first Location
     * @param source the initial location to check for neighbors
     * @param destination the possible neighbor
     * @return true if the destination is a neighbor of the source, false 
     * otherwise
     */
    public boolean isEdge(Location source, Location destination) {
        if (vertexList.exists(source) && vertexList.exists(destination))
            return source.isNeighbor(destination);
        else
            return false;
    }
    
    public Lister<Location> neighbors(Location vertex) {
        return vertexList.iterator();
    }
    
}
