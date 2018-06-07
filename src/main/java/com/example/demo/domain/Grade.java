package com.example.demo.domain;

public class Grade {
    private Float low;

    private Float upp;

    private String rank;

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getUpp() {
        return upp;
    }

    public void setUpp(Float upp) {
        this.upp = upp;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }
}