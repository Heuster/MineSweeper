
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
    Cell[][] board;
    int rows;
    int columns;
    
    public MinesweeperBoard2(int rows, int columns){
        //Put the constructor here.
        this.rows = rows;
        this.columns = columns;
        board = new Cell[rows][columns];
        
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
    
    //ADD Bombs in random index integerson the board
    public void addBombs(int bombs) {//throws Exception{
        for (int i = 0; i < bombs; i++){
            boolean createBomb = false;
            while (!createBomb){
                int randInt = (int)(Math.random() * (rows));
                int randInt2 = (int)(Math.random() * (columns));
                if (board[randInt][randInt2].getValue() == 0){
                    board[randInt][randInt2].setValue(-1);
                    createBomb = true;
                }
            }
        }
        }
    
    // Add the numbers to how close you are to a bomb
    public void addNums(){
        int boardNum = (rows*columns);
        int rowNum = (rows);
        int colNum = (columns);
        for (int i = 0; i <rowNum; i++){
            for (int j = 0; j < colNum; j++){
            int index = 0;
            int num = 0;
            if (board[i][j].getValue() != -1){
                //TOP RIGHT
                //index = i-(rows + 1);
                if (index >= 0 && board[i][j-1].getValue() == -1){
                    num+= 1;
                }
                //TOP
                //index = i-rows;
                if (index >= 0 && board[i][j-1].getValue() == -1){
                    num += 1;
                }
                //TOP LEFT
                //index = i-(rows-1);
                if (index >= 0 && board[i][j-1].getValue() == -1){
                    num += 1;
                }
                //LEFT
                //index = i-1;
               
                if (index >= 0 && board[i][j-1].getValue() == -1 ){
                    num += 1;
                }
                //RIGHT
                //index = i+1;
                if(index < boardNum && board[i][j-1].getValue() == -1 ){
                    num += 1;
                }
                //BOTTOM
                //index = i+rows;
                
                if (index  < boardNum && board[i][j-1].getValue() == -1){
                    num +=1;
                }
                //BOT LEFT
                //index = i+(rows-1);
                
                if (index < boardNum && board[i][j-1].getValue()== -1 ){
                    num +=1;
                }
                //BOT RIGHT
                //index = i+(rows+1);
                
                if (index < boardNum && board[i][j-1].getValue() == -1 ){
                    num += 1;
                }
                
                board[i][j].setValue(num);
            }
            }
            
            
        }
    }
    
    /**This method is used for testing and will be deleted if using the GUI.
     *  It is still required for all students.
     */
    public void printBoard(){
        int index = 0;
        System.out.println("    Minesweeper");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (board[i][j].getValue() == -1 ){
                    System.out.print("X ");
                } else {
                    System.out.print(board[i][j].getValue() + " ");
                }
                index ++;
                
           }
           System.out.println();
        }
        System.out.println();
    }
    
    public JPanel addCells(){
        JPanel panel = new JPanel(new GridLayout(rows,columns));
        for(int i = 0; i < rows; i++){
                for (int j = 0;j < columns; j++){
                    board[i][j] = new Cell();
                    panel.add(board[i][j].getButton());
                }
        }
        return panel;
    }

}
