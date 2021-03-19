/** This is the board of the game. It has buttons for level selection and also a grid of buttons called gridB which contain tiles. For the pieces I set the icon of the gridBs to the picture of the piecse*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class represents a graphical window containing the game board. Once an instance of this is created, it can
 * be used to create boards, containging three different level buttons and a grid of buttons with pictures.
 */
class NoisettesBoard implements ActionListener
{
    /**
     * These are instances of variables and classes
     */
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
    private int selected;
    private int i;
    private int j;


    /**
     * Methods used to help do things like set the level of the Noisettes Board
     * 
     */
    //method to check if next spot squirrel is moving to is empty
    public boolean isItEmpty(int j, int i)
    {
        boolean empty = false;
        //check its moving to an empty tile
        if ( (gridB[j][i].getIcon() == emptyP) || (gridB[j][i].getIcon() == holeP) || (gridB[j][i].getIcon() == holeNutP) )
        {
            empty = true;       
        }
        else
        {
            empty = false;
        }

        return empty;
    }

    //check if theres a hole
    public boolean checkHoles(int y, int x)
    {
        boolean hole = false;

        if(tile[y][x].getPicture() == holeP && tile[y][x].nutInHole() == 0 && squirrel[selected].nut())
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
        tile[j][i].setNutInHole(1);
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
                    tile[j][i].setNutInHole(0);
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
        System.out.println("level 1");
        squirrelNo = 2;
        //red squirrel
        squirrel[0] = new Squirrel(0,1,1,270);
        //grey squirrel
        squirrel[1] = new Squirrel(1,2,2,0);
        
        //JButton squirrelTile = new JButton(squirrels[n].getHead)
        //place red squirrel
        gridB[squirrel[0].getY()][squirrel[0].getX()].setIcon(squirrel[0].getHead()); 
        gridB[squirrel[0].getTailY()][squirrel[0].getTailX()].setIcon(squirrel[0].getTail());
        squirrel[0].setNutNo(1);
        //place grey squirrel
        gridB[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        gridB[squirrel[1].getTailY()][squirrel[1].getTailX()].setIcon(squirrel[1].getTail()); 
        squirrel[1].setNutNo(1);
        //place flower
        gridB[2][1].setIcon(flowerP);
    }
    //load level 2
    public void levelTwo()
    {
        resetBoard();
        System.out.println("level 2");
        squirrelNo = 2;
        //black squirrel
        squirrel[0] = new Squirrel(2, 3,2, 180);
        squirrel[0].setNutNo(1);
        //brown squirrel
        squirrel[1] = new Squirrel(3, 0,2, 0);
        squirrel[1].setNutNo(1);

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
        System.out.println("level 3");
        squirrelNo = 4;
        //black squirrel
        squirrel[0] = new Squirrel(2, 2,1, 180);
        squirrel[0].setNutNo(1);
        //red squirrel
        squirrel[1] = new Squirrel(0, 0,2, 270);
        squirrel[1].setNutNo(1);
        //brown squirrel
        squirrel[2] = new Squirrel(3, 2,3, 180);
        squirrel[2].setNutNo(1);
        //grey squirrel
        squirrel[3] = new Squirrel(1, 3,2, 180);
        squirrel[3].setNutNo(1);

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
        gridB[squirrel[3].getY()][squirrel[3].getX()].setIcon(squirrel[3].getHead()); 
        gridB[squirrel[3].getTailY()][squirrel[3].getTailX()].setIcon(squirrel[3].getTail());
    }

    public void moveUp()
    {
        //remove squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(tile[squirrel[selected].getY()][squirrel[selected].getX()].getPicture());
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(tile[squirrel[selected].getTailY()][squirrel[selected].getTailX()].getPicture());
        if (squirrel[selected].getFlowers() != null)
        {
            //remove flower
            gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(tile[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].getPicture());
        }
        //move squirrel up
        squirrel[selected].move(-1, 0);
        //check if a hole is filled
        if(this.checkHoles(squirrel[selected].getY(), squirrel[selected].getX()))
        {
            this.aHoleFilled(squirrel[selected].getY(), squirrel[selected].getX(), selected);
            System.out.println("Yay a hole is filled.  " + (squirrelNo-holesFilled) + " left to fill.");
            
        }
        //place squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(squirrel[selected].getHead());
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(squirrel[selected].getTail());
        if (squirrel[selected].getFlowers() != null)
        {
            gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(squirrel[selected].getFlowers());
        }
        //test for win
        ifWin();
    }

    public void moveDown()
    {
        //remove squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(tile[squirrel[selected].getY()][squirrel[selected].getX()].getPicture()); 
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(tile[squirrel[selected].getTailY()][squirrel[selected].getTailX()].getPicture());
        if (squirrel[selected].getFlowers() != null)
        {
            //remove any flowers attached
            gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(tile[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].getPicture());
        }
        //move squirrel down
        squirrel[selected].move(1, 0);
        //check if a hole is filled
        if(this.checkHoles(squirrel[selected].getY(), squirrel[selected].getX()))
        {
            this.aHoleFilled(squirrel[selected].getY(), squirrel[selected].getX(), selected);
            System.out.println("Yay a hole is filled " + (squirrelNo-holesFilled) + " left to fill");
        }
        //place squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(squirrel[selected].getHead());
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(squirrel[selected].getTail());
        if (squirrel[selected].getFlowers() != null)
        {
            //place flower
            gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(squirrel[selected].getFlowers());
        }
        //test for win
        ifWin();
    }
    
    public void moveLeft()
    {
        //remove squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(tile[squirrel[selected].getY()][squirrel[selected].getX()].getPicture()); 
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(tile[squirrel[selected].getTailY()][squirrel[selected].getTailX()].getPicture());
        if (squirrel[selected].getFlowers() != null)
        {
            //remove any flowers attached
            gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(tile[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].getPicture());
        }
        //move squirrel left
        squirrel[selected].move(0, -1);
        //check if a hole is filled
        if(this.checkHoles(squirrel[selected].getY(), squirrel[selected].getX()))
        {
            this.aHoleFilled(squirrel[selected].getY(), squirrel[selected].getX(), selected);
            System.out.println("Yay a hole is filled! " + (squirrelNo-holesFilled) + " left to fill ");
          
        }
        //place squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(squirrel[selected].getHead());
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(squirrel[selected].getTail());
        if (squirrel[selected].getFlowers() != null)
        {
            //place flower
            gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(squirrel[selected].getFlowers());
        }
        //test for win
        ifWin();
    }

    public void moveRight()
    {
        //remove squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(tile[squirrel[selected].getY()][squirrel[selected].getX()].getPicture()); 
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(tile[squirrel[selected].getTailY()][squirrel[selected].getTailX()].getPicture());
        gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(tile[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].getPicture());
        //move squirrel right
        squirrel[selected].move(0, 1);
        //check if a hole is filled
        if(this.checkHoles(squirrel[selected].getY(), squirrel[selected].getX()))
        {
            this.aHoleFilled(squirrel[selected].getY(), squirrel[selected].getX(), selected);
            System.out.println("Yay a hole is filled! " + (squirrelNo-holesFilled) + " left to fill!  ");
            
        }
        //place squirrel
        gridB[squirrel[selected].getY()][squirrel[selected].getX()].setIcon(squirrel[selected].getHead());
        gridB[squirrel[selected].getTailY()][squirrel[selected].getTailX()].setIcon(squirrel[selected].getTail());
        if (squirrel[selected].getFlowers() != null)
        {
            //place flower
            gridB[squirrel[selected].getFlowersY()][squirrel[selected].getFlowersX()].setIcon(squirrel[selected].getFlowers());
        }
        //test for win
        ifWin();
    }

    /**
     * Constructor. Creates a new instance of the NoisettesBoard class.
     * 
     */
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

    /**
     * Action listener to see when a JButton has been pressed and determines what to do when that specific button has been pressed.
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton button = (JButton)e.getSource();
        //what squirrel selected
        if ((squirrel[0] != null && button.getIcon() == squirrel[0].getHead()))
        {
            selected = 0;
        }
        if ((squirrel[1] != null && button.getIcon() == squirrel[1].getHead()))
        {
            selected = 1;
        }
        if ((squirrel[2] != null && button.getIcon() == squirrel[2].getHead()))
        {
            selected = 2;
        }
        if ((squirrel[3] != null && button.getIcon() == squirrel[3].getHead()))
        {
            selected = 3;
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
            if (((squirrel[selected].getY() >= 1) && (squirrel[selected].getTailY() >= 1)) && (squirrel[selected].upMoveable()))
            {
                //check for brown and black squirrel's flowers collision
                if (squirrel[selected].colour() == 2 || squirrel[selected].colour() == 3 )
                {
                    //check if the location its moving to is empty
                    if(isItEmpty(squirrel[selected].getFlowersY()-1, squirrel[selected].getFlowersX()))
                    {
                        //check if valid movement for L/R facing squirrels
                        if ( squirrel[selected].getDirection() == 270)
                        {
                            //if black
                            if (squirrel[selected].colour() == 2)
                            {
                                //only check head allowed to move
                                if(isItEmpty(squirrel[selected].getY() - 1, squirrel[selected].getX()))
                                {
                                    this.moveUp();
                                }
                            }
                            //if brown
                            if (squirrel[selected].colour() == 3)
                            {
                                //check tail allowed to move
                                if ( isItEmpty(squirrel[selected].getTailY()-1, squirrel[selected].getTailX()) )
                                {
                                    this.moveUp();
                                }
                            }
                        }
                        //facing up squirrels
                        else if (squirrel[selected].getDirection() == 0)
                        {
                            //check if head allowed to move
                            if (isItEmpty(squirrel[selected].getY()-1,squirrel[selected].getX()))
                            {
                                this.moveUp();
                            }
                        }
                        //for facing down squirrels check if tail allowed to move
                        else if ( (squirrel[selected].getDirection() == 180) && (isItEmpty(squirrel[selected].getTailY()-1, squirrel[selected].getTailX())) )
                        {
                            this.moveUp();
                        }
                        //if brown or black squirrel facing right
                        else if(squirrel[selected].getDirection() == 90 )
                        {
                            //check both head and tails wont collide
                            if(isItEmpty(squirrel[selected].getY() - 1, squirrel[selected].getX()) && isItEmpty(squirrel[selected].getTailY()-1, squirrel[selected].getTailX()))
                            {
                                this.moveUp();
                            }
                        }
                    }
                }
                else if(squirrel[selected].colour() == 0 || squirrel[selected].colour() == 1 )
                {
                    //check if valid movement for L/R facing squirrels
                    if ( squirrel[selected].getDirection() == 270 || squirrel[selected].getDirection() == 90 )
                    {
                        //check head and tail allowed to move
                        if ( isItEmpty(squirrel[selected].getY() - 1, squirrel[selected].getX()) && isItEmpty(squirrel[selected].getTailY()-1, squirrel[selected].getTailX()) )
                        {
                            this.moveUp();
                        }
                    }
                    //facing up squirrels
                    else if (squirrel[selected].getDirection() == 0)
                    {
                        //check if head allowed to move
                        if (isItEmpty(squirrel[selected].getY()-1,squirrel[selected].getX()))
                        {
                            this.moveUp();
                        }
                    }
                    //for facing down squirrels check if tail allowed to move
                    else if ( (squirrel[selected].getDirection() == 180) && (isItEmpty(squirrel[selected].getTailY()-1, squirrel[selected].getTailX())) )
                    {
                        this.moveUp();
                    }
                }
            }
        }

        //DOWN ARROW pressed
        if(arrowDown == e.getSource())
        {
            //check down is a valid movement
            if (((squirrel[selected].getY() <= 2) && (squirrel[selected].getTailY() <= 2)) && (squirrel[selected].downMoveable()))
            {
                //check for brown and black squirrel's flowers collision
                if (squirrel[selected].colour() == 2 || squirrel[selected].colour() == 3 )
                {
                    //check if the location flower is moving to is empty
                    if(isItEmpty(squirrel[selected].getFlowersY()+1, squirrel[selected].getFlowersX()))
                    {
                        //if right facing
                        if(squirrel[selected].getDirection() == 90)
                        {
                            //if black
                            if (squirrel[selected].colour() == 2)
                            {
                                //only check head allowed to move
                                if(isItEmpty(squirrel[selected].getY() + 1, squirrel[selected].getX()))
                                {
                                    this.moveDown();
                                }
                            }
                            //if brown
                            if (squirrel[selected].colour() == 3)
                            {
                                //check tail allowed to move
                                if ( isItEmpty(squirrel[selected].getTailY()+1, squirrel[selected].getTailX()) )
                                {
                                    this.moveDown();
                                }
                            }
                        }
                        //facing down squirrels
                        else if (squirrel[selected].getDirection() == 180)
                        {
                            //check if head moveable
                            if (isItEmpty(squirrel[selected].getY()+1,squirrel[selected].getX()))
                            {
                                this.moveDown();
                            }
                        }
                        //for facing up squirrels check only tail
                        else if ( (squirrel[selected].getDirection() == 0) && (isItEmpty(squirrel[selected].getTailY()+1, squirrel[selected].getTailX())) )
                        {
                            this.moveDown(); 
                        }
                        //if brown or black squirrel facing left
                        else if(squirrel[selected].getDirection() == 270 )
                        {
                            //check both head and tails wont collide
                            if (isItEmpty(squirrel[selected].getY() + 1, squirrel[selected].getX()) && isItEmpty(squirrel[selected].getTailY() + 1, squirrel[selected].getTailX()))
                            {
                                this.moveDown();
                            }
                        }
                    }
                }
                //for red and grey squirrels
                else if(squirrel[selected].colour() == 0 || squirrel[selected].colour() == 1 )
                {
                    //for horizontal squirrels
                    if ( squirrel[selected].getDirection() == 270 || squirrel[selected].getDirection() == 90 )
                    {
                        //check head and tail
                        if ( isItEmpty(squirrel[selected].getY() + 1, squirrel[selected].getX()) && isItEmpty(squirrel[selected].getTailY() + 1, squirrel[selected].getTailX()))
                        {
                            this.moveDown();
                        }
                    }
                    //facing down squirrels
                    else if (squirrel[selected].getDirection() == 180)
                    {
                        //check if head moveable
                        if (isItEmpty(squirrel[selected].getY()+1,squirrel[selected].getX()))
                        {
                            this.moveDown();
                        }
                    }
                    //for facing up squirrels check only tail
                    else if ( (squirrel[selected].getDirection() == 0) && (isItEmpty(squirrel[selected].getTailY()+1, squirrel[selected].getTailX())) )
                    {
                        this.moveDown(); 
                    }
                }
            }
        }

        //LEFT ARROW pressed
        if(arrowLeft == e.getSource())
        {
            
            //check if left is a valid movement/not out of bounds
            if (((squirrel[selected].getX() >= 1) && (squirrel[selected].getTailX() >= 1))  && (squirrel[selected].leftMoveable()))
            {
                //check for brown and black squirrel's flowers collision
                if (squirrel[selected].colour() == 2 || squirrel[selected].colour() == 3 )
                {
                    //check if the location its moving to is empty
                    if(isItEmpty(squirrel[selected].getFlowersY(), squirrel[selected].getFlowersX()-1))
                    {
                        //for down facing squirrels 
                        if ( squirrel[selected].getDirection() == 180)
                        {
                            //if black
                            if(squirrel[selected].colour() == 2)
                            {
                                //only check head
                                if ( isItEmpty(squirrel[selected].getY(), squirrel[selected].getX()-1) )
                                {
                                    this.moveLeft();
                                }
                            }
                            //if brown
                            if(squirrel[selected].colour() == 3)
                            {
                                //only check tail 
                                if ( isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX()-1) )
                                {
                                    this.moveLeft();
                                }
                            }
                        }
                        //for facing left facing squirrels
                        else if (squirrel[selected].getDirection() == 270) 
                        {
                            //check only head moveable
                            if(isItEmpty(squirrel[selected].getY(), squirrel[selected].getX()-1))
                            {
                                this.moveLeft();
                            }
                        }
                        //for facing right facing squirrels
                        else if (squirrel[selected].getDirection() == 90) 
                        {
                            //only check tail
                            if ( isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX()-1) )
                            {
                                this.moveLeft();
                            }
                        }
                    }
                    //if brown/black squirrel facing up
                    else if(squirrel[selected].getDirection() == 0 )
                    {
                        //check both head and tails wont collide
                        if ((isItEmpty(squirrel[selected].getY(), squirrel[selected].getX()-1)) && (isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX()-1)))
                        {
                            this.moveLeft();
                        }
                    }
                }
                else if(squirrel[selected].colour() == 0 || squirrel[selected].colour() == 1 )
                {
                    //for up and down facing squirrels 
                    if ( squirrel[selected].getDirection() == 180 || squirrel[selected].getDirection() == 0 )
                    {
                        //check head and tail moveable
                        if ( (isItEmpty(squirrel[selected].getY(), squirrel[selected].getX()-1)) && (isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX()-1)) )
                        {
                            this.moveLeft();
                        }
                    }
                    //for facing left facing squirrels
                    else if (squirrel[selected].getDirection() == 270) 
                    {
                        //check only head moveable
                        if (isItEmpty(squirrel[selected].getY(), squirrel[selected].getX()-1))
                        {
                            this.moveLeft();
                        }
                    }
                    //for facing right facing squirrels
                    else if (squirrel[selected].getDirection() == 90) 
                    {
                        //check only tail moveable
                        if(isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX()-1))
                        {
                            this.moveLeft();
                        }
                    }
                }
            }  
        }

        //RIGHT ARROW pressed
        if(arrowRight == e.getSource())
        {
            //check if right is a valid movement
            if ((squirrel[selected].getX() <= 2) && (squirrel[selected].getTailX() <= 2) && (squirrel[selected].rightMoveable()))
            {
                //check for brown and black squirrel's flowers collision
                if (squirrel[selected].colour() == 2 || squirrel[selected].colour() == 3 )
                {
                    //check if the location its moving to is empty
                    if(isItEmpty(squirrel[selected].getFlowersY(), squirrel[selected].getFlowersX()+1))
                    {
                        //facing up and down squirrels
                        if (squirrel[selected].getDirection() == 0)
                        {
                            //if black
                            if(squirrel[selected].colour() == 2)
                            {
                                //only check head
                                if ( isItEmpty(squirrel[selected].getY(), squirrel[selected].getX()+1) )
                                {
                                    this.moveRight();
                                }
                            }
                            //if brown
                            if(squirrel[selected].colour() == 3)
                            {
                                //only check tail 
                                if ( isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX()+1) )
                                {
                                    this.moveRight();
                                }
                            }
                        }
                        //for facing right facing squirrels
                        else if (squirrel[selected].getDirection() == 90) 
                        {
                            //check only head moveable
                            if(isItEmpty(squirrel[selected].getY(), squirrel[selected].getX() + 1))
                            {
                                this.moveRight();
                            }
                        }
                        //for left facing squirrels check if tail free to move
                        else if (squirrel[selected].getDirection() == 270)
                        {
                            //check tail
                            if(isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX() + 1) )
                            {
                                this.moveRight();
                            }
                        }
                    }
                    //if squirrel facing up
                    else if(squirrel[selected].getDirection() == 180 )
                    {
                        //check both head and tails wont collide
                        if ((isItEmpty(squirrel[selected].getY(), squirrel[selected].getX()+1)) && (isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX()+1)))
                        {
                            this.moveRight();
                        }
                    }
                }
                else if(squirrel[selected].colour() == 0 || squirrel[selected].colour() == 1 )
                {
                    //facing up and down squirrels
                    if (((squirrel[selected].getDirection() == 0 || squirrel[selected].getDirection() == 180)))
                    {
                        //check if head and tail are free to move
                        if (isItEmpty(squirrel[selected].getY(),squirrel[selected].getX() + 1) && isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX() + 1))
                        {
                            this.moveRight(); 
                        }
                    }
                    //for facing right facing squirrels
                    else if (squirrel[selected].getDirection() == 90) 
                    {
                        //check only head moveable
                        if(isItEmpty(squirrel[selected].getY(), squirrel[selected].getX() + 1))
                        {
                            moveRight();
                        }
                    }
                    //for left facing squirrels check if tail free to move
                    else if (squirrel[selected].getDirection() == 270)
                    {
                        if (isItEmpty(squirrel[selected].getTailY(), squirrel[selected].getTailX() + 1) )
                        {
                            moveRight();
                        }
                    }
                }
            }
        }
    }
}