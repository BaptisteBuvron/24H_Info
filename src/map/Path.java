package map;

// Java program to find path between two
// cell in matrix
class Path {

    // Method for finding and printing
    // whether the path exists or not
    public static void isPath(
            int matrix[][], int n) {
        // Defining visited array to keep
        // track of already visited indexes
        boolean visited[][]
                = new boolean[n][n];

        // Flag to indicate whether the
        // path exists or not
        boolean flag = false;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // if matrix[i][j] is source
                // and it is not visited
                if (
                        matrix[i][j] == 1
                                && !visited[i][j])

                    // Starting from i, j and
                    // then finding the path
                    if (isPath(
                            matrix, i, j, visited)) {
                        // if path exists
                        flag = true;
                        break;
                    }
            }
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    // Method for checking boundaries
    public static boolean isSafe(
            int i, int j,
            int matrix[][]) {

        if (
                i >= 0 && i < matrix.length
                        && j >= 0
                        && j < matrix[0].length)
            return true;
        return false;
    }

    // Returns true if there is a
    // path from a source (a
    // cell with value 1) to a
    // destination (a cell with
    // value 2)
    public static boolean isPath(
            int matrix[][],
            int i, int j,
            boolean visited[][]) {

        // Checking the boundaries, walls and
        // whether the cell is unvisited
        if (
                isSafe(i, j, matrix)
                        && matrix[i][j] != 0
                        && !visited[i][j]) {
            // Make the cell visited
            visited[i][j] = true;

            // if the cell is the required
            // destination then return true
            if (matrix[i][j] == 2)
                return true;

            // traverse up
            boolean up = isPath(
                    matrix, i - 1,
                    j, visited);

            // if path is found in up
            // direction return true
            if (up)
                return true;

            // traverse left
            boolean left
                    = isPath(
                    matrix, i, j - 1, visited);

            // if path is found in left
            // direction return true
            if (left)
                return true;

            // traverse down
            boolean down = isPath(
                    matrix, i + 1, j, visited);

            // if path is found in down
            // direction return true
            if (down)
                return true;

            // traverse right
            boolean right
                    = isPath(
                    matrix, i, j + 1,
                    visited);

            // if path is found in right
            // direction return true
            if (right)
                return true;
        }
        // no path has been found
        return false;
    }


}

/* This code is contributed by Madhu Priya */

