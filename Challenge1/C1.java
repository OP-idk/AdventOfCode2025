import java.util.Scanner;
import java.io.File;
public class C1 {
    public static void main(String[] args) {

        try (Scanner s = new Scanner(new File("input"))) {
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
            System.out.println(password);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}