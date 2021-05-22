package map;

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
}
