package map;

/*package whatever //do not write package name here */
// Java Code implementation for above problem

import java.util.*;

// QItem for current location and distance
// from source location



public class Maze {
    private static ArrayList<int[]> path = new ArrayList<>();

    public static ArrayList minDistance(char[][] grid) {
        System.out.println("Calcul plus cours chemins");
        QItem source = new QItem(0, 0,null, 0);

        // To keep track of visited QItems. Marking
        // blocked cells as visited.
        firstLoop:
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                // Finding source
                if (grid[i][j] == 's') {
                    source.row = i;
                    source.col = j;
                    break firstLoop;
                }
            }
        }

        // applying BFS on matrix cells starting from source
        Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(source.row, source.col,null, 0));


        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[source.row][source.col] = true;

        while (queue.isEmpty() == false) {
            QItem p = queue.remove();
            // Destination found;
            if (grid[p.row][p.col] == 'd'){
                QItem prev = p.prevQItem;
                while (prev.prevQItem != null){
                    System.out.println(prev);
                    path.add(new int[]{prev.row,prev.col});
                    prev = prev.prevQItem;
                }
                //path.add(new int[]{source.row,source.col});
                System.out.println(p.dist);
                Collections.reverse(path);

                return path;

            }

            // moving up
            if (isValid(p.row - 1, p.col, grid, visited)) {
                queue.add(new QItem(p.row - 1, p.col,p,p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (isValid(p.row + 1, p.col, grid, visited)) {
                queue.add(new QItem(p.row + 1, p.col,p,p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (isValid(p.row, p.col - 1, grid, visited)) {
                queue.add(new QItem(p.row, p.col - 1,p,p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (isValid(p.row, p.col + 1, grid,visited)) {
                queue.add(new QItem(p.row, p.col + 1,p,p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }
        }
        return null;
    }

    // checking where it's valid or not
    private static boolean isValid(int x, int y,
                                   char[][] grid,
                                   boolean[][] visited) {
        if (x >= 0 && y >= 0 && x < grid.length
                && y < grid[0].length && grid[x][y] != '0'
                && visited[x][y] == false) {
            return true;
        }
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        char[][] grid = {{'0', '*', '0', 's'},
                {'*', '0', '*', '*'},
                {'0', '*', '*', '*'},
                {'d', '*', '*', '*'}};

        System.out.println(minDistance(grid));

    }
}

// This code is contributed by abhikelge21.
