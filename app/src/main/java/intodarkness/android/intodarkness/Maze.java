package intodarkness.android.intodarkness;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Maze {
    private int[][] mazeArray;
    private int rows;
    private int columns;

    static final int WALL = 1;
    static final int PATH = 0;

    static final int NORTH = 0;
    static final int EAST = 1;
    static final int WEST = 2;
    static final int SOUTH = 3;
    int[] DIRECTIONS = new int[] {NORTH, EAST, WEST, SOUTH};

    int posX = 1;
    int posY = 1;

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

    public void generateMaze(int x, int y){
        //Mark this cell as visited
        mazeArray[x][y] = PATH;

        //Start depth-first search
        Collections.shuffle(Arrays.asList(DIRECTIONS));
        for(int dir : DIRECTIONS){
            if(checkNeighbor(dir)){
                generateMaze(posX, posY);
            }
        }
    }

    //Checks whether the neighbor has been visited or not
    //i.e. if visited, it would return false.
    public boolean checkNeighbor(int direction){
        switch(direction){
            case NORTH:
                //if the north neighbor is out of bounds return false
                if(posY - 2 < 0)
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                // and return true
                if (mazeArray[posX][posY - 2] == 1){
                    posY -= 2;
                    mazeArray[posX][posY - 1] = 0;
                    mazeArray[posX][posY - 2] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

            case EAST:
                //if the east neighbor is out of bounds return false
                if(posX + 2 > (rows * 2))
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                if (mazeArray[posX + 2][posY] == 1){
                    posX += 2;
                    mazeArray[posX + 2][posY] = 0;
                    mazeArray[posX + 2][posY] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

            case WEST:
                //if the west neighbor is out of bounds return false
                if(posX - 2 < 0)
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                if (mazeArray[posX - 2][posY] == 1){
                    posX -= 2;
                    mazeArray[posX - 2][posY] = 0;
                    mazeArray[posX - 2][posY] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

            case SOUTH:
                //if the east neighbor is out of bounds return false
                if(posX + 2 > (rows * 2))
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                if (mazeArray[posX + 2][posY] == 1){
                    posX += 2;
                    mazeArray[posX + 2][posY] = 0;
                    mazeArray[posX + 2][posY] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

        }
        throw new IllegalArgumentException("Illegal direction passed");
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
