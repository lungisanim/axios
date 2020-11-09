package com.company.Utilities;

public class Utilities {
    public static void sanitizeInput(int input){
        if (input < 0)
            System.exit(1);
    }

    public static int getInteger(String choicestr) {
        if (Integer.getInteger(choicestr).getClass() != Integer.class)
            return -1;
        return Integer.getInteger(choicestr);
    }
}
