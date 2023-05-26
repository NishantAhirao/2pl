import java.util.*;

public class GraphTraversal {
    private int vertices;
    private LinkedList <Integer>[] adjacencyList;  //array of LinkedLists

    public GraphTraversal(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];   //constructure
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();    //linkedlist is the element of array "adjacencyList" 
        }
    }


    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);       //e.g. 0 5 add 5 to the LL which is at 0th position of array
    }



    public void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices];  //array of type boolean
        Queue<Integer> queue = new LinkedList<>();   // instantiate a LinkedList object and assign it to the queue variable

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();  //remove and access the first element in the queue
            System.out.print(currentVertex + " ");

            LinkedList<Integer> adjacentVertices = adjacencyList[currentVertex]; //assigning the LL from AdL to AdV
            for (int adjacentVertex : adjacentVertices) {
                if (!visited[adjacentVertex]) {         // if veetex is not visited then the condi. becomes true then mark it visited then add it to queue new loop begins
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }
        }
    }




    public void depthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[vertices];
        depthFirstSearchUtil(startVertex, visited);
    }

    private void depthFirstSearchUtil(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        LinkedList<Integer> adjacentVertices = adjacencyList[currentVertex];
        for (int adjacentVertex : adjacentVertices) {
            if (!visited[adjacentVertex]) {
                depthFirstSearchUtil(adjacentVertex, visited);
            }
        }
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        GraphTraversal graph = new GraphTraversal(vertices); //create obj graph of GraphTraversal

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges in the format (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("Choose traversal algorithm:");
        System.out.println("1. Breadth First Search (BFS)");
        System.out.println("2. Depth First Search (DFS)");
        
    boolean conti = true;
    
    do {
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        System.out.print("Enter the starting vertex: ");
        int startVertex = scanner.nextInt();

        System.out.print("Traversal: ");
        if (choice == 1) {
            graph.breadthFirstSearch(startVertex);
        } else if (choice == 2) {
            graph.depthFirstSearch(startVertex);
        } else {
            System.out.println("Invalid choice!");
        }

        
        System.out.println("\n\nDo you want to continue?--->  0=No / 1=yes");
        int contin = scanner.nextInt();
        System.out.println("\n");
        if (contin==0) {
            conti=false;
        } else {
            
        }
        
           
    } while (conti == true );
        

        // scanner.close();
    }
}
