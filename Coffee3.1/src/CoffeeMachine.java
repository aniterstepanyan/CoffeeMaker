import java.util.Scanner; //import Scanner from Java libraries
public class CoffeeMachine {
    public static void main(String []args){
        /* One cup of coffee made on this coffee machine contains **/
        int water = 200;
        int milk = 50;
        int coffee = 15;

        int num, num1, num2; //for calculation stuff
        int cup; //for additional cups

        /*Scanner stuff **/
        Scanner scan = new Scanner(System.in);

        System.out.print("Write how many ml of water the coffee machine has: ");
        int w = scan.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        int m = scan.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has: ");
        int c = scan.nextInt();
        System.out.print("Write how many cups of coffee you will need: ");
        int cups = scan.nextInt();

        /* general calculation **/
        num = w / water;
        num1 = m / milk;
        num2 = c / coffee;

        /*find minimum value**/
        int number;
        if (num <= num1 && num <= num2) {
            number = num;
        } else if (num1 <= num2 && num1 <= num) {
            number = num1;
        } else {
            number = num2;
        }

        /* general operators**/
        if (number == cups){
            System.out.println("Yes, I can make that amount of coffee");
        }
        else if (number > cups){
            cup = number - cups;
            System.out.println("Yes, I can make that amount of coffee (and even " + cup + " more than that)");
        }
        else {
            System.out.println("No, I can make only " + number + " cup(s) of coffee");
        }
    }
}

