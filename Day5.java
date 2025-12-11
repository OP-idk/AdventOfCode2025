import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Day5 {
    public static void main(String[] args) {
        System.out.println("Part 1 Solution: " + part1());

    }

    public static int part1() {
        int numFresh = 0;
        ArrayList<Long[]> ranges = new ArrayList<>();
        try (Scanner s = new Scanner(new File("input5_ranges"))) {
            while (s.hasNext()) {
                String[] rangeStrings = s.nextLine().split("-");
                Long[] range = new Long[2];
                range[0] = Long.parseLong(rangeStrings[0]);
                range[1] = Long.parseLong(rangeStrings[1]);
                ranges.add(range);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return -1;
        }
        
        ArrayList<Long> values = new ArrayList<>();
        try (Scanner s = new Scanner(new File("input5_values"))) {
            while (s.hasNext()) {
                values.add(Long.parseLong(s.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return -1;
        }

        for (Long value : values) {
            for (Long[] range : ranges) {
                if (value >= range[0] && value <= range[1]) {
                    numFresh++;
                    break;
                }
            }
        }

        return numFresh;
    }
}
