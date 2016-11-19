package intodarkness.android.intodarkness;

import java.util.concurrent.ThreadLocalRandom;

public class Maze {
    private int[][] mazeArray;
    private int rows;
    private int columns;

    static final int WALL = 1;
    static final int PATH = 0;

    //Basic constructor for the maze; creates a maze full of walls
    public Maze(int numRows, int numCols){
        this.rows = numRows;
        this.columns = numCols;
        this.mazeArray = new int[rows][columns];
        initializeMaze();
    }

    public void initializeMaze(){

        //Initialize the n x m array with all walls, and add paths later
        for(int i = 0; i < (this.columns * 2) + 1; i++){
            for(int j = 0; j < (this.rows * 2) + 1; j++){
                this.mazeArray[i][j] = WALL;
            }
        }
    }

    public void generateMaze(){
        //pick out a random cell position, and turn it into a path
        int randRowPos = 2 * ThreadLocalRandom.current().nextInt(0, (rows)) + 1;
        int randColPos = 2 * ThreadLocalRandom.current().nextInt(0, (columns)) + 1;
        mazeArray[randRowPos][randColPos] = PATH;

        //Start depth-first search

    }

    public void display(){
        for(int i = 0; i < columns * 2 + 1; i++){
            for(int j = 0; j < rows * 2 + 1; j++){
                System.out.print(mazeArray[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
