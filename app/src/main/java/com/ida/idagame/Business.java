package com.ida.idagame;

import java.util.Random;

/**
 * Created by rfarsian on 8/25/16.
 */
public class Business {

    protected static double rewardProb;
    protected static double difficultyProb;
    protected static int rewardLevel;
    protected static int difficultyLevel;


    public Business(double latitude, double longitude){
        int rewardSeed = (int) (Math.pow(10, 6) * Math.round(latitude));
        int difficultySeed = (int) (Math.pow(10, 6) * Math.round(longitude));
        Random rewardGenerator = new Random(rewardSeed);
        Random difficultyGenerator = new Random(difficultySeed);

        rewardProb = (float) (rewardGenerator.nextInt(100)/ 100.0);
        difficultyProb = (float) (difficultyGenerator.nextInt(100) / 100.0);

        if (rewardProb <= 0.3)
            rewardLevel = 1;
        else if (rewardProb <= 0.6)
            rewardLevel = 2;
        else
            rewardLevel = 3;

        if (difficultyProb <= 0.3)
            difficultyLevel = 1;
        else if (difficultyProb <= 0.6)
            difficultyLevel = 2;
        else
            difficultyLevel = 3;

    }

}
>>>>>>> soysal
