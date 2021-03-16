import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NoisettesBoard implements ActionListener
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
    private JButton[][] tile = new JButton[4][4];
    private JButton arrowUp = new JButton(up);
    private JButton arrowLeft = new JButton(left);
    private JButton arrowRight = new JButton(right);
    private JButton arrowDown = new JButton(down);
    //squirrel
    private Squirrel[] squirrels = new Squirrel[4];

    int n;
    int i;
    int j;

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
        for (i = 0; i < 4; i++) 
        {
            for (j = 0; j < 4; j++) 
            {
                if ((i == 0 && j == 2) || (i == 1 && j == 0) || (i == 2 && j == 1) || (i == 3 && j == 3))
                {
                    //adding holes to grid
                    tile[i][j] = new JButton(holeP);
                    grid.add(tile[i][j]);
                    tile[i][j].addActionListener(this);
                }
                else
                {
                    //adding empty tiles to grid
                    tile[i][j] = new JButton(emptyP);
                    grid.add(tile[i][j]);
                    tile[i][j].addActionListener(this);
                }
            }
        }

        
        panel.add("North", arrowUp);
        arrowUp.addActionListener(this);
        panel.add("East", arrowRight);
        arrowRight.addActionListener(this);
        panel.add("South", arrowDown);
        arrowDown.addActionListener(this);
        panel.add("West", arrowLeft); 
        arrowLeft.addActionListener(this);

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

        //make array of squirrels
        //red squirrel
        squirrels[0] = new Squirrel(0,1,1,2,1,270);
        //grey squirrel
        squirrels[1] = new Squirrel(1,2,2,2,3,0);
        
        //JButton squirrelTile = new JButton(squirrels[n].getHead)
        //place red squirrel
        tile[squirrels[0].getY()][squirrels[0].getX()].setIcon(squirrels[0].getHead()); 
        tile[squirrels[0].getQ()][squirrels[0].getP()].setIcon(squirrels[0].getTail()); 
        //place grey squirrel
        tile[squirrels[1].getY()][squirrels[1].getX()].setIcon(squirrels[1].getHead()); 
        tile[squirrels[1].getQ()][squirrels[1].getP()].setIcon(squirrels[1].getTail()); 
        //place flower
        tile[2][1].setIcon(flowerP); 

        int n;

        //Frame
        frame.setContentPane(panel);
        frame.setTitle("Welcome to Cache Noisette!");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // TODO Auto-generated method stub
        JButton button = (JButton)e.getSource();
        //System.out.println(button);
      
        if ((button.getIcon() == squirrels[0].getHead()))
        {
            squirrels[n] = squirrels[0];
        }
        
        if ((button.getIcon() == squirrels[1].getHead()))
        {
            squirrels[n] = squirrels[1];
        }


        if(arrowUp == e.getSource())
        {
            //check up is a valid movement
            if ((squirrels[n].getY() >= 1) && (squirrels[n].getQ() >= 1) && ((squirrels[n].getY() && squirrels[n].getP()) + )
            {
                //remove squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(emptyP); 
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(emptyP);
                //move squirrel up
                squirrels[n].move(-1, 0);
                //place squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(squirrels[n].getHead());
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(squirrels[n].getTail());
            }
        }
        else if(arrowDown == e.getSource())
        {
            //check down is a valid movement
            if ((squirrels[n].getY() <= 2) && (squirrels[n].getQ() <= 2))
            {
                //remove squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(emptyP); 
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(emptyP);
                //move squirrel down
                squirrels[n].move(1, 0);
                //place squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(squirrels[n].getHead());
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(squirrels[n].getTail());
            }
        }
        else if(arrowLeft == e.getSource())
        {
            //check if left is a valid movement
            if ((squirrels[n].getX() >= 1) && (squirrels[n].getP() >= 1))
            {
                //remove squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(emptyP); 
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(emptyP);
                //move squirrel left
                squirrels[n].move(0, -1);
                //place squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(squirrels[n].getHead());
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(squirrels[n].getTail()); 
            }
           
        }
        else if(arrowRight == e.getSource())
        {
            //check if right is a valid movement
            if((squirrels[n].getX() <= 2) && (squirrels[n].getP() <= 2))
            {    
                //remove squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(emptyP); 
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(emptyP);
                //move squirrel right
                squirrels[n].move(0, 1);
                //place squirrel
                tile[squirrels[n].getY()][squirrels[n].getX()].setIcon(squirrels[n].getHead());
                tile[squirrels[n].getQ()][squirrels[n].getP()].setIcon(squirrels[n].getTail());
            } 
        }
    }
}