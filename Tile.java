import javax.swing.JButton;

/**
 * This class represents the original images of the Noisettes board and keeps track of what images each grid contains and its coordinates.
 */
public class Tile
{
    private int x;
    private int y;
   
    //pictures
    private Picture holeP = new Picture("Hole.png", 0);
    private Picture emptyP = new Picture("Empty.png", 0);
    private Picture originalPicture;
    private int nutInHole = 0;

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
    
    public int nutInHole()
    {
        return this.nutInHole;
    }
    public void setNutInHole(int n)
    {
        this.nutInHole = n;
    }

    /**
     * Constructor. Creates a new instance of the Tile class based on what y and x its given, which are used for the (x,y) coordinates of the tile.
     */
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
                    this.nutInHole = 0;
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