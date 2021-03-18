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
    private JButton[][] tileB = new JButton[4][4];
    private JButton arrowUp = new JButton(up);
    private JButton arrowLeft = new JButton(left);
    private JButton arrowRight = new JButton(right);
    private JButton arrowDown = new JButton(down);
    private JButton level1 = new JButton("level 1");
    private JButton level2 = new JButton("level 2");

    //squirrel
    private Squirrel[] squirrel = new Squirrel[4];
    //Tile
    private Tile[][] tile 

    private int squirrelNo;
    private int holesFilled = 0;
    private int n;
    private int i;
    private int j;

    //check if theres a hole
    public boolean checkHoles(int y, int x)
    {
        boolean hole = false;

        if(tile[y][x].getIcon() == holeP)
        {
            hole = true;
        }

        return hole;
    }    
    //holes filled plus one
    public void aHoleFilled(int j, int i, int n)
    {
        holesFilled += 1;
        picture[j][i] = holeNutP;
        squirrel[n].dropNut();
        //test if won
        win();
    }

    //win when all nuts are in the holes
    public void win()
    {
        if( holesFilled == squirrelNo )
        {
            System.out.println(" SUCCESS! ALL THE NUTS ARE IN THE HOLES :) ");
            /*try
            {
                Thread.sleep(1000);
            }catch(Exception e)
            {
                System.out.println(e);
            }
            frame.dispose();*/
        }
    }
    //level one
    public void levelOne()
    {
        resetBoard();
        squirrelNo = 2;
        //red squirrel
        squirrel[0] = new Squirrel(0,1,1,2,1,270);
        //grey squirrel
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
    }
    //level 2
    public void levelTwo()
    {
        resetBoard();
        squirrelNo = 2;
        //black squirrel
        squirrel[0] = new Squirrel(2, 3,2,3,1, 180);
        //brown squirrel
        squirrel[1] = new Squirrel(3, 0,2,0,3, 0);

        //place grey squirrel
        tile[squirrel[0].getY()][squirrel[0].getX()].setIcon(squirrel[0].getHead()); 
        tile[squirrel[0].getQ()][squirrel[0].getP()].setIcon(squirrel[0].getTail());
        tile[squirrel[0].getFlowersY()][squirrel[0].getFlowersX()].setIcon(squirrel[0].getFlowers());
        //place brown squirrel
        tile[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        tile[squirrel[1].getQ()][squirrel[1].getP()].setIcon(squirrel[1].getTail());
        tile[squirrel[1].getFlowersY()][squirrel[1].getFlowersX()].setIcon(squirrel[1].getFlowers());
        //place flower
        tile[3][3].setIcon(flowerP);
    }
    //level 3
    public void levelThree()
    {
        resetBoard();
        squirrelNo = 3;
        //black squirrel
        squirrel[0] = new Squirrel(2, 2,2,1,2, 90);
        //red squirrel
        squirrel[1] = new Squirrel(0, 3,0,2,0, 90);
        //brown squirrel
        squirrel[2] = new Squirrel(3, 3,1,2,1, 90);
        //grey squirrel
        squirrel[3] = new Squirrel(2, 3, 2, 3, 1, 180);

        //place black squirrel
        tile[squirrel[0].getY()][squirrel[0].getX()].setIcon(squirrel[0].getHead()); 
        tile[squirrel[0].getQ()][squirrel[0].getP()].setIcon(squirrel[0].getTail());
        tile[squirrel[0].getFlowersY()][squirrel[0].getFlowersX()].setIcon(squirrel[0].getFlowers());
        //place red squirrel
        tile[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        tile[squirrel[1].getQ()][squirrel[1].getP()].setIcon(squirrel[1].getTail());
        //place brown squirrel
        tile[squirrel[2].getY()][squirrel[2].getX()].setIcon(squirrel[2].getHead()); 
        tile[squirrel[2].getQ()][squirrel[2].getP()].setIcon(squirrel[2].getTail());
        tile[squirrel[2].getFlowersY()][squirrel[2].getFlowersX()].setIcon(squirrel[2].getFlowers());
        //place grey squirres
        tile[squirrel[1].getY()][squirrel[1].getX()].setIcon(squirrel[1].getHead()); 
        tile[squirrel[1].getQ()][squirrel[1].getP()].setIcon(squirrel[1].getTail());


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
                    //picture array has holes
                    picture[j][i] = holeP;
                    tile[j][i].setIcon(holeP);       
                }
                else
                {
                    //picture array has empty picture  
                    picture[j][i] = emptyP;
                    tile[j][i].setIcon(emptyP);
                }
            }
        }
        holesFilled = 0;
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
        if ((squirrel[0] != null && button.getIcon() == squirrel[0].getHead()))
        {
            n = 0;
        }
        if ((squirrel[1] != null && button.getIcon() == squirrel[1].getHead()))
        {
            n = 1;
            
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


        //UP ARROW pressed
        if(arrowUp == e.getSource())
        {
            //check if out of bounds
            if ((squirrel[n].getY() >= 1) && (squirrel[n].getQ() >= 1) && (squirrel[n].getFlowersY() >= 1))
            {
                //check if valid movement for L/R facing squirrels
                if ( squirrel[n].getDirection() == 270 || squirrel[n].getDirection() == 90 )
                {
                    //check head and tail allowed to move
                    if ( isItEmpty(squirrel[n].getY() - 1, squirrel[n].getX()) && isItEmpty(squirrel[n].getQ() - 1, squirrel[n].getP()))
                    {
                        //remove squirrel
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]);
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                        //move squirrel up
                        squirrel[n].move(-1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        }
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
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]);
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                        //move squirrel up
                        squirrel[n].move(-1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        }
                        //place squirrel
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
                    }
                }
                //for facing down squirrels check if tail allowed to move
                else if ( (squirrel[n].getDirection() == 180) && (isItEmpty(squirrel[n].getQ()-1, squirrel[n].getP())) )
                {
                    //remove squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]);
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                    //move squirrel up
                    squirrel[n].move(-1, 0);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                    
                    }
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
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                        //move squirrel down
                        squirrel[n].move(1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            
                        }
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
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                        //move squirrel down
                        squirrel[n].move(1, 0);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            
                        }
                        //place squirrel
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
                        
                    }
                }
                //for facing up squirrels check only tail
                else if ( (squirrel[n].getDirection() == 0) && (isItEmpty(squirrel[n].getQ()+1, squirrel[n].getP())) )
                {
                    //remove squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                    //move squirrel down
                    squirrel[n].move(1, 0);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        
                    }
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
                    if ( (isItEmpty(squirrel[n].getY(), squirrel[n].getX()-1)) && (isItEmpty(squirrel[n].getQ(), squirrel[n].getP()-1)) )
                    {
                        //remove squirrel
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                        //move squirrel left
                        squirrel[n].move(0, -1);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                          
                        }
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
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                        //move squirrel left
                        squirrel[n].move(0, -1);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                            
                        }
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
                        tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                        tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                        //move squirrel left
                        squirrel[n].move(0, -1);
                        //check if a hole is filled
                        if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                        {
                            this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                           
                        }
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
            //System.out.println( squirrel[n].getDirection() );
            //check if right is a valid movement
            //facing up and down squirrels
            if (squirrel[n].getDirection() == 0 || squirrel[n].getDirection() == 180)
            {
                //check if head and tail are free to move
                if (isItEmpty(squirrel[n].getY(),squirrel[n].getX() + 1) && isItEmpty(squirrel[n].getQ(), squirrel[n].getP() + 1))
                {
                    //remove squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                    //move squirrel right
                    squirrel[n].move(0, 1);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                        
                    }
                    //place squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
                    
                }
            }

            //for facing right facing squirrels
            else if (squirrel[n].getDirection() == 90) 
            {
                //check only head moveable
                if(isItEmpty(squirrel[n].getY(), squirrel[n].getX() + 1))
                {
                    //remove squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                    //move squirrel left
                    squirrel[n].move(0, -1);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                       
                    }
                    //place squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());    
                }
            }

            //for left facing squirrels check if tail free to move
            else if (squirrel[n].getDirection() == 270)
            {
                if ( isItEmpty(squirrel[n].getQ(), squirrel[n].getP() + 1) )
                {
                    //remove squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(picture[squirrel[n].getY()][squirrel[n].getX()]); 
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(picture[squirrel[n].getQ()][squirrel[n].getP()]);
                    //move squirrel right
                    squirrel[n].move(0, 1);
                    //check if a hole is filled
                    if(this.checkHoles(squirrel[n].getY(), squirrel[n].getX()))
                    {
                        this.aHoleFilled(squirrel[n].getY(), squirrel[n].getX(), n);
                       
                    }
                    //place squirrel
                    tile[squirrel[n].getY()][squirrel[n].getX()].setIcon(squirrel[n].getHead());
                    tile[squirrel[n].getQ()][squirrel[n].getP()].setIcon(squirrel[n].getTail());
                }
            }
        }
    }
}