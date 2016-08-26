package com.ida.idagame;

/**
 * Created by rfarsian on 8/25/16.
 */
public class User {

    protected static int numID;
    protected static int numCC;
    protected static int cash;
    protected static String name;

    public User(){
        numID = 1;
        numCC = 0;
        cash = 0;
        name = "Coggs";
    }

    public static void action(String actionType) {
        switch (actionType) {
            case "openAccount":
                cash += 10000;
            case "hackID":
                numID++;
            case "stealCC": {
                numCC++;
                cash += 2500;
            }
        }
    }

}
