import java.util.Scanner;

public class CoffeeLoop {
    private static boolean Exit; //for exit function

    public static void main(String[] args) {
        /*one cup of coffee contains: */
        int water = 400;
        int milk = 540;
        int coffee = 120;
        int cups = 9;
        int money = 550;

        /*one cup of espresso contains: */
        int e_water = 250;
        int e_coffee = 16;
        int e_cost = 4;

        /*one cup of latte contains: */
        int l_water = 350;
        int l_milk = 75;
        int l_coffee = 20;
        int l_cost = 7;

        /*one cup of cappuccino contains: */
        int c_water = 200;
        int c_milk = 100;
        int c_coffee = 12;
        int c_cost = 6;

        /*main options*/
        String buy = "buy";
        String fill = "fill";
        String take = "take";
        String remaining = "remaining";
        String exit = "exit";

        /*buy options*/
        int espresso = 1;
        int latte = 2;
        int cappuccino = 3;
        int back = 4;


        /*whole loop*/
        while (!Exit) {
            /*general Scanner stuff*/
            Scanner scan = new Scanner(System.in);

            System.out.println("Write action (" + buy + ", " + fill + ", " + take + ", " + remaining + ", " + exit + "): ");
            String phrase = scan.nextLine();

            if (phrase.equals(buy)) { //main operator

                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back to main menu:");
                int num = scan.nextInt();

                /*espresso stuff*/
                if (num == espresso) {
                    if (water >= e_water && coffee >= e_coffee) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - e_water;
                        coffee = coffee - e_coffee;
                        --cups;
                        money = money + e_cost;

                    } else if (water < e_water) {
                        System.out.println("Sorry, not enough water!");
                    } else {
                        System.out.println("Sorry, not enough coffee!");
                    }

                    /*latte stuff*/
                } else if (num == latte) {
                    if (water >= l_water && milk >= l_milk && coffee >= l_coffee) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - l_water;
                        milk = milk - l_milk;
                        coffee = coffee - l_coffee;
                        --cups;
                        money = money + l_cost;
                    } else if (water < l_water) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < l_milk) {
                        System.out.println("Sorry, not enough milk!");
                    } else {
                        System.out.println("Sorry, not enough coffee!");
                    }


                    /*cappuccino stuff*/
                } else if (num == cappuccino) {
                    if (water >= c_water && milk >= c_milk && coffee >= c_coffee) {
                        System.out.println("I have enough resources, making you a coffee!");
                        water = water - c_water;
                        milk = milk - c_milk;
                        coffee = coffee - c_coffee;
                        --cups;
                        money = money + c_cost;
                    } else if (water < c_water) {
                        System.out.println("Sorry, not enough water!");
                    } else if (milk < c_milk) {
                        System.out.println("Sorry, not enough milk!");
                    } else {
                        System.out.println("Sorry, not enough coffee!");
                    }
                } else if (num == back) {
                    continue;
                } else {
                    System.out.println("Invalid action!");
                }
            } else if (phrase.equals(fill)) { //main operator
                System.out.println("Write how many ml of water do you want to add:");
                int fill_water = scan.nextInt();
                System.out.println("Write how many ml of milk do you want to add:");
                int fill_milk = scan.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add:");
                int fill_coffee = scan.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                int fill_cups = scan.nextInt();

                /*fill stuff calculation*/
                water = water + fill_water;
                milk = milk + fill_milk;
                coffee = coffee + fill_coffee;
                cups = cups + fill_cups;

            } else if (phrase.equals(take)) { //main operator
                System.out.println("I gave you $" + money);
                money = money - money;

            } else if (phrase.equals(remaining)) { //main operator

                System.out.println("The coffee machine has:");
                System.out.println(water + " of water");
                System.out.println(milk + " of milk");
                System.out.println(coffee + " of coffee beans");
                System.out.println(cups + " of disposable cups");
                System.out.println(money + "$ of money");
            } else if (phrase.equals(exit)){ //main operator
                System.exit(0);
            }
            else {
                System.out.println("Invalid action");
            }
        }
    }
}
