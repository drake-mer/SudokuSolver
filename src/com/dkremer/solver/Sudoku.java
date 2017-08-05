package com.dkremer.solver;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.TreeSet;
/**
 * Created by david on 30/07/17.
 */


public class Sudoku {

    Sudoku(Integer [][] grid){
        /* this is the default constructor */
        this.grid = grid;
    }

    /* this is an unitialized Sudoku */
    private Integer[][] grid = new Integer[9][9] ;
    private Integer size = 9;
    public Integer [][] getGrid() {
        return this.grid;
    }

    public TreeSet<Integer> possibleDigits(int line_pos, int column_pos){
        TreeSet mySet = this.conflictingDigits(line_pos, column_pos);
        TreeSet result = new TreeSet<Integer>();
        for (int i=1; i<=this.size; i++){
            if (!mySet.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    private TreeSet conflictingDigits(int line_pos, int column_pos) {
        int line, column;
        int sline, scolumn;
        sline = 3*(line_pos/3);
        scolumn = 3*(column_pos/3);
        TreeSet mySet = new TreeSet();
        for (int i = 0; i<this.size; i++){
            /* we get the whole set of values
            that are already filled in the Sudoku
            and that we cannot place in the square
            of coords (line_pos, column_pos)
             */
            if (i!=line_pos){
                mySet.add(this.grid[i][column_pos]);
            }
            if (i!=column_pos){
                mySet.add(this.grid[line_pos][i]);
            }
            line = sline + i%3;
            column = scolumn + i/3;
            if (line != line_pos && column != column_pos)
                mySet.add(this.grid[line][column]);
        }
        return mySet;
    }

    public Stream<Integer> getFilledInColumn(int column_pos){
        return Arrays.stream(
                this.getColumn(column_pos)
        ).filter(x -> x > 0 );
    }

    public Stream<Integer> getFilledInLine(int line_pos){
        return Arrays.stream(
                this.getLine(line_pos)).filter(x -> x > 0 );
    }

    public Stream<Integer> getFilledInSquare(int square_pos){
        return Arrays.stream(
                this.getSquare(square_pos)
        ).filter(x -> x > 0 );
    }

    public Integer [] getColumn(int column_pos){
        Integer [] tmpCol = new Integer[9];
        for (int i=0; i<9; i++) {
            tmpCol[i] = this.grid[i][column_pos];
        }
        return tmpCol;
    }

    public Integer [] getLine(int line_pos) {
        return this.grid[line_pos];
    }
    
    public Integer [] getSquare(int square_pos){
        int i,j, line_pos, column_pos;
        int line_offset = (square_pos/3)*3;
        int column_offset = 3*(square_pos%3);
        Integer [] tmpSquare = new Integer[9];
        for (j=0;j<3;j++){
            for (i=0;i<3;i++){
                line_pos = i + line_offset;
                column_pos = j + column_offset;
                tmpSquare[i+3*j] = this.grid[line_pos][column_pos];
            }
        }
        return tmpSquare;
    }

    public Boolean validateSet(Integer [] inputArg){
        int sum = Arrays.stream(inputArg).reduce(
                0, (x, y) -> (x+y)
        );
        boolean containsZero =
        Arrays.stream(inputArg).anyMatch(x -> x==0);
        return (!containsZero && sum==45);
    }

    public Boolean isLineValid(int row_number){
        return validateSet(this.getLine(row_number));
    }
    public boolean isColumnValid(int column_pos){
        return validateSet(this.getColumn(column_pos));
    }
    public boolean isSquareValid(int square_pos){
        return validateSet(this.getSquare(square_pos));
    }

    public void print(){
        for (int i=0; i<9; i++){
            for (int j=0 ; j<9 ; j++){
                System.out.print(this.grid[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
