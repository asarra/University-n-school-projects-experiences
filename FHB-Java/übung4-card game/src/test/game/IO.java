package test.game;

import java.util.Scanner;

public class IO {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * @param options
     */
    private static void printOptions(int x,String[] options) {
        if(x<options.length-x) {
            System.out.println(options[x]);
            printOptions(++x, options);
        }
        else if(x==options.length-1){
            System.out.println(options[x]);
        }

    }

    /**
     * @param header
     * @param options is an array of strings, containing the possible options
     */
    private static void printMenu(String header, String[] options) {

        System.out.printf("-------------------------------------------------------------------%n%s%n-------------------------------------------------------------------%n",header);
        printOptions(0,options);
    }

    public static void print(String option){
        System.out.println(option);
    }

    /**
     * Print a menu with options, return a 0-based selection or fallbackDigit.
     *
     * @param menuHeader is the title of the menu.
     * @param options is an array of strings, containing the possible options.
     * @param fallbackDigit is returned for incorrect inputs.
     */
    public static int menuSelection(String menuHeader, String[] options, int fallbackDigit) {
        printMenu(menuHeader, options);
        return 0;
    }

    public static int menuSelection(String menuHeader, String[] options) {
        return menuSelection(menuHeader, options, 0);
    }

    public static void menuWithoutHeader(String[] options){
        printOptions(0,options);
    }

    public static void menuWithoutOptions(String header){
        printMenu(header,new String[]{""});
    }
}
