public class Machine {
    public static void main(String args[]) {
        CoffeeBrush cb = new CoffeeBrush();
        while(!cb.isOff()){
            String input = cb.scan.nextLine();
            cb.action(input);
        }
    }
}
