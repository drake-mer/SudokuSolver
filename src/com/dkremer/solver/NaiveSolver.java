package com.dkremer.solver;
import java.util.TreeSet;

public class NaiveSolver extends Sudoku {
    NaiveSolver(Integer[][] grid) {
        super(grid);
    }

    void OneStepSolver(){
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
            this.OneStepSolver();
        }
    }


}
