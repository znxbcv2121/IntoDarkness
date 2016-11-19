package intodarkness.android.intodarkness;

/**
 * Created by Kaitlyn on 11/19/2016.
 */

public class ExpandedMaze {
    private int[][] mazeArray;
    private int nRows;
    private int nCols;

    static final int WALL = 1;
    static final int PATH = 0;

    //Basic constructor for the maze; creates a maze full of walls
    public ExpandedMaze(int n, Maze m){
        this.nRows = n*m.getMazeArray().length;
        this.nCols = n*m.getMazeArray()[0].length;
        this.mazeArray = new int[nRows][nCols];
        setValues(n, m);
    }

    public void setValues(int n, Maze m) {
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                this.mazeArray[i][j] = m.getMazeArray()[(int)Math.floor(i/n)][(int)Math.floor((double)j/n)];
            }
        }
    }

    public void display(){
        for(int i = 0; i < nCols; i++){
            for(int j = 0; j < nRows; j++){
                System.out.print(mazeArray[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
