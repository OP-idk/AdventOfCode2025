import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Day2 {
    public static void main(String[] args) {
        System.out.println("Part 1 Answer: " + part1());
        System.out.println("Part 2 Answer: " + part2());
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

    public static String part2() {
        try (Scanner s = new Scanner(new File("input2"))) {
            String[] rangeStrings = s.nextLine().split(",");
            ArrayList<Long> invalids = new ArrayList<Long>();

            for (String rangeStr : rangeStrings) {
                String[] range = rangeStr.split("-");
                Long start = Long.parseLong(range[0]);
                Long end = Long.parseLong(range[1]);

                for (Long i = start; i <= end; i++) {
                    String num = i.toString();
                    int len = num.length();
                    boolean invalid = false; 

                    for (int j = 1; j <= len / 2; j++) {
                        if (len % j != 0) continue;

                        String[] list = splitByLength(num, j);
                        invalid = allEqual(list);

                        if (invalid) {
                            invalids.add(i);
                            break;
                        }
                    }
                    
                }
            }

            Long sum = 0L;
            for (Long l : invalids) {
                sum += l;
            }
            return "" + sum;
            
        } catch (FileNotFoundException e) {
            return e.getClass() + ": " +  e.getMessage();
        } catch (Exception e) {
            throw e;
        }
    }

    // Help from https://stackoverflow.com/a/3760193
    private static String[] splitByLength(String str, int len) {
        int numRets = str.length() / len;
        String[] ret = new String[numRets];
        for (int i = 0; i < numRets; i++) {
            ret[i] = str.substring(i * len, Math.min(str.length(), (1+i) * len));
        }
        return ret;
    }

    private static boolean allEqual(String[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (!list[i].equals(list[i+1])) {
                return false;
            }
        }
        return true;
    }
}
