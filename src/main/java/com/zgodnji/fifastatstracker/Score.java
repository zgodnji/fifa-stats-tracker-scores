package com.zgodnji.fifastatstracker;

public class Score {

    private String id;
    private String user1Id;
    private String user2Id;
    private String gameId;
    private int user1Score;
    private int user2Score;

    public Score(String id, String user1Id, String user2Id, String gameId, int user1Score, int user2Score) {
        this.id = id;
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.gameId = gameId;
        this.user1Score = user1Score;
        this.user2Score = user2Score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(String user1Id) {
        this.user1Id = user1Id;
    }


    public String getuser2Id() {
        return user2Id;
    }

    public void setUser2Id(String user2Id) {
        this.user2Id = user2Id;
    }


    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }


    public int getUser1Score() {
        return user1Score;
    }

    public void setUser1Score(int user1Score) {
        this.user1Score = user1Score;
    }


    public int getUser2Score() {
        return user2Score;
    }

    public void setUser2Score(int user2Score) {
        this.user2Score = user2Score;
    }


}
