package com.something;

public class Main {

    public static final int NUMBER_OF_RUNS = 100;

    public static void main(String[] args) {

        SaleGame saleGame = new SaleGame();

        int sum = 0;
        for (int i = 0; i < NUMBER_OF_RUNS; i++) {
            saleGame.initateGame();
            int runs = saleGame.startGame();
            sum += runs;
        }
        System.out.println("Average of 100 runs: " + (double) sum / NUMBER_OF_RUNS + " minutes");
    }
}
