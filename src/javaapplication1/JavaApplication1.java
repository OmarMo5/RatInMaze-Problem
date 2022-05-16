package javaapplication1;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JavaApplication1 {
    
    public static int[] exit={12,12};
    public static boolean goalAchieved=false;
    int[][] matrice = { 
    { 1,0, 0, 0,1, 1, 1,1, 1, 1,1, 1, 1 },
    { 1,0, 0, 0,0, 0, 1,1, 1, 1,1, 1, 1 },
    { 1,0, 0, 1,1, 0, 0,0, 0, 0,0, 0, 0 },
    { 1,0, 0, 1,1, 0, 1,1, 1, 1,1, 1, 0 },
    { 1,0, 0, 1,1, 0, 1,1, 1, 1,1, 1, 1 },
    { 1,0, 0, 0,0, 0, 1,1, 1, 1,0, 0, 0 },
    { 1,0, 0, 1,1, -1, 1,1, 1, 1,1, 1, 0 },
    { 1,0, 0, 0,1, 1, 1,0, 0, 0,0, 0, 0 },
    { 1,0, 0, 1,1, 1, 1,0, 1, 1,0, 0, 1 },
    { 1,0, 0, 0,0, 0, 0,0, 0, 0,0, 0, 7 },
    { 1,0, 0, 1,1, 1, 0,0, 1, 1,1, 0, 0 },
    { 1,0, 0, 0,0, 0, 0,0, 1, 0,1, 0, 0 },
    { 1,1, 1, 1,1, 1, 1,1, 1, 0,1, 1, 1 }};

    public static void setStatic() {
        goalAchieved=true;
    }
    
    JavaApplication1(int[][] matrice){
        //this.matrice=matrice;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice.length; j++) {
                this.matrice[i][j]= matrice[j][i];
                this.matrice[j][i]=matrice[i][j];
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(1500,1000);
        frame.setLayout(null);
         
        int[][] mat = { 
                    { 1,0, 1, 1,1, 1, 1,1, 0, 1,1, 1, 1 },
                    { 1,0, 1, 0,0, 1, 0,1, 1, 1,0, 0, 1 },
                    { 1,0, 1, 1,0, 1, 0,0, 0, 0,1, 1, 1 },
                    { 1,0, 0, 1,0, 1, 1,1, 1, 1,1, 0, 1 },
                    { 1,0,0,  1,0, 1, 0,0, 0, 0,0, 0, 1 },
                    { 1,0, 1, 0,0, 1, 0,1, 0, 0,1, 1, 0 },
                    { 1,0, 1, 1,1, 0, 1,1, 1, 1,1, 0, 1 },
                    { 1,1, 1, 0,0, 1, 1,0, 0, 0,0, 0, 1 },
                    { 0,0, 1, 1,1, 1, 1,1, 1, 1,1, 0, 1 },
                    { 1,0, 1, 0,0, 0, 0,0, 0, 0,1, 1, 1 },
                    { 1,1, 1, 1,1, 1, 1,1, 1, 1,0, 0, 1 },
                    { 0,0, 1, 0,1, 0, 0,0, 0, 1,0, 0, 1 },
                    { 1,1, 1, 0,1, 1, 1,1, 0, 1,1, 0, 1 }};

        JavaApplication1 m=new JavaApplication1(mat);
        int[] start={0,0};
        Thread  mazeSolver=new MazeSolver(m.matrice,start,"JavaApplication1" ) ;
        mazeSolver.start();   
                
        JPanel panel=new JPanel();
        panel.setBounds(350, 5, (mat.length*50)+50,(mat.length*50)+35);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        panel.add(MazeSolver.tt);      
        frame.add(panel);
        frame.setVisible(true);       
    }
    
}
