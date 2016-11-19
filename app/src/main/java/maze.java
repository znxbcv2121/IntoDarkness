import java.util.concurrent.ThreadLocalRandom;

public class maze {
    private int[][] mazeArray;
    private int rows;
    private int columns;

    static final int wall = 1;
    static final int path = 0;

    //Basic constructor for the maze; creates a maze full of walls
    public maze(int numRows, int numCols){
        this.rows = numRows;
        this.columns = numCols;
        this.mazeArray = new int[rows][columns];
        initializeMaze(rows, columns, mazeArray);
    }

    public void initializeMaze(int rows, int columns, int[][] mazeArray){

        //Initialize the n x m array with all walls, and add paths later
        for(int i = 0; i < (columns * 2) + 1; i++){
            for(int j = 0; j < (rows * 2) + 1; j++){
                mazeArray[i][j] = wall;
            }
        }
    }

    public void generateMaze(){
        //pick out a random cell position
        int randRowPos = 2 * ThreadLocalRandom.current().nextInt(0, (rows)) + 1;
        int randColPos = 2 * ThreadLocalRandom.current().nextInt(0, (columns)) + 1;
        mazeArray[randRowPos][randColPos] = path;
    }
}
