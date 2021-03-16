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
   

    private int n;
    private int i;
    private int j;
    private int squirrelNo;
    //squirrel
    private Squirrel[] squirrel = new Squirrel[4];
    private int Y = squirrel[n].getY();
    private int X = squirrel[n].getX();
    private int Q = squirrel[n].getQ();
    private int P = squirrel[n].getP();
    

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

        panel.setBorder(null);
        grid.setBorder(null);
        arrowLeft.setBorder(null);
        arrowUp.setBorder(null);
        arrowDown.setBorder(null);
        arrowRight.setBorder(null);

        //adding pictures to buttons
        for (j = 0; j < 4; j++) 
        {
            for (i = 0; i < 4; i++) 
            {
                if ((j == 0 && i == 2) || (j == 1 && i == 0) || (j == 2 && i == 1) || (j == 3 && i == 3))
                {
                    //adding holes to grid
                    tile[j][i] = new JButton(holeP);
                    grid.add(tile[j][i]);
                    tile[j][i].addActionListener(this);
                }
                else
                {
                    //adding empty tiles to grid
                    tile[j][i] = new JButton(emptyP);
                    grid.add(tile[j][i]);
                    tile[j][i].addActionListener(this);
                }
            }
        }

        //adding arrows 
        panel.add("North", arrowUp);
        arrowUp.addActionListener(this);
        panel.add("East", arrowRight);
        arrowRight.addActionListener(this);
        panel.add("South", arrowDown);
        arrowDown.addActionListener(this);
        panel.add("West", arrowLeft); 
        arrowLeft.addActionListener(this);

        //select levels

        squirrelNo = 2;
        //red squirrels
        squirrel[0] = new Squirrel(0,1,1,2,1,270);
        //grey squirrels
        squirrel[1] = new Squirrel(1,2,2,2,3,0);
        
        //JButton squirrelTile = new JButton(squirrels[n].getHead)
        //place red squirrel
        tile[squirrel[0].getY()][squirrel[0].getX()].setIcon(squirrel[0].getHead()); 
        tile[squirrel[0].getQ()][squirrel[0].getP()].setIcon(squirrel[0].getTail()); 
        //place grey squirrel
        tile[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        tile[squirrel[1].getQ()][squirrel[1].getP()].setIcon(squirrel[1].getTail()); 
        //place flower
        tile[2][1].setIcon(flowerP);

        //Frame
        frame.setContentPane(panel);
        frame.setTitle("Welcome to Cache Noisette!");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public boolean isItEmpty()
    {
        boolean empty = false;
        if (squirrel[n].getDirection() == 270 || squirrel[n].getDirection() == 90)
        {
            for(int squirrelNo = 0; squirrelNo < 2 ; squirrelNo++)
            {
        
                if ((tile[squirrel[n].getY()][i].getIcon() == flowerP) || (tile[squirrel[n].getY()][i].getIcon() == squirrel[squirrelNo].getHead()) || (tile[squirrel[n].getY()][i].getIcon() ==  squirrel[squirrelNo].getTail())) 
                {
                empty = false;
        
                }
                else
                {
                    empty = true;
                }
            }
        }
        else if (squirrel[n].getDirection() == 0 || squirrel[n].getDirection() == 180)
        {
            for(int squirrelNo = 0; squirrelNo < 2 ; squirrelNo++)
            {
                if ((tile[squirrel[n].getY()][i].getIcon() == flowerP) || (tile[squirrel[n].getY()][i].getIcon() == squirrel[squirrelNo].getHead()) || (tile[squirrel[n].getY()][i].getIcon() ==  squirrel[squirrelNo].getTail())) 
                {
                empty = false;
                }
                else
                {
                    empty = true;
                }
            }

        }
        return empty;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // TODO Auto-generated method stub
        JButton button = (JButton)e.getSource();


        if(arrowUp == e.getSource())
        {
            //check up is a valid movement
            if ((squirrel[n].getY() >= 1) && (squirrel[n].getQ() >= 1) )
            {
                //if((isItEmpty(squirrel[n].getY() - 1, squirrel[n].getX())) && (isItEmpty(squirrel[n].getQ() - 1, squirrel[n].getP()))
                //remove squirrel
                tile[Y][X].setIcon(emptyP);
                tile[Q][P].setIcon(emptyP);
                //move squirrel up
                squirrel[n].move(-1, 0);
                //place squirrel
                tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
            }
        }
        else if(arrowDown == e.getSource())
        {
            //check down is a valid movement
            if ((squirrel[n].getY() <= 2) && (squirrel[n].getQ() <= 2))
            {
                //remove squirrel
                tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(emptyP); 
                tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(emptyP);
                //move squirrel down
                squirrel[n].move(1, 0);
                //place squirrel
                tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
            }
        }
        else if(arrowLeft == e.getSource())
        {
            //check if left is a valid movement
            if ((squirrel[n].getX() >= 1) && (squirrel[n].getP() >= 1))
            {
                //remove squirrel
                tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(emptyP); 
                tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(emptyP);
                //move squirrel left
                squirrel[n].move(0, -1);
                //place squirrel
                tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail()); 
            }
           
        }
        else if(arrowRight == e.getSource())
        {
            //check if right is a valid movement
            if((squirrel[n].getX() <= 2) && (squirrel[n].getP() <= 2))
            {    
                //remove squirrel
                tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(emptyP); 
                tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(emptyP);
                //move squirrel right
                squirrel[n].move(0, 1);
                //place squirrel
                tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
            } 
        }
    }
}