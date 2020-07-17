import java.util.Scanner; //import Scanner from library
public class SmartCoffeeMachine {
    public static void main(String[] args) {

        /*one cup of coffee contains: **/
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int cups = 9;
        int money = 550;

        /*one cup of espresso contains: **/
        int e_water = 250;
        int e_coffee = 16;
        int e_cost = 4;

        /*one cup of latte contains: **/
        int l_water = 350;
        int l_milk = 75;
        int l_coffee = 20;
        int l_cost = 7;

        /*one cup of cappuccino contains: **/
        int c_water = 200;
        int c_milk = 100;
        int c_coffee = 12;
        int c_cost = 6;

        /*main options**/
        String buy = "buy";
        String fill = "fill";
        String take = "take";

        int f_water, f_milk, f_coffee, f_cups, f_money; //final results

        int espresso = 1;
        int latte = 2;

        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");

        Scanner scan = new Scanner(System.in);

        System.out.println("Write action (" + buy + ", " + fill + ", " + take + "):");
        String phrase = scan.nextLine();


        if (phrase.equals(buy)) {        //main operator
            System.out.println("What do you want to buy? 1-espresso , 2-latte , 3-cappuccino:");
            int num = scan.nextInt();

            /*first option operators**/
            if (num == espresso) {
                /*final results calculation**/
                f_water = water - e_water;
                f_coffee = coffee - e_coffee;
                --cups;
                f_money = money + e_cost;

                System.out.println("The coffee machine has:");
                System.out.println(f_water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(f_coffee + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(f_money + " of money");
            } else if (num == latte) {
                /*final results calculation**/
                f_water = water - l_water;
                f_milk = milk - l_milk;
                f_coffee = coffee - l_coffee;
                --cups;
                f_money = money + l_cost;

                System.out.println("The coffee machine has:");
                System.out.println(f_water + " of water");
                System.out.println(f_milk + " of milk");
                System.out.println(f_coffee + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(f_money + " of money");
            } else {
                /*final results calculation**/
                f_water = water - c_water;
                f_milk = milk - c_milk;
                f_coffee = coffee - c_coffee;
                --cups;
                f_money = money + c_cost;

                System.out.println("The coffee machine has:");
                System.out.println(f_water + " of water");
                System.out.println(f_milk + " of milk");
                System.out.println(f_coffee + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(f_money + " of money");
            }
        } else if (phrase.equals(fill)) {      //main operator
            System.out.println("Write how many ml of water do you want to add:");
            int fill_water = scan.nextInt();
            System.out.println("Write how many ml of milk do you want to add:");
            int fill_milk = scan.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add:");
            int fill_coffee = scan.nextInt();
            System.out.println("Write how many disposable cups of coffee do you want to add:");
            int fill_cups = scan.nextInt();

            /*final results calculation**/
            f_water = water + fill_water;
            f_milk = milk + fill_milk;
            f_coffee = coffee + fill_coffee;
            f_cups = cups + fill_cups;

            System.out.println("The coffee machine has:");
            System.out.println(f_water + " of water");
            System.out.println(f_milk + " of milk");
            System.out.println(f_coffee + " of coffee beans");
            System.out.println(f_cups + " of disposable cups");
            System.out.println(money + " of money");
        } else {          //main operator
            System.out.println("I gave you $" + money);
            /*final results calculation**/
            f_money = money - money;
            System.out.println("The coffee machine has:");
            System.out.println(water + " of water");
            System.out.println(milk + " of milk");
            System.out.println(coffee + " of coffee beans");
            System.out.println(cups + " of disposable cups");
            System.out.println(f_money + " of money");
        }
    }
}
