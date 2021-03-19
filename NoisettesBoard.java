/** This is the board of the game. It has buttons for level selection and also a grid of buttons called gridB which contain tiles. For the pieces I set the icon of the gridBs to the picture of the piecse*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class NoisettesBoard implements ActionListener
{
    //frame and panels
    private JFrame frame = new JFrame();
    private JPanel outerPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel grid = new JPanel();
    private JPanel pickPanel = new JPanel();
    //layouts
    private BorderLayout panelL = new BorderLayout();
    private GridLayout gridL = new GridLayout(4,4);
    private FlowLayout flowL = new FlowLayout();
    //pictures
    private Picture emptyP = new Picture("Empty.png", 0);
    private Picture holeP = new Picture("Hole.png", 0);
    private Picture holeNutP = new Picture("HoleNut.png", 0);
    private Picture flowerP = new Picture("Flower.png", 0);
    private Picture up = new Picture("BigArrow.png", 0);
    private Picture left = new Picture("Arrow.png", 270);
    private Picture right = new Picture("Arrow.png", 90);
    private Picture down = new Picture("BigArrow.png", 180);
    private Picture[][] picture = new Picture[4][4];
    //buttons 
    private JButton[][] gridB = new JButton[4][4];
    private JButton arrowUp = new JButton(up);
    private JButton arrowLeft = new JButton(left);
    private JButton arrowRight = new JButton(right);
    private JButton arrowDown = new JButton(down);
    private JButton level1 = new JButton("level 1");
    private JButton level2 = new JButton("level 2");
    private JButton level3 = new JButton("level 3");

    //squirrel
    private Squirrel[] squirrel = new Squirrel[4];
    //Tile
    private Tile[][] tile = new Tile[4][4];

    private int squirrelNo;
    private int holesFilled = 0;
    private int n;
    private int i;
    private int j;

    //check if theres a hole
    public boolean checkHoles(int y, int x)
    {
        boolean hole = false;

        if(tile[y][x].getPicture() == holeP)
        {
            hole = true;
        }

        return hole;
    }

    //holes filled plus one
    public void aHoleFilled(int j, int i, int n)
    {
        holesFilled += 1;
        tile[j][i].setPicture(holeNutP);
        squirrel[n].dropNut();
    }

    //win when all nuts are in the holes
    public void ifWin()
    {
        
        if( holesFilled == squirrelNo )
        {
            try
            {
                Thread.sleep(500);
            }catch(Exception e)
            {
                System.out.println(e);
            }
            resetBoard();
            System.out.println(" SUCCESS! ALL THE NUTS ARE IN THE HOLES :) ");
            //frame.dispose();
        }
    }
    
    public void resetBoard()
    {
        //adding tiles to buttons
        for (j = 0; j < 4; j++) 
        {
            for (i = 0; i < 4; i++) 
            {
                if ((j == 0 && i == 2) || (j == 1 && i == 0) || (j == 2 && i == 1) || (j == 3 && i == 3))
                {
                    //picture of tile is the hole picture
                    tile[j][i].setPicture(holeP);  
                    gridB[j][i].setIcon(holeP);
                }
                else
                {
                    //picture of this tile is the empty picture, set the button icon to this
                    tile[j][i].setPicture(emptyP);
                    gridB[j][i].setIcon(emptyP);
                }
            }
        } 
        holesFilled = 0;
    }

    //load level one
    public void levelOne()
    {
        resetBoard();
        squirrelNo = 2;
        //red squirrel
        squirrel[0] = new Squirrel(0,1,1,270);
        //grey squirrel
        squirrel[1] = new Squirrel(1,2,2,0);
        
        //JButton squirrelTile = new JButton(squirrels[n].getHead)
        //place red squirrel
        gridB[squirrel[0].getY()][squirrel[0].getX()].setIcon(squirrel[0].getHead()); 
        gridB[squirrel[0].getTailY()][squirrel[0].getTailX()].setIcon(squirrel[0].getTail());
        //place grey squirrel
        gridB[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        gridB[squirrel[1].getTailY()][squirrel[1].getTailX()].setIcon(squirrel[1].getTail()); 
        //place flower
        gridB[2][1].setIcon(flowerP);
    }
    //load level 2
    public void levelTwo()
    {
        resetBoard();
        squirrelNo = 2;
        //black squirrel
        squirrel[0] = new Squirrel(2, 3,2, 180);
        //brown squirrel
        squirrel[1] = new Squirrel(3, 0,2, 0);

        //place grey squirrel
        gridB[squirrel[0].getY()][squirrel[0].getX()].setIcon(squirrel[0].getHead()); 
        gridB[squirrel[0].getTailY()][squirrel[0].getTailX()].setIcon(squirrel[0].getTail());
        gridB[squirrel[0].getFlowersY()][squirrel[0].getFlowersX()].setIcon(squirrel[0].getFlowers());
        //place brown squirrel
        gridB[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        gridB[squirrel[1].getTailY()][squirrel[1].getTailX()].setIcon(squirrel[1].getTail());
        gridB[squirrel[1].getFlowersY()][squirrel[1].getFlowersX()].setIcon(squirrel[1].getFlowers());
        //place flower
        gridB[3][3].setIcon(flowerP);
    }
    //load level 3
    public void levelThree()
    {
        resetBoard();
        squirrelNo = 3;
        //black squirrel
        squirrel[0] = new Squirrel(2, 2,2, 90);
        //red squirrel
        squirrel[1] = new Squirrel(0, 3,0, 90);
        //brown squirrel
        squirrel[2] = new Squirrel(3, 3,1, 90);
        //grey squirrel
        squirrel[3] = new Squirrel(2, 3,2, 180);

        //place black squirrel
        gridB[squirrel[0].getY()][squirrel[0].getX()].setIcon(squirrel[0].getHead()); 
        gridB[squirrel[0].getTailY()][squirrel[0].getTailX()].setIcon(squirrel[0].getTail());
        gridB[squirrel[0].getFlowersY()][squirrel[0].getFlowersX()].setIcon(squirrel[0].getFlowers());
        //place red squirrel
        gridB[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        gridB[squirrel[1].getTailY()][squirrel[1].getTailX()].setIcon(squirrel[1].getTail());
        //place brown squirrel
        gridB[squirrel[2].getY()][squirrel[2].getX()].setIcon(squirrel[2].getHead()); 
        gridB[squirrel[2].getTailY()][squirrel[2].getTailX()].setIcon(squirrel[2].getTail());
        gridB[squirrel[2].getFlowersY()][squirrel[2].getFlowersX()].setIcon(squirrel[2].getFlowers());
        //place grey squirres
        gridB[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        gridB[squirrel[1].getTailY()][squirrel[1].getTailX()].setIcon(squirrel[1].getTail());
    }

    public NoisettesBoard()
    {   
        //Panel layouts
        outerPanel.setLayout(flowL);
        panel.setLayout(panelL);
        grid.setLayout(gridL);
        panel.add(grid);
        outerPanel.add(pickPanel);
        outerPanel.add(panel);
        //select levels
        pickPanel.add(level1);
        level1.addActionListener(this);
        pickPanel.add(level2);
        level2.addActionListener(this);
        pickPanel.add(level3);
        level3.addActionListener(this);
        
        //setting borders to null
        outerPanel.setBorder(null);
        pickPanel.setBorder(null);
        panel.setBorder(null);
        grid.setBorder(null);
        arrowLeft.setBorder(null);
        arrowUp.setBorder(null);
        arrowDown.setBorder(null);
        arrowRight.setBorder(null);
        

        //adding arrows 
        panel.add("North", arrowUp);
        arrowUp.addActionListener(this);
        panel.add("East", arrowRight);
        arrowRight.addActionListener(this);
        panel.add("South", arrowDown);
        arrowDown.addActionListener(this);
        panel.add("West", arrowLeft); 
        arrowLeft.addActionListener(this); 
        /*
        //adding tiles to buttons
        for (j = 0; j < 4; j++) 
        {
            for (i = 0; i < 4; i++) 
            {
                if ((j == 0 && i == 2) || (j == 1 && i == 0) || (j == 2 && i == 1) || (j == 3 && i == 3))
                {
                    //adding holes to grid
                    tile[j][i] = new JButton(holeP);
                    tile[j][i].setBorder(BorderFactory.createEmptyBorder());
                    picture[j][i] = holeP;
                    grid.add(tile[j][i]);
                    tile[j][i].addActionListener(this);
                }
                else
                {
                    //adding empty tiles to grid
                    tile[j][i] = new JButton(emptyP);
                    tile[j][i].setBorder(BorderFactory.createEmptyBorder());
                    picture[j][i] = emptyP;
                    grid.add(tile[j][i]);
                    tile[j][i].addActionListener(this);
                }
            }
        }
        */

        for (j = 0; j < 4; j++) 
        {
            for (i = 0; i < 4; i++) 
            {
                if ((j == 0 && i == 2) || (j == 1 && i == 0) || (j == 2 && i == 1) || (j == 3 && i == 3))
                {
                    //adding holes to grid
                    gridB[j][i] = new JButton(holeP);
                    gridB[j][i].setBorder(BorderFactory.createEmptyBorder());
                    grid.add(gridB[j][i]);
                    gridB[j][i].addActionListener(this);
                    tile[j][i] = new Tile(j,i);
                }
                else
                {
                    //adding empty tiles to grid
                    gridB[j][i] = new JButton(emptyP);
                    gridB[j][i].setBorder(BorderFactory.createEmptyBorder());
                    grid.add(gridB[j][i]);
                    gridB[j][i].addActionListener(this);
                    tile[j][i] = new Tile(j,i);
                }
            }
        }

        //Frame
        frame.setContentPane(outerPanel);
        frame.setTitle("Welcome to Cache Noisette!");
        frame.setSize(700,700);
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
            if ( (tile[j][i].getPicture() == emptyP) || (tile[j][i].getPicture() == holeP) || (tile[j][i].getPicture() == holeNutP) )
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
        if ((squirrel[0] != null && button.getIcon() == squirrel[0].getHead()))
        {
            n = 0;
        }
        if ((squirrel[1] != null && button.getIcon() == squirrel[1].getHead()))
        {
            n = 1;
        }
        if ((squirrel[2] != null && button.getIcon() == squirrel[2].getHead()))
        {
            n = 2;
        }
        if ((squirrel[3] != null && button.getIcon() == squirrel[3].getHead()))
        {
            n = 3;
        }
        //what level is selected
        if(button == level1)
        {
            levelOne();
        }
        if(button == level2)
        {
            levelTwo();
        }
        if(button == level3)
        {
            levelThree();
        }


        //UP ARROW pressed
        if(arrowUp == e.getSource())
        {
            //check if out of bounds
            if ((squirrel[n].getY() >= 1) && (squirrel[n].getTailY() >= 1))
            {
                //check if valid movement for L/R facing squirrels
                if ( squirrel[n].getDirection() == 270 || squirrel[n].getDirection() == 90 )
                {
                    //check head and tail allowed to move
                    if ( isItEmpty(squirrel[n].getY() - 1, squirrel[n].getX()) && isItEmpty(squirrel[n].getTailY() - 1, squirrel[n].getTailX()))
                    {
                        //remove squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                        //move squirrel up
                        squirrel[n].move(-1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            System.out.println("Yay a hole is filled.  " + (squirrelNo-holesFilled) + " left to fill.");
                            
                        }
                        //place squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());

                        //test for win
                        ifWin();
                    }
                }
                //facing up squirrels
                else if (squirrel[n].getDirection() == 0)
                {
                    //check if head allowed to move
                    if (isItEmpty(squirrel[n].getY()-1,squirrel[n].getX()))
                    {
                        //remove squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                        //move squirrel up
                        squirrel[n].move(-1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            System.out.println("Yay a hole is filled, " + (squirrelNo-holesFilled) + " left to fill.");

                        }
                        //place squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                        //test for win
                        ifWin();
                    }
                }
            }
        }

        //DOWN ARROW pressed
        if(arrowDown == e.getSource())
        {
            //check down is a valid movement
            if ((squirrel[n].getY() <= 2) && (squirrel[n].getTailY() <= 2))
            {
                //for horizontal squirrels
                if ( squirrel[n].getDirection() == 270 || squirrel[n].getDirection() == 90 )
                {
                    //check head and tail
                    //if ( tile[squirrel[n].getY() + 1][squirrel[n].getX()].isItEmpty() && tile[squirrel[n].getTailY() + 1][squirrel[n].getTailX()].isItEmpty() )
                    if ( isItEmpty(squirrel[n].getY() + 1, squirrel[n].getX()) && isItEmpty(squirrel[n].getTailY() + 1, squirrel[n].getTailX()))
                    {
                        //remove squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                        //move squirrel down
                        squirrel[n].move(1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            System.out.println("Yay a hole is filled " + (squirrelNo-holesFilled) + " left to fill");
                        }
                        //place squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                        //test for win
                        ifWin();
                       
                    }
                }
                //facing down squirrels
                else if (squirrel[n].getDirection() == 180)
                {
                    //check if head moveable
                    if (isItEmpty(squirrel[n].getY()+1,squirrel[n].getX()))
                    {
                        //remove squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                        //move squirrel down
                        squirrel[n].move(1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            System.out.println("Yay a hole is filled,  " + (squirrelNo-holesFilled) + " left to fill!  ");
                            
                        }
                        //place squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                        //test for win
                        ifWin();
                        
                    }
                }
                //for facing up squirrels check only tail
                else if ( (squirrel[n].getDirection() == 0) && (isItEmpty(squirrel[n].getTailY()+1, squirrel[n].getTailX())) )
                {
                    //remove squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                    //move squirrel down
                    squirrel[n].move(1, 0);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        System.out.println("Yay a hole is filled! " + (squirrelNo-holesFilled) + " left to fill! ");
                    }
                    //place squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                    //test for win
                    ifWin();
                   
                }
            }
        }

        //LEFT ARROW pressed
        if(arrowLeft == e.getSource())
        {
            
            //check if left is a valid movement
            if ((squirrel[n].getX() >= 1) && (squirrel[n].getTailX() >= 1))
            {
                //for up and down facing squirrels 
                if ( squirrel[n].getDirection() == 180 || squirrel[n].getDirection() == 0 )
                {
                    //check head and tail moveable
                    if ( (isItEmpty(squirrel[n].getY(), squirrel[n].getX()-1)) && (isItEmpty(squirrel[n].getTailY(), squirrel[n].getTailX()-1)) )
                    {
                        //remove squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                        //move squirrel left
                        squirrel[n].move(0, -1);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            System.out.println("Yay a hole is filled! " + (squirrelNo-holesFilled) + " left to fill ");
                          
                        }
                        //place squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                        //test for win
                        ifWin();
                        
                    }
                }
                //for facing left facing squirrels
                else if (squirrel[n].getDirection() == 270) 
                {
                    //check only head moveable
                    if(isItEmpty(squirrel[n].getY(), squirrel[n].getX()-1))
                    {
                        //remove squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                        //move squirrel left
                        squirrel[n].move(0, -1);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            System.out.println("Yay a hole is filled, " + (squirrelNo-holesFilled) + " left to fill");
                            
                        }
                        //place squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                        //test for win
                        ifWin();
                      
                    }
                }

                //for facing right facing squirrels
                else if (squirrel[n].getDirection() == 90) 
                {
                    //check only tail moveable
                    if(isItEmpty(squirrel[n].getTailY(), squirrel[n].getTailX()-1))
                    {
                        //remove squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                        //move squirrel left
                        squirrel[n].move(0, -1);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            System.out.println("Yay a hole is filled, " + (squirrelNo-holesFilled) + " left to fill! ");
                           
                        }
                        //place squirrel
                        gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                        //test for win
                        ifWin();
                        
                    }
                }
            }  
        }

        //RIGHT ARROW pressed
        if(arrowRight == e.getSource())
        {
            //System.out.println( squirrel[n].getDirection() );
            //check if right is a valid movement
            //facing up and down squirrels
            if (squirrel[n].getDirection() == 0 || squirrel[n].getDirection() == 180)
            {
                //check if head and tail are free to move
                if (isItEmpty(squirrel[n].getY(),squirrel[n].getX() + 1) && isItEmpty(squirrel[n].getTailY(), squirrel[n].getTailX() + 1))
                {
                    //remove squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                    //move squirrel right
                    squirrel[n].move(0, 1);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        System.out.println("Yay a hole is filled! " + (squirrelNo-holesFilled) + " left to fill!  ");
                        
                    }
                    //place squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                    //test for win
                    ifWin();
                    
                }
            }

            //for facing right facing squirrels
            else if (squirrel[n].getDirection() == 90) 
            {
                //check only head moveable
                if(isItEmpty(squirrel[n].getY(), squirrel[n].getX() + 1))
                {
                    //remove squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                    //move squirrel left
                    squirrel[n].move(0, -1);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        System.out.println("Yay a hole is filled. " + (squirrelNo-holesFilled) + " left to fill!");
                       
                    }
                    //place squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());  
                    //test for win
                    ifWin();  
                }
            }

            //for left facing squirrels check if tail free to move
            else if (squirrel[n].getDirection() == 270)
            {
                if ( isItEmpty(squirrel[n].getTailY(), squirrel[n].getTailX() + 1) )
                {
                    //remove squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(tile[squirrel[n].getY()][squirrel[n].getX()].getPicture()); 
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(tile[squirrel[n].getTailY()][squirrel[n].getTailX()].getPicture());
                    //move squirrel right
                    squirrel[n].move(0, 1);
                    //check if a hole is filled
                    if (this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        System.out.println("Yay a hole is filled. " + (squirrelNo-holesFilled) + " left to fill!");
                       
                    }
                    //place squirrel
                    gridB[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    gridB[squirrel[n].getTailY()][squirrel[n].getTailX()].setIcon(squirrel[n].getTail());
                    //test for win
                    ifWin();
                }
            }
        }
    }
}