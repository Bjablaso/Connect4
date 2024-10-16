package Core;



/***
 * Create a 6-by-7 game board in which players can play a console Connect 4 game. Set the initial value of the game board to a blank sting.
 * Inset value into the board according to the column selected by each player based on where they would like to play.
 */
public abstract class Connect4Logic {
    //number of rows
     private final int rows = 6;
     //number of columns
     private final int column = 7;
     //2D Array
     private final String [][] connect4;
     private int move;
      private final String Blanck;
      private int counter;


    private final String player1play;
    private final String player2play;
    private  int wincondition;


    /***
     * Responsible for constructing your Connect 4 game board by creating a 6 by 7 2D array. Set all values in the array to a blank string.
     */
    protected Connect4Logic() {
         connect4 = new String[rows][column];
        this.Blanck = " ";
        this.counter = rows -1;
        this.move = 1;
        this.player1play = "X";
        this.player2play = "O";
        this.wincondition = 3;


         for (int i = 0; i < rows ; i++) {
             for (int j = 0; j < column; j++) {
                 if (null == connect4[i][j]) {
                     connect4[i][j] = Blanck;
                 }
             }
         }

     }

    /***
     * Responsible for inserting items into the game board.
     * @param positon -  Column position in which you want to insert an element.
     * @param Value - value being inserted.
     */
    public    void insert(int positon, String Value){
               if( counter < 0 ){
                   setCounter(rows-1);
                   setMove(1);

                   return;
               }

               if((move == 1) && (connect4[counter][positon-1].equals(Blanck))){
                   connect4[counter][positon-1] = Value;

                   move --;
                   isHorizontalWin(positon-1);
                   isVeritcalWin(positon);
                   isDiagnalRightWin(positon-1);
                   isDiagnalLeftWin(positon-1);

               }

                counter--;
                     insert(positon,Value);

     }

    /***
     *  Get the specific row that a value is going into based on the player's decision to insert it in a specific column.
     *  If the cell in a row is full in a specific column, go to the next cell up in the last row. Insertion starts from  row 6 and goes to row 0.
     * @return counter
     */

    protected int getCounter() {
        return counter;
    }

    /***
     * Set the amount of move each player can make.
     * @param move
     */
    protected void setMove(int move) {
        this.move = move;
    }

    /***
     *  Set the specific row that a value is going into based on the player's decision to insert it in a specific column.
     *  If the cell in a row is full in a specific column, go to the next cell up in the last row. Insertion starts from row 6 and goes to row 0.
     * @param counter
     */
    protected void setCounter(int counter) {
        this.counter = counter;
    }


    /***
     * Get win condition for each player. A win condition with a value of 1 means that player 1 is the winner.
     * Win condition with a value of 0 means that player 2 is the winner.
     * @return  wincondition.
     */

    protected int getWincondition() {
        return wincondition;
    }

    /***
     * Set the win condition for each player. A win condition with a value of 1 means that player 1 is the winner.
     * Win condition with a value of 0 means that player 2 is the winner.
     * @param wincondition
     */
    protected void setWincondition(int wincondition) {
        this.wincondition = wincondition;
    }


    /***
     * Responsible for drawing a string representation of this game board.
     * @return return a string representation of the game board.
     */

    protected String draw(){
        StringBuilder mybuild = new StringBuilder();
        String value = " ";
        mybuild.append("\n");
        mybuild.append("\n");
        mybuild.append("\n");

        for (int i = 0; i < rows ; i++) {
            mybuild.append("                      ");
            for (int j = 0; j < column  ; j++) {

                     value = Blanck + connect4[i][j] + Blanck;

               // value =   connect4[i][j];
                mybuild.append("|");
                mybuild.append(value);
                mybuild.append("|");


            }
            mybuild.append("\n");
        }
        return mybuild.toString();

    }

