
public class DefangingIP {
    public static String defangIp(String s) {
        return s.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String returnValue = DefangingIP.defangIp("255.100.50.0");
        System.out.println("solution is:");
        System.out.println(returnValue);
    }
}
