package Util;

import java.io.IOException;


import IO.playerInfo;


/** Runs the Connect 4 game by calling on to the displayPlayinfo method in the class playerInfo.
 * @file import playerInfo class which handles the input and output of the Connect 4 game.
 * The class has one method, the displayPlayInfo method. This method controls the flow of the game.
 *
 */
public class Connect4TextConsole {
    public static void main(String[] args) throws IOException, InterruptedException {
       playerInfo allplayers = new playerInfo();
       allplayers.displayPlayInfo();

        System.out.println("Bug Fix");
        System.out.println("Bug Fix");

    }


}