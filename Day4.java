import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {
    public static void main(String[] args) {
        System.out.println("Part 1 Answer: " + part1());
    }
    
    public static int part1() {

        char[][] grid = getArray("input4");
        int numAccessible = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int totalAdjacent = 0;
                int r = grid[i].length - 1; // Right bound
                int b = grid.length - 1; // Bottom bound
                if (grid[i][j] == '@') {

                    if (i != 0 && grid[i-1][j] == '@') totalAdjacent++; // Top
                    if (i != b && grid[i+1][j] == '@') totalAdjacent++; // Bottom
                    
                    if (j != 0 && grid[i][j-1] == '@') totalAdjacent++; // Left
                    if (j != r && grid[i][j+1] == '@') totalAdjacent++; // Right
                    
                    if (i != 0 && j != 0 && grid[i-1][j-1] == '@') totalAdjacent++; // Top Left
                    if (i != 0 && j != r && grid[i-1][j+1] == '@') totalAdjacent++; // Top Right
                    if (i != b && j != 0 && grid[i+1][j-1] == '@') totalAdjacent++; // Bottom Left
                    if (i != b && j != r && grid[i+1][j+1] == '@') totalAdjacent++; // Bottom Right
                    
                    if (totalAdjacent < 4) numAccessible++;
                }
                    
            }
        }

        return numAccessible;
    }

    public static char[][] getArray(String fileName) {
        char[][] ret = new char[138][138];
        int index = 0;

        try (Scanner s = new Scanner(new File(fileName))) {
            while (s.hasNext()) {
                ret[index] = s.nextLine().toCharArray();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        

        return ret;
    }
}
