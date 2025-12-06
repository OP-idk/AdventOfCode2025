import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class Part1 {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(new File("input"))) {
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
            System.out.println(sum);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
