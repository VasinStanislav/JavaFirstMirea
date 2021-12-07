package ru.mirea.task24;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTesting {
    private static final String IP_ADDRESS = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private final Pattern pattern;

    public RegularExpressionTesting() {
        pattern = Pattern.compile(IP_ADDRESS);
    }

    public boolean validate(final String ip)    {
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args)  {
         RegularExpressionTesting ip = new RegularExpressionTesting();
         System.out.println(ip.validate("255.255.255.0"));
         System.out.println(ip.validate("256.255.255.0"));
         System.out.println(ip.validate("87.211.29.12"));
         System.out.println(ip.validate("bfdssdf"));
         System.out.println(ip.validate("abc.def.gh.ij"));
    }

}
