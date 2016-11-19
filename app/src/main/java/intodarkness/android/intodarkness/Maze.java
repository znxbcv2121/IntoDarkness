package intodarkness.android.intodarkness;

import java.util.*;
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



    //Basic constructor for the maze; creates a maze full of walls
    public Maze(int numRows, int numCols){
        this.rows = numRows;
        this.columns = numCols;
        this.mazeArray = new int[(rows*2) + 1][(columns*2)+1];
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
        List DIRECTIONS = new ArrayList();
        DIRECTIONS.add(NORTH);
        DIRECTIONS.add(SOUTH);
        DIRECTIONS.add(WEST);
        DIRECTIONS.add(EAST);
        Collections.shuffle(DIRECTIONS);

        for(Object dir : DIRECTIONS){
            if(checkNeighbor((int)dir, x, y)){
                switch ((int)dir){
                    case NORTH:
                        generateMaze(x, y - 2);
                        break;
                    case EAST:
                        generateMaze(x + 2, y);
                        break;
                    case WEST:
                        generateMaze(x - 2, y);
                        break;
                    case SOUTH:
                        generateMaze(x, y + 2);
                        break;
                }
            }
        }
    }

    //Checks whether the neighbor has been visited or not
    //i.e. if visited, it would return false.
    public boolean checkNeighbor(int direction, int x, int y){
        switch(direction){
            case NORTH:
                //if the north neighbor is out of bounds return false
                if(y - 2 < 0)
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                // and return true
                if (mazeArray[x][y - 2] == 1){
                    mazeArray[x][y - 1] = 0;
                    mazeArray[x][y - 2] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

            case EAST:
                //if the east neighbor is out of bounds return false
                if(x + 2 > (rows * 2))
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                if (mazeArray[x + 2][y] == 1){
                    mazeArray[x + 1][y] = 0;
                    mazeArray[x + 2][y] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

            case WEST:
                //if the west neighbor is out of bounds return false
                if(x - 2 < 0)
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                if (mazeArray[x - 2][y] == 1){
                    mazeArray[x - 1][y] = 0;
                    mazeArray[x - 2][y] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

            case SOUTH:
                //if the east neighbor is out of bounds return false
                if(y + 2 > (columns * 2))
                    return false;

                //if the north neighbor is unvisited, shift the y coordinate,
                //mark the neighbor and the wall as 0.
                if (mazeArray[x][y + 2] == 1){
                    mazeArray[x][y + 1] = 0;
                    mazeArray[x][y + 2] = 0;
                    return true;
                }

                //if not, return false; the neighbor has been visited
                return false;

        }
        throw new IllegalArgumentException("Illegal direction passed");
    }

    public int[][] getMazeArray(){
        return mazeArray;
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
