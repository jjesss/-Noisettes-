import javax.swing.*;

class Squirrel
{

    private Picture head;
    private Picture tail;
    private Picture flowers;
    private int x;
    private int y;
    private int p;
    private int q;
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

    public int getP()
    {
        return p;
    }

    public int getQ()
    {
        return q;
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
        this.q = this.q + y;
        this.p = this.p + x;
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
    
    public Squirrel(int colour, int x, int y, int p, int q, int degrees)
    {
        //head at (x1,y1) tail at (p,q)
        this.x = x;
        this.y = y;
        this.p = p;
        this.q = q;
        this.degrees = degrees;
        this.colour = colour;

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
            if (degrees == 0)
            {
                this.flowersX = this.p + 1;
                this.flowersY = this.q;
            }
            else if (degrees == 90)
            {
                this.flowersX = this.p;
                this.flowersY = this.q + 1;
            }
            else if (degrees == 180)
            {
                this.flowersX = this.p - 1;
                this.flowersY = this.q;
            }
            else if (degrees == 270)
            {
                this.flowersX = this.p;
                this.flowersY = this.q - 1;
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