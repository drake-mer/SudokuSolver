package com.dkremer.solver;
import java.util.TreeSet;

public class NaiveSolver extends Sudoku {

    NaiveSolver() {
        super();
    }
    NaiveSolver(Integer[][] grid) {
        super(grid);
    }

    void oneStepSolver(){
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (this.getValue(i,j) == 0) {
                    TreeSet<Integer> my = this.possibleDigits(i, j);
                    if (my.size() == 1) {
                        // pop the only element
                        Integer answer = my.first();
                        this.setValue(i, j, answer);
                    }
                }
            }
        }
        this.print();
        System.out.println("");
        if (!this.isComplete()){
            this.oneStepSolver();
        }
    }

    void testSolverCase0(){
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
        this.setGrid(myGrid);
        this.oneStepSolver();
    }
}
