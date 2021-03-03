import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NoisettesBoard
{
    //frame and panels
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel grid = new JPanel();
    //layouts
    private BorderLayout panelL = new BorderLayout();
    private GridLayout gridL = new GridLayout(4,4);
    //pictures
    private Picture emptyP = new Picture("Empty.png", 0);
    private Picture holeP = new Picture("Hole.png", 0);
    private Picture flowerP = new Picture("Flower.png", 0);
    private Picture up = new Picture("BigArrow.png", 0);
    private Picture left = new Picture("Arrow.png", 270);
    private Picture right = new Picture("Arrow.png", 90);
    private Picture down = new Picture("BigArrow.png", 180);

    //buttons 
    //private JButton[][] hole = new JButton[4][4];
    private JButton[][] tile = new JButton[4][4];
    private JButton arrowUp = new JButton(up);
    private JButton arrowLeft = new JButton(left);
    private JButton arrowRight = new JButton(right);
    private JButton arrowDown = new JButton(down);
    //squirrels
    private Squirrels squirrel1 = new Squirrels();
    private Squirrels squirrel2 = new Squirrels();
    



    /*void setButton(JButton toChange)
    {

        tile[i] = toChange;
    }*/

   

    public NoisettesBoard()
    {   

        //Panel layouts
        panel.setLayout(panelL);
        grid.setLayout(gridL);
        panel.add(grid);

        
        arrowLeft.setBorder(null);
        arrowRight.setBorder(null);

        //adding pictures to buttons
        for (int i = 0; i < 4; i++) 
        {
            for (int j = 0; j < 4; j++) 
            {
                if ((i == 0 && j == 2) || (i == 1 && j == 0) || (i == 2 && j == 1) || (i == 3 && j == 3))
                {
                    //adding holes to grid
                    tile[i][j] = new JButton(holeP);
                    grid.add(tile[i][j]);
                }
                else
                {
                    //adding empty tiles to grid
                    tile[i][j] = new JButton(emptyP);
                    grid.add(tile[i][j]);
                }
            }
        }

        
        panel.add("North", arrowUp);
        panel.add("East", arrowRight);
        panel.add("South", arrowDown);
        panel.add("West", arrowLeft); 

        /*
        for(int i=1; i < 17; i++)
        {
            if((i == 3) || (i == 5) || (i == 10) || (i == 16))
            {
                //tiles with holes
                hole[i] = new JButton(holeP);
                grid.add(hole[i]);
    
            }
            else
            {
                //empty tiles
                tile[i] = new JButton(emptyP);
                grid.add(tile[i]);

            }
            
        }
        */
        /*//tiles
        for(int i=1; i < 17; i++)
        {
            if((i == 3) || (i == 5) || (i == 10) || (i == 16))
            {
                //tiles with holes
                JButton hole = new JButton(holeP);
                grid.add(hole);
            }
            else
            {
                JButton tile = new JButton(emptyP);
                grid.add(tile);
            }
            //JButton tile = new JButton(emptyP);
            //grid.add(tile);
            
        }
        */
        

        //adding squirrels
        //red squirrel
        tile[1][1].setIcon(squirrel1.getRed1()); 
        tile[1][2].setIcon(squirrel1.getRed2()); 
        //grey squirrel
        tile[2][2].setIcon(squirrel2.getGrey1()); 
        tile[3][2].setIcon(squirrel2.getGrey2()); 
        //flower
        tile[2][1].setIcon(flowerP); 


        //Frame
        frame.setContentPane(panel);
        frame.setTitle("Welcome to Cache Noisette!");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}