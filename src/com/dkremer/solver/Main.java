package com.dkremer.solver;


import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Integer [][] myGrid = {
            {1, 2, 3, 0, 0, 0, 0, 0, 0},
            {4, 5, 6, 0, 0, 0, 0, 0, 0},
            {7, 8, 9, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        Sudoku mySudoku = new Sudoku(myGrid);

        mySudoku.print();
        Integer [] square = mySudoku.getSquare(0);
        for (int i=0; i<9; i++) System.out.println(square[i]);
        TreeSet<Integer> mySet = mySudoku.possibleDigits(0,0) ;
        assert mySet.isEmpty();
        mySet = mySudoku.possibleDigits(8,8);
        assert mySet.contains(9);
        for (int i: mySet){
            System.out.println(i);
        }
        mySet = mySudoku.possibleDigits(3,1);
        assert mySet.contains(9);
        for (int i: mySet){
            System.out.println(i);
        }
    }
}
