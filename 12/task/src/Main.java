public class Main {
    public static void main(String[] args) {
        try (X x = new X(); Y y = new Y()) {
            x.doIt();
            y.doIt();
        } catch (Exception e) {
            System.out.print("exception");
        }
    }
}
