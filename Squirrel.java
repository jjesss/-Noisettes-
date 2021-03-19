import javax.swing.*;

public class Squirrel
{

    private Picture head;
    private Picture tail;
    private Picture flowers;
    private int x;
    private int y;
    private int tailX;
    private int tailY;
    private int flowersX;
    private int flowersY;
    private int colour;
    private int degrees;
     
    public Picture getHead()
    {
        return head;
    }

    public Picture getTail()
    {
        return tail;
    }

    public Picture getFlowers()
    {
        return flowers;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getTailX()
    {
        return tailX;
    }

    public int getTailY()
    {
        return tailY;
    }

    public int getDirection()
    {
        return this.degrees;
    }

    public int getFlowersX()
    {
        return this.flowersX;
    }

    public int getFlowersY()
    {
        return this.flowersY;
    }


    public void move(int y, int x)
    {
        this.y = this.y + y;
        this.x = this.x + x;
        this.tailY = this.tailY + y;
        this.tailX = this.tailX + x;
        this.flowersY = this.flowersY + y;
        this.flowersX = this.flowersX + x;
    }

    public void dropNut()
    {
        if (colour == 0)
        {
            this.head = new Picture("RedSquirrel1.png", degrees);
        }
        else if (colour == 1)
        {
            this.head = new Picture("GreySquirrel1.png", degrees);
        }
        else if (colour == 2)
        {
            this.head = new Picture("BlackSquirrel1.png", degrees);
        }
        else if (colour == 3)
        {
            this.head = new Picture("BrownSquirrel1.png", degrees);
        }
    }
    
    public Squirrel(int colour, int x, int y, int degrees)
    {
        //head at (x1,y1) tail at (p,q)
        this.x = x;
        this.y = y;
        this.degrees = degrees;
        this.colour = colour;

        if(this.degrees == 0)
        {
            this.tailX = x;
            this.tailY = y + 1;
        }
        else if(this.degrees == 90)
        {
            this.tailX = x - 1;
            this.tailY = y;
        }
        else if(this.degrees == 180)
        {
            this.tailX = x;
            this.tailY = y - 1;
        }
        else if(this.degrees == 270)
        {
            this.tailX = x + 1;
            this.tailY = y;
        }

        //0 = red, 1 = grey, 2 = black, 3 = brown
        if (colour == 0)
        {
            this.head = new Picture("RedSquirrel1Nut.png", degrees);
            this.tail = new Picture("RedSquirrel2.png", degrees);
        }
        else if (colour == 1)
        {
            this.head = new Picture("GreySquirrel1Nut.png", degrees);
            this.tail = new Picture("GreySquirrel2.png", degrees);
        }
        else if (colour == 2)
        {
            this.head = new Picture("BlackSquirrel1Nut.png", degrees);
            this.tail = new Picture("BlackSquirrel2.png", degrees);
            this.flowers = new Picture( "SquirrelFlower.png",degrees);
            if(degrees == 0)
            {
                this.flowersX = this.tailX + 1;
                this.flowersY = this.tailY;
            }
            else if (degrees == 90)
            {
                this.flowersX = this.tailX;
                this.flowersY = this.tailY + 1;
            }
            else if (degrees == 180)
            {
                this.flowersX = this.tailX - 1;
                this.flowersY = this.tailY;
            }
            else if (degrees == 270)
            {
                this.flowersX = this.tailX;
                this.flowersY = this.tailY - 1;
            }
        }
        else if (colour == 3)
        {
            this.head = new Picture("BrownSquirrel1Nut.png", degrees);
            this.tail = new Picture("BrownSquirrel2.png", degrees);
            this.flowers = new Picture( "SquirrelFlower.png",degrees);
            if (degrees == 0)
            {
                this.flowersX = this.x + 1;
                this.flowersY = this.y;
            }
            else if (degrees == 90)
            {
                this.flowersX = this.x;
                this.flowersY = this.y + 1;
            }
            else if (degrees == 180)
            {
                this.flowersX = this.x - 1;
                this.flowersY = this.y;
            }
            else if (degrees == 270)
            {
                this.flowersX = this.x;
                this.flowersY = this.y - 1;
            }
        }
        
    }
}