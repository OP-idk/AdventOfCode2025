import java.util.Scanner;
import java.io.File;
public class C2 {
    public static void main(String[] args) {

        try (Scanner s = new Scanner(new File("input"))) {
            int password = 0;
            int position = 50;
            while(s.hasNextLine()) {
                String next = s.nextLine();
                int dir = next.substring(0,1).equals("R") ? 1 : -1;
                int clicks = Integer.parseInt(next.substring(1));
                for (int i = 0; i < clicks; i++) {
                    System.out.println(position);
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
            System.out.println(password);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}