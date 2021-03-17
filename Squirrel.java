import javax.swing.*;

class Squirrel
{

    private Picture head;
    private Picture tail;
    private int x;
    private int y;
    private int p;
    private int q;
    private int degrees;
    private int nut = 1;
     
    public Picture getHead()
    {
        return head;
    }

    public Picture getTail()
    {
        return tail;
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


    public void move(int y, int x)
    {
        this.y = this.y + y;
        this.x = this.x + x;
        this.q = this.q + y;
        this.p = this.p + x;
    }

    public void dropNut()
    {
        nut = 0;
    }
    
    public Squirrel(int colour, int x, int y, int p, int q, int degrees)
    {
        //head at (x1,y1) tail at (p,q)
        this.x = x;
        this.y = y;
        this.p = p;
        this.q = q;
        this.degrees = degrees;

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
        }
        else if (colour == 3)
        {
            this.head = new Picture("BrownSquirrel1Nut.png", degrees);
            this.tail = new Picture("BrownSquirrel2.png", degrees);
        }
        
        //dropped nut
        if(nut == 0)
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
    }
}