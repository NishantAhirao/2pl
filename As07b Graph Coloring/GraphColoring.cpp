#include <bits/stdc++.h>
using namespace std;

/*
defining a macro that denotes the total number of vertices of the graph
*/
#define V 4

/* A function to print the color configuration*/
void printConfiguration(int colorArray[]) {
   cout << "The assigned colors are as follows: " << endl;
   for (int i = 0; i < V; i++)
      cout << "Vertex: " << i << " Color: " << colorArray[i] << endl;
}

/*
A function that will check if the current color of the graph is safe or not.
*/
bool isSafe(bool graph[V][V], int colorArray[]) {
   for (int i = 0; i < V; i++)
      for (int j = i + 1; j < V; j++)
         if (graph[i][j] && colorArray[j] == colorArray[i])
            return false;
   return true;
}

/*
A recursive function that takes the current index, number of vertices, and the color array. If the recursive call returns true then the coloring is possible. It returns
false if the m colors cannot be assigned.
*/
bool graphColoringAlgorithm(bool graph[V][V], int m, int i,
                            int colorArray[V]) {
   /*
   If we have reached the last vertex then check and print the configuration.
   */
   if (i == V) {
      if (isSafe(graph, colorArray)) {
         printConfiguration(colorArray);
         return true;
      }
      return false;
   }

   // Assigning color to the vertex and recursively calling the function.
   for (int j = 1; j <= m; j++) {
      colorArray[i] = j;

      if (graphColoringAlgorithm(graph, m, i + 1, colorArray))
         return true;

      colorArray[i] = 0;
   }

   return false;
}

int main() {
   bool graph[V][V] = {
       {0, 1, 1, 1},
       {1, 0, 1, 0},
       {1, 1, 0, 1},
       {1, 0, 1, 0},
   };
   int m = 3;

   int colorArray[V];
   /*
   Initially, the color array is initialized with 0.
   */
   for (int i = 0; i < V; i++)
      colorArray[i] = 0;

   if (graphColoringAlgorithm(graph, m, 0, colorArray))
      cout << "Coloring is possible!";
   else
      cout << "Coloring is not possible!";

   return 0;
}