    /***
     * Responsible for testing the Draw condition.
     * Game is Draw when all element in the  game board do not contain  a blank string.
     * @return return true if Connect4Logic is full.
     */
    protected boolean isBoardFill() {

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (connect4[i][j].equals(Blanck)) {
                    return false;
                }
            }
        }
        return true;
    }

    /***
     *  Determine if player 1 or 2 is the winner of the game through horizontal metric.
     * The horizontal metric state if there are four consecutive elements in a horizontal row are the same. The player who plays with that value will be the winner.
     * @param position  being played by the current player.
     */
    protected void isHorizontalWin(int position){

        if(counter < 0){
            setCounter(rows-1);
            return;
        }

        for (int i = 3; i >= 0; i--){

            if ((position - i >= 0) && (position - i + 3 < column) ){

                if (connect4[counter][position -i].equalsIgnoreCase(player1play) &&
                        connect4[counter][position -i+ 1].equalsIgnoreCase(player1play) &&
                        connect4[counter][position-i + 2].equalsIgnoreCase(player1play)  &&
                        connect4[counter][position-i + 3].equalsIgnoreCase(player1play)) {
                    setWincondition(0);
                    return;

                }

                if (connect4[counter][position -i].equalsIgnoreCase(player2play) &&
                        connect4[counter][position -i+ 1].equalsIgnoreCase(player2play) &&
                        connect4[counter][position-i + 2].equalsIgnoreCase(player2play)  &&
                        connect4[counter][position-i + 3].equalsIgnoreCase(player2play)) {
                    setWincondition(1);
                    return;
                }
            }


        }

        counter--;
       isHorizontalWin(position);

    }


    /***
     * Determine if  player 1 or 2 is the winner of the game through vertical metric
     * The vertical metric state if there are four consecutive elements in a vertical row are the same. The player who plays with that value will be the winner.
     * @param position being played by the current player.
     */

    protected void isVeritcalWin(int position){
        if(counter < 0){
            setCounter(rows-1);

            return;
        }


        for ( int i = 2; i >= 0; i--){

            if ((counter - i >= 0) && (counter - i + 3 <= rows-1) ){

                if (connect4[counter- i][position -1].equalsIgnoreCase(player1play) &&
                        connect4[counter- i + 1][position -1].equalsIgnoreCase(player1play) &&
                        connect4[counter- i + 2][position -1].equalsIgnoreCase(player1play) &&
                        connect4[counter- i + 3][position -1].equalsIgnoreCase(player1play)) {
                    setWincondition(0);

                    return;

                }

                if (connect4[counter- i][position-1 ].equalsIgnoreCase(player2play) &&
                        connect4[counter- i + 1][position -1].equalsIgnoreCase(player2play) &&
                        connect4[counter- i + 2][position -1].equalsIgnoreCase(player2play) &&
                        connect4[counter- i + 3][position -1].equalsIgnoreCase(player2play)) {
                    setWincondition(1);

                    return;

                }

            }

        }


        counter--;
        isVeritcalWin(position);

    }

    /***
     * Determine if  player 1 or 2 is the winner of the game through diagonal right metric.
     * The diagonal right  metric state if there are four consecutive elements in a diagonal right row are the same. The player who plays with that value will be the winner.
     * @param position being play by the current player.
     */
    protected void isDiagnalRightWin(int position){
        if (counter < 0) {
            setCounter(rows - 1);
            return;
        }

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if ((counter - i >= 0) && (counter - i + 3 < rows) && (position - j >= 0) && (position - j + 3 < column)) {


                    if (connect4[counter - i][position - j+3].equalsIgnoreCase(player1play) &&
                            connect4[counter - i + 1][position - j + 2].equalsIgnoreCase(player1play) &&
                            connect4[counter - i + 2][position - j + 1].equalsIgnoreCase(player1play) &&
                            connect4[counter - i + 3][position - j ].equalsIgnoreCase(player1play)) {
                        setWincondition(0);

                        return;
                    }
                    if (connect4[counter - i][position - j+3].equalsIgnoreCase(player2play) &&
                            connect4[counter - i + 1][position - j + 2].equalsIgnoreCase(player2play) &&
                            connect4[counter - i + 2][position - j + 1].equalsIgnoreCase(player2play) &&
                            connect4[counter - i + 3][position - j ].equalsIgnoreCase(player2play)) {
                        setWincondition(1);

                        return;
                    }
                }
            }
        }

        counter--;
        isDiagnalRightWin(position);


    }

    /***
     * Determine if  player 1 or 2 is the winner of the game through diagonal left metric.
     * The diagonal left metric state if there are four consecutive elements in a diagonal left row are the same. The player who plays with that value will be the winner.
     * @param position being played by the current player.
     */

    protected void isDiagnalLeftWin(int position){
        if (counter < 0) {
            setCounter(rows - 1);
            return;
        }

        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                if ((counter - i >= 0) && (counter - i + 3 < rows) && (position - j >= 0) && (position - j + 3 < column))  {

                    if (connect4[counter - i+3][position - j+3].equalsIgnoreCase(player1play) &&
                            connect4[counter - i + 2][position - j + 2].equalsIgnoreCase(player1play) &&
                            connect4[counter - i + 1][position - j + 1].equalsIgnoreCase(player1play) &&
                            connect4[counter - i ][position - j ].equalsIgnoreCase(player1play)) {
                        setWincondition(0);

                        return;
                    }

                    if (connect4[counter - i+3][position - j+3].equalsIgnoreCase(player2play) &&
                            connect4[counter - i + 2][position - j + 2].equalsIgnoreCase(player2play) &&
                            connect4[counter - i + 1][position - j + 1].equalsIgnoreCase(player2play) &&
                            connect4[counter - i ][position - j ].equalsIgnoreCase(player2play)) {
                        setWincondition(1);

                        return;
                    }
                }
            }
        }

        counter--;
        isDiagnalLeftWin(position);
    }


}
