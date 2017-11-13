
/**
 * Write a description of class Minesweeper here.
 * 
 * @author Danny Heu
 * @version 10.31.2017
 */
import java.lang.Math;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MinesweeperBoard2{
    Cell[] board;
    int rows;
    int columns;
    
    public MinesweeperBoard2(int rows, int columns){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        board = new Cell[rows*columns];
        
        //These pieces are for the GUI.
        JFrame frame = new JFrame();
        frame.add(addCells());
        
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    public MinesweeperBoard2(){
        this(10,10);
    }
    
    public void addBombs(int bombs) {//throws Exception{
        // enter number of bombs, bombs placed in random on the board
        for (int i = 0; i < bombs; i++){
            int randInt = 0 + (int)(Math.random() * (rows*columns) - 1);
            board[randInt].setValue(-1);
        }
        }
    
    public void addNums(){
        int boardNum = (rows*columns);
        for (int i = 0; i <boardNum; i++){
            int index = 0;
            int num = 0;
            if (board[i].getValue() != -1){
                //TOP RIGHT?
                index = i-(rows + 1);
                if (index >= 0 && board[index].getValue() == -1 && index%rows !=9){
                    num+=1;
                }
                //TOP?
                index = i-rows;
                if (index >= 0 && board[index].getValue() == -1){
                    num += 1;
                }

            }
        }
    }
    
    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int index = 0;
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < columns; c++){
                if (board[index].getValue() == -1){
                    System.out.print("X ");
                } else {
                    System.out.print(board[index].getValue() + " ");
                }
                index ++;
           }
           System.out.println();
        }
    }
    
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i< rows*columns; i++){
                board[i]= new Cell();
                panel.add(board[i].getButton());
        }
        return panel;
    }

}