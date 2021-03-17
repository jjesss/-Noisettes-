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
    private Picture holeNutP = new Picture("HoleNut.png", 0);
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
    //private JButton originalI = new JButton();

    //squirrel
    private Squirrel[] squirrel = new Squirrel[4];
    private int squirrelNo;
    private int n;
    private int i;
    private int j;
    

    /*void setButton(JButton toChange)
    {

        tile[i] = toChange;
    }*/ 

    /*public void hasNut()
    {
        //change the original icon to hole with nut
        originalI = new JButton(holeNutP);
        tile[j][i].setIcon()
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

        //level 1
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

        //dropping nuts
        if(tile[squirrel[n].getY()][squirrel[n].getX()].getIcon() == holeP)
        {
            squirrel[n].dropNut();
            tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(holeNutP);
        }

        //Frame
        frame.setContentPane(panel);
        frame.setTitle("Welcome to Cache Noisette!");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    //method to check if next spot squirrel is moving to is empty
    public boolean isItEmpty(int j, int i)
    {
        boolean empty = false;
        
        for(squirrelNo = 0; squirrelNo < 2 ; squirrelNo++)
        {
            //check its moving to an empty tile
            if ( (tile[j][i].getIcon() == emptyP) || (tile[j][i].getIcon() == holeP) )
            {
                empty = true;       
            }
            else
            {
                empty = false;
            }
        }
        return empty;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton button = (JButton)e.getSource();
        //what squirrel selected
        if ((button.getIcon() == squirrel[0].getHead()))
        {
            n = 0;
        }
        if ((button.getIcon() == squirrel[1].getHead()))
        {
            n = 1;
        }

        //UP ARROW pressed
        if(arrowUp == e.getSource())
        {
            //check if out of bounds
            if ((squirrel[n].getY() >= 1) && (squirrel[n].getQ() >= 1))
            {
                //check if valid movement for L/R facing squirrels
                if ( squirrel[n].getDirection() == 270 || squirrel[n].getDirection() == 90 )
                {
                    //check head and tail allowed to move
                    if ( isItEmpty(squirrel[n].getY() - 1, squirrel[n].getX()) && isItEmpty(squirrel[n].getQ() - 1, squirrel[n].getP()))
                    {
                        //remove squirrel
                        tile[squirrel[n].getY() - 1][squirrel[n].getX()].setIcon(emptyP);
                        tile[squirrel[n].getQ() - 1][squirrel[n].getP()].setIcon(emptyP);
                        //move squirrel up
                        squirrel[n].move(-1, 0);
                        //place squirrel
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
                    }

                }

                //facing up squirrels
                else if (squirrel[n].getDirection() == 0)
                {
                    //check if head allowed to move
                    if (isItEmpty(squirrel[n].getY()-1,squirrel[n].getX()))
                    {
                        //remove squirrel
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(emptyP);
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(emptyP);
                        //move squirrel up
                        squirrel[n].move(-1, 0);
                        //place squirrel
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
                    }
                }
                //for facing down squirrels check if tail allowed to move
                else if ( (squirrel[n].getDirection() == 180) && (isItEmpty(squirrel[n].getQ()-1, squirrel[n].getP())) )
                {
                    //remove squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(emptyP);
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(emptyP);
                    //move squirrel up
                    squirrel[n].move(-1, 0);
                    //place squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
                }
                
            }
        }

        //DOWN ARROW pressed
        if(arrowDown == e.getSource())
        {
            //check down is a valid movement
            if ((squirrel[n].getY() <= 2) && (squirrel[n].getQ() <= 2))
            {
                //for horizontal squirrels
                if ( squirrel[n].getDirection() == 270 || squirrel[n].getDirection() == 90 )
                {
                    //check head and tail
                    if ( isItEmpty(squirrel[n].getY() + 1, squirrel[n].getX()) && isItEmpty(squirrel[n].getQ() + 1, squirrel[n].getP()))
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
                //facing down squirrels
                else if (squirrel[n].getDirection() == 180)
                {
                    //check if head moveable
                    if (isItEmpty(squirrel[n].getY()+1,squirrel[n].getX()))
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
                //for facing up squirrels check only tail
                else if ( (squirrel[n].getDirection() == 0) && (isItEmpty(squirrel[n].getQ()+1, squirrel[n].getP())) )
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
        }

        //LEFT ARROW pressed
        if(arrowLeft == e.getSource())
        {
            //check if left is a valid movement
            if ((squirrel[n].getX() >= 1) && (squirrel[n].getP() >= 1))
            {
                //for up and down facing squirrels 
                if ( squirrel[n].getDirection() == 180 || squirrel[n].getDirection() == 0 )
                {
                    //check head and tail moveable
                    if ( isItEmpty(squirrel[n].getY(), squirrel[n].getX()-1) && isItEmpty(squirrel[n].getQ(), squirrel[n].getP()-1))
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
                //for facing left facing squirrels
                else if (squirrel[n].getDirection() == 270) 
                {
                    //check only head moveable
                    if(isItEmpty(squirrel[n].getY(), squirrel[n].getX()-1))
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

                //for facing right facing squirrels
                else if (squirrel[n].getDirection() == 90) 
                {
                    //check only tail moveable
                    if(isItEmpty(squirrel[n].getQ(), squirrel[n].getP()-1))
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
            }  
        }

        //RIGHT ARROW pressed
        if(arrowRight == e.getSource())
        {
            //check if right is a valid movement
            //facing up and down squirrels
            if (squirrel[n].getDirection() == 0 || squirrel[n].getDirection() == 180)
            {
                //check if head and tail are free to move
                if (isItEmpty(squirrel[n].getY(),squirrel[n].getX() + 1) && isItEmpty(squirrel[n].getQ(), squirrel[n].getP() +1))
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
            
                //for facing right facing squirrels
                else if (squirrel[n].getDirection() == 90) 
                {
                    //check only head moveable
                    if(isItEmpty(squirrel[n].getY(), squirrel[n].getX()+1))
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
                //for left facing squirrels check if tail free to move
                else if (squirrel[n].getDirection() == 270)
                {
                    if(isItEmpty(squirrel[n].getQ(), squirrel[n].getP() + 1))
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
    }
}