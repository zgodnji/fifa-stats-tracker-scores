package com.zgodnji.fifastatstracker;

import java.util.ArrayList;
import java.util.List;


public class Database {
    private static List<Score> scores = new ArrayList<>();

    public static List<Score> getScores() {
        return scores;
    }

    public static Score getScore(String scoreId) {
        for (Score score : scores) {
            if (score.getId().equals(scoreId))
                return score;
        }

        return null;
    }

    public static void addScore(Score score) {
        scores.add(score);
    }

    public static void deleteScore(String scoreId) {
        for (Score score : scores) {
            if (score.getId().equals(scoreId)) {
                scores.remove(score);
                break;
            }
        }
    }
}
