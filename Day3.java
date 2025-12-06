import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Day3 {
    public static void main(String[] args) {
        //System.out.println("Part 1 Answer: " + part1());
        System.out.println("Part 2 Answer: " + part2());
    }

    public static int part1() {
        try (Scanner s = new Scanner(new File("input3"))) {
            ArrayList<Integer> maxJoltages = new ArrayList<Integer>();
            while (s.hasNext()) {
                String bank = s.nextLine();
                String[] digits = Day2.splitByLength(bank, 1);
                int first = 0;
                int firstIndex = 0;
                for (int i = 0; i < digits.length - 1; i++) {
                    int num = Integer.parseInt(digits[i]);
                    if (num > first) {
                        first = num;
                        firstIndex = i;
                    }
                }
                int second = 0;
                for (int i = firstIndex + 1; i < digits.length; i++) {
                    int num = Integer.parseInt(digits[i]);
                    if (num > second) {
                        second = num;
                    }
                }
                maxJoltages.add(10 * first + second);
            }

            int totalJoltage = 0; 
            for (int joltage : maxJoltages) {
                totalJoltage += joltage;
            }
            return totalJoltage;

        } catch (FileNotFoundException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
            return -1;
        } catch (Exception e ) {
            throw e;
        }
    }

    public static Long part2() {
        try (Scanner s = new Scanner(new File("input3"))) {
            ArrayList<Long> maxJoltages = new ArrayList<Long>();
            while (s.hasNext()) {
                String bank = s.nextLine();
                String[] digits = Day2.splitByLength(bank, 1);
                int[] selectedDigits = new int[12];

                int nextStartIndex = 0;
                for (int i = 12; i > 0; i--) {
                    int max = 0;
                    int maxIndex = nextStartIndex;
                    for (int j = nextStartIndex; j <= digits.length - i; j++) {
                        int num = Integer.parseInt(digits[j]);
                        if (num > max) {
                            max = num;
                            maxIndex = j;
                        }
                    }
                    selectedDigits[12 - i] = max;
                    nextStartIndex = maxIndex + 1;
                }
                String numStr = "";
                for (int digit : selectedDigits) {
                    numStr += digit;
                }
                System.out.println(numStr);
                maxJoltages.add(Long.parseLong(numStr));
            }

            Long totalJoltage = 0L; 
            for (Long joltage : maxJoltages) {
                totalJoltage += joltage;
            }
            return totalJoltage;

        } catch (FileNotFoundException e) {
            System.out.println(e.getClass() + ": " + e.getMessage());
            return -1L;
        } catch (Exception e ) {
            throw e;
        }
    }

}
