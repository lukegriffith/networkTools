package co.uk.lukemgriffith;

public class Main {

    public static void main(String[] args) {

        int cidr = Integer.parseInt(args[0]);
        String converted = tools.convertCIDR(cidr);
        System.out.println(converted);
        
    }
}
