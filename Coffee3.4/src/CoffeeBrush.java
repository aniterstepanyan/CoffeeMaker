import java.util.Scanner; //import Scanner from library
public class CoffeeBrush {
    /**
     * Buy options
     * */
    private final int espresso = 1;
    private final int latte = 2;
    private final int cappuccino = 3;

    /**
     * Initial resources of coffee machine
     * */
    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int cups = 9;
    private int money = 550;

    /**
     * One cup of espresso contains:
     * */
    private int espressoWater = 250;
    private int espressoCoffee = 16;
    private int espressoCost = 4;
    private State state = State.READY;

    /**
     * One cup of latte contains:
     * */
    private int latteWater = 350;
    private int latteMilk = 75;
    private int latteCoffee = 20;
    private int latteCost = 7;

    /**
     * One cup of cappuccino contains:
     * */
    private int cappuccinoWater = 200;
    private int cappuccinoMilk = 100;
    private int cappuccinoCoffee = 12;
    private int cappuccinoCost = 6;

    private enum State {
        READY, SELECT_COFFEE, OFF, FILLING
    }

    public Scanner scan = new Scanner(System.in);

    CoffeeBrush(){
        setReady();
    }

    /**
     * Buy method
     * This method is scanning your choice
     * */
    private void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int num = scan.nextInt();

        /**
         * Espresso if else statement
         * Calculates resources if you choose espresso
         * */
        if (num == espresso) {
            if (water >= espressoWater && coffee >= espressoCoffee) {
                System.out.println("I have enough resources, making you a coffee!");
                water = water - espressoWater;
                coffee = coffee - espressoCoffee;
                --cups;
                money = money + espressoCost;
            } else if (water < espressoWater) {
                System.out.println("Sorry, not enough water!");
            } else {
                System.out.println("Sorry, not enough coffee!");
            }
        }

        /**
         * Latte if else statement
         * Calculates resources if you choose latte
         * */
         else if (num == latte) {
            if (water >= latteWater && milk >= latteMilk && coffee >= latteCoffee) {
                System.out.println("I have enough resources, making you a coffee!");
                water = water - latteWater;
                milk = milk - latteMilk;
                coffee = coffee - latteCoffee;
                --cups;
                money = money + latteCost;
            } else if (water < latteWater) {
                System.out.println("Sorry, not enough water!");
            } else if (milk < latteMilk) {
                System.out.println("Sorry, not enough milk!");
            } else {
                System.out.println("Sorry, not enough coffee!");
            }

        }

        /**
         * Cappuccino if else statement
         * Calculates resources if you choose cappuccino
         * */
         else if (num == cappuccino) {
            if (water >= cappuccinoWater && milk >= cappuccinoMilk && coffee >= cappuccinoCoffee) {
                System.out.println("I have enough resources, making you a coffee!");
                water = water - cappuccinoWater;
                milk = milk - cappuccinoMilk;
                coffee = coffee - cappuccinoCoffee;
                --cups;
                money = money + cappuccinoCost;
            } else if (water < cappuccinoWater) {
                System.out.println("Sorry, not enough water!");
            } else if (milk < cappuccinoMilk) {
                System.out.println("Sorry, not enough milk!");
            } else {
                System.out.println("Sorry, not enough coffee!");
            }
        }
        else {
            System.out.println("Invalid action!");
        }
    }

    /**
     * Remaining method
     * Method just remains you how much resources you have
     * */
    private void remaining(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + "$ of money");
    }

    /**
     * Take method
     * This method gave you all money
     * */
    private void take() {
        System.out.println("I gave you $" + money);
        money = money - money;
    }

    /**
     * Fill method
     * You can fill how much resources you want
     * */
    private void fill(){
        Scanner fillScan = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int fillWater = fillScan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int fillMilk = fillScan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int fillCoffee = fillScan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int fillCups = fillScan.nextInt();

        water = water + fillWater;
        milk = milk + fillMilk;
        coffee = coffee + fillCoffee;
        cups = cups + fillCups;
    }

    private void setReady(){
        state = State.READY;
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

    /**
     * Whole action
     * */
    void action(String input){
        if(input.equals("remaining")) {
            remaining();
            setReady();
        }
        else if(input.equals("buy")){
            buy();
            state = State.SELECT_COFFEE;
            setReady();
        }
        else if(input.equals("fill")){
            fill();
            state = State.FILLING;
            setReady();
        }
        else if(input.equals("take")){
            take();
            setReady();
        }
        else if(input.equals("exit")){
            state = State.OFF;
        }


    }
    /**
     * Exit method
     * Exit program
     * */
    public boolean isOff (){
        return state == State.OFF;
    }

}


