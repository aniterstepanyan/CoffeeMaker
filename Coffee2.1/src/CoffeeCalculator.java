import java.util.Scanner; // import Scanner from Java libraries.

 public class CoffeeCalculator {
     public static void main(String[] args) {
        System.out.print("Write how many cups of coffee you will need: ");

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int water = 200;
        int milk = 50;
        int coffee = 15;

        System.out.println("For " + number + " cups of coffee you will need:");
        System.out.println(water * number + "ml of water,");
        System.out.println(milk * number + "ml of milk,");
        System.out.println(coffee * number + "g of coffee beans.");

    }
}

