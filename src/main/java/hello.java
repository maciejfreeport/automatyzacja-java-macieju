import java.util.Scanner;

public class hello {

    public static void main(String[] args) {
        System.out.println("Hello World");

        String input = null;
        while (!("exit".equalsIgnoreCase(input))){
            System.out.println("Type exit to close");
            Scanner sc = new Scanner(System.in);
            input = sc.next();
        }
        System.exit(0);
    }
}
