package com.something;

public class Main {

    public static void main(String[] args) {

        SaleGame saleGame = new SaleGame();

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            saleGame.initateGame();
            int runs = saleGame.startGame();
            System.err.println(runs);
            sum += runs;
        }
        System.err.println(sum);
        System.err.println("Average of 100 runs: " + (double) sum / 100 + " minutes");
    }
}
