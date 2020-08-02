public class Machine {
    public static void main(String args[]) {
        CoffeeBrush coffeeBrush = new CoffeeBrush();
        while(!coffeeBrush.isOff()){
            String input = coffeeBrush.scan.nextLine();
            coffeeBrush.action(input);
        }
    }
}
