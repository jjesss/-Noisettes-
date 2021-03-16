import javax.swing.*;

class Squirrels
{
    //squirrel pictures
    private Picture red1 = new Picture("RedSquirrel1Nut.png", 270);
    private Picture red2 = new Picture("RedSquirrel2.png", 270);
    private Picture grey1 = new Picture("GreySquirrel1Nut.png", 0);
    private Picture grey2 = new Picture("GreySquirrel2.png", 0);
    //without nuts
    private Picture grey1nutless = new Picture("GreySquirrel1.png", 0);
    private Picture red1nutless = new Picture("RedSquirrel1.png", 0);

    private Picture head;
    private Picture tail;

    public Picture getRed1()
    {
        return red1;
    }

    public Picture getRed2()
    {
        return red2;
    }

    public Picture getGrey1()
    {
        return grey1;
    }

    public Picture getGrey2()
    {
        return grey2;
    }
    
    public Picture getHead()
    {
        return head;

    }

    public Picture getTail()
    {
        return tail;

    }


    
    public Squirrels(int colour)
    {
        //0 = red
        if (colour == 0)
        {
            this.head = new Picture("RedSquirrel1Nut.png", 270);
            this.tail = new Picture("RedSquirrel2.png", 270);
        }



        
    }
    

}