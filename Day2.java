import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class Day2 {
    public static void main(String[] args) {
        System.out.println("Part 1 Answer: " + part1());
    }

    public static String part1() {
        try (Scanner s = new Scanner(new File("input2"))) {
            String[] rangeStrings = s.nextLine().split(",");
            ArrayList<Long> invalids = new ArrayList<Long>();

            for (String str : rangeStrings) {
                String[] range = str.split("-");
                Long start = Long.parseLong(range[0]);
                Long end = Long.parseLong(range[1]);

                for (Long i = start; i <= end; i++) {
                    String num = i.toString();
                    int len = num.length();
                    if (len % 2 == 0 && num.substring(0, len / 2)
                                            .equals(num.substring(len/2))) {
                        invalids.add(i);
                    }
                }
            }

            Long sum = 0L;
            for (Long l : invalids) {
                sum += l;
            }
            return "" + sum;
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
