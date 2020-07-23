import java.util.Scanner; //import Scanner from library
public class CoffeeBrush {
    private enum State {
        Ready, SelectCoffee, Off, Filling
    }

    private Scanner scan = new Scanner(System.in);

    /*buy options*/
    private final int espresso = 1;
    private final int latte = 2;
    private final int cappuccino = 3;

    /*initial resources*/
    private int water = 400;
    private int milk = 540;
    private int coffee = 120;
    private int cups = 9;
    private int money = 550;

    private State state = State.Ready;

    private CoffeeBrush(){
        setReady();
    }

    /*one cup of espresso contains: */
    private int e_water = 250;
    private int e_coffee = 16;
    private int e_cost = 4;

    /*one cup of latte contains: */
    private int l_water = 350;
    private int l_milk = 75;
    private int l_coffee = 20;
    private int l_cost = 7;

    /*one cup of cappuccino contains: */
    private int c_water = 200;
    private int c_milk = 100;
    private int c_coffee = 12;
    private int c_cost = 6;

    /*buy method*/
    private void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
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
        }

        /*latte stuff*/
         else if (num == latte) {
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

        }

        /*cappuccino stuff*/
         else if (num == cappuccino) {
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
        }
        else {
            System.out.println("Invalid action!");
        }
    }

    /*remaining method*/
    private void remaining(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + "$ of money");
    }

    /*take method*/
    private void take() {
        System.out.println("I gave you $" + money);
        money = money - money;
    }

    /*fill method*/
    private void fill(){
        Scanner f_scan = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int fill_water = f_scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int fill_milk = f_scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int fill_coffee = f_scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int fill_cups = f_scan.nextInt();

        water = water + fill_water;
        milk = milk + fill_milk;
        coffee = coffee + fill_coffee;
        cups = cups + fill_cups;
    }

    private void setReady(){
        state = State.Ready;
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
    }

    /*whole action*/
    private void action(String input){
        if(input.equals("remaining")) {
            remaining();
            setReady();
        }
        else if(input.equals("buy")){
            buy();
            state = State.SelectCoffee;
            setReady();
        }
        else if(input.equals("fill")){
            fill();
            state = State.Filling;
            setReady();
        }
        else if(input.equals("take")){
            take();
            setReady();
        }
        else if(input.equals("exit")){
            state = State.Off;
        }


    }
    /*exit method*/
    public boolean isOff (){
        return state == State.Off;
    }
    public static void main(String args[]) {
        CoffeeBrush cb = new CoffeeBrush();
        while(!cb.isOff()){
            String input = cb.scan.nextLine();
            cb.action(input);
        }
    }
}


