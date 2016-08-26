package com.ida.idagame;

import java.util.Random;

/**
 * Created by rfarsian on 8/25/16.
 */
public class Business {

    protected static float difficulty;
    protected static float reward;

    public Business() {
        difficulty = 0;
        reward = 0;
    }

    public Business(double latitude, double longitude){
        int rewardSeed = (int) (Math.pow(10, 6) * Math.round(latitude));
        int difficultySeed = (int) (Math.pow(10, 6) * Math.round(longitude));
        Random rewardGenerator = new Random(rewardSeed);
        Random difficultyGenerator = new Random(difficultySeed);

        float rewardProb = rewardGenerator.nextInt(100);
        float difficultyProb = difficultyGenerator.nextInt(100);
    }

}
