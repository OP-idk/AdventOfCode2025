
import java.util.Scanner;
import java.io.File;
public class Day1 {
    public static void main(String[] args) {
        System.out.println("Part 1 Answer: " + part1());
        System.out.println("Part 2 Answer: " + part2());
    }

    public static String part1() {
        try (Scanner s = new Scanner(new File("input1"))) {
            int password = 0;
            int position = 50;
            while(s.hasNextLine()) {
                String next = s.nextLine();
                if (next.substring(0, 1).equals("R")) {
                    position += Integer.parseInt(next.substring(1));
                } else {
                    position -= Integer.parseInt(next.substring(1));
                }

                if (position >= 100) {
                    position %= 100;
                } else if (position <= 0) {
                    position = (100 + (position % 100)) % 100;
                }
                
                if (position == 0) {
                    password++;
                }
            }
            return "" + password;

        } catch (Exception e) {
           return e.getMessage();
        }
    }

    public static String part2() {
        try (Scanner s = new Scanner(new File("input1"))) {
            int password = 0;
            int position = 50;
            while(s.hasNextLine()) {
                String next = s.nextLine();
                int dir = next.substring(0,1).equals("R") ? 1 : -1;
                int clicks = Integer.parseInt(next.substring(1));
                for (int i = 0; i < clicks; i++) {
                    //System.out.println(position);
                    if (position == 0 || position == 100) {
                        position = dir == 1 ? 0 : 100;
                        password++;
                    }
                    position += dir;
                }
            }
            if (position == 0 || position == 100) {
                password++;
            }
            return "" + password;

        } catch (Exception e) {
            return e.getMessage();
        }

    }

}