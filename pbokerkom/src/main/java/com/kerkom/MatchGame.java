package kerkom;

import java.util.Random;

public class MatchGame
{
    static Random randomTiles = new Random();
    public static void main( String[] args )
    {
        int pairs = 2;


        int[][] mapTile = new int[pairs * 2][pairs * 2];

        for(int i = 0; i < mapTile.length; i++)
        {
            for(int j = 0; j < pairs; j++)
            {
                int randomNumber = randomTiles.nextInt(100);
                mapTile[i][j * 2] = randomNumber;
                mapTile[i][j * 2 + 1] = randomNumber;
            }
        }

        for(int i = 0; i < mapTile.length; i++)
        {
            for(int j = 0; j < mapTile[0].length; j++)
            {
                System.out.print(mapTile[i][j] + " ");
            }
        }
        

    }
}
