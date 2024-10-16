package Core;

import java.util.Scanner;

/***
 * Player class hold all player information such player name, player tag and displaying of  information.
 */
public class players {
    protected String name;
    protected String playerTag;


    private  String value;
    private int Column;
    private String PlayermoveValue;



    /***
     * Responsible for constructing an object for each player of the game.
     * @param name - take in and store  name and of ech individual player.
     * @param playerTag - take in and store  random  9 Digit Alphanumeric number(includes special characters) game tah being generated.
     */
    public players(String name, String playerTag, String Playermovevalue1) {
        this.name = name;
        this.playerTag = playerTag;
        this.value = " ";
        this.Column = 1;
        this.PlayermoveValue = Playermovevalue1;


    }


    /***
     *
     * @return get player name.
     */
    public String getName() {
        return name;
    }

    /****
     *
     * @return get player tag.
     */
    public String getPlayerTag() {
        return playerTag;
    }


    /***
     * display  player information.
     */
    public void displayUserInfo(){

      System.out.println(" Name: " + name + " Player Tag : " + playerTag);

    }

    /***
     *
     * @return - return the right value the player should play.
     */
    public String getPlayermoveValue() {
        return PlayermoveValue;
    }





    /***
     *
     * @return return value.
     */
    public String getValue() {
        return value;
    }

    /***
     *
     * @param value  set value.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /***
     *
     * @return return column.
     */
    public int getColumn() {
        return Column;
    }


    /***
     *
     * @param column set column.
     */
    public void setColumn(int column) {
        Column = column;
    }



}
