package map;

import java.util.ArrayList;
import java.util.Arrays;

public class Map {
    private String[][] map = new String[31][31];

    public void createMap(String mapStr){
        int ligne = 0;
        int col = 0;
        for (int i = 0; i < mapStr.length(); i++) {
            if (col >30){
                ligne++;
                col = 0;
            }
            map[ligne][col] = String.valueOf(mapStr.charAt(i));
            col++;
        }
    }

    public void displayMap(){
        for (String[] row : map){
            System.out.println(Arrays.toString(row));
        }
    }

    public ArrayList findPath(Integer[] a, Integer[] b){
        int[][] pathMap = new int[31][31];
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                if (!map[i][j].equals("R")){
                    pathMap[i][j] = 0;
                }else {
                    pathMap[i][j] = 3;
                }
            }
        }
        pathMap[a[0]][a[1]] = 1;
        pathMap[b[0]][b[1]] = 2;
       /* for (int[] row : pathMap){
            System.out.println(Arrays.toString(row));
        }*/
        return Path.isPath(pathMap,31);
    }

    public ArrayList findPath2(Integer[] a, Integer[] b){
        char[][] pathMap = new char[31][31];
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                if (!map[i][j].equals("R")){
                    pathMap[i][j] = '0';
                }else {
                    pathMap[i][j] = '*';
                }
            }
        }
        pathMap[a[0]][a[1]] = 's';
        pathMap[b[0]][b[1]] = 'd';
       for (char[] row : pathMap){
            System.out.println(Arrays.toString(row));
        }

       ArrayList<int[]> path = Maze.minDistance(pathMap);
        System.out.println("Le chemin de plus cours chemin : ");
        for (int[] row : path){
            System.out.println(Arrays.toString(row));
        }
        //return null;
        return path;
    }

}
