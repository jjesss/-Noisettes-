import javax.swing.JButton;

/** tile class that creates a tile which is on a certain coordinate of x and y and holds a picture*/
public class Tile
{
    private int x;
    private int y;
   
    //pictures
    private Picture holeP = new Picture("Hole.png", 0);
    private Picture emptyP = new Picture("Empty.png", 0);
    private Picture originalPicture;

    public int getTailX()
    {
        return this.x;
    }

    public int getTailY()
    {
        return this.y;
    }

    public void setPicture( Picture picture)
    {
        this.originalPicture = picture;
    }

    public Picture getPicture()
    {
        return this.originalPicture;
    }

    //tile constructor
    public Tile(int y, int x)
    {
        this.x = x;
        this.y = y;

        //pictures for the tile
        for (this.y = 0; this.y < 4; this.y++) 
        {
            for (this.x = 0; this.x < 4; this.x++) 
            {
                if ((this.y == 0 && this.x == 2) || (this.y == 1 && this.x == 0) || (this.y== 2 && this.x == 1) || (this.y == 3 && this.x == 3))
                {
                    //holes for these tiles
                    this.originalPicture = holeP;
                }
                else
                {
                    //empty pictures for these tiles
                    this.originalPicture= emptyP;
                }
            }
        }
    }
}