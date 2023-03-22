public class fortunegen {
    public static void main(String[] args) {
        String name = "Bob";
        System.out.println(emphasizer(name + " you are in danger"));
    }

    public static String emphasizer(String s){
        return (s + "!").toUpperCase();
    }
}
