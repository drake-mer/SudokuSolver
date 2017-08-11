package com.dkremer.solver;

import com.dkremer.solver.NaiveSolver;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Integer [][] myGrid = {
            {2, 4, 0, 5, 0, 0, 7, 0, 9},
            {7, 0, 5, 0, 1, 0, 0, 0, 0},
            {0, 3, 0, 0, 8, 7, 0, 4, 0},
            {0, 0, 7, 0, 0, 0, 4, 9, 0},
            {0, 0, 6, 1, 0, 9, 8, 0, 0},
            {0, 5, 9, 0, 0, 0, 1, 0, 0},
            {0, 9, 0, 7, 2, 0, 0, 6, 0},
            {0, 0, 0, 0, 9, 0, 3, 0, 1},
            {6, 0, 2, 0, 0, 3, 0, 7, 8},
        };
        NaiveSolver my = new NaiveSolver(myGrid);
        my.OneStepSolver();
    }
}
