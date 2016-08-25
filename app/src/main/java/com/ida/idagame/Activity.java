package com.ida.idagame;

/**
 * Created by rfarsian on 8/25/16.
 */
public class Activity {

    public static void action(String actionType) {

        switch (actionType.toLowerCase()) {
            case "openAcct":
                User.money += 10000;
            case "hackID":
                User.num_id++;
            case "stealC": {
                User.num_cc++;
                User.money += 2500;
            }
        }
    }

}
