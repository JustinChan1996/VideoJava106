/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

/**
 *
 * @author Justin
 */
import java.util.Scanner;
public class PlaylistManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /* This is the main class which will allow the user to create a playlist, add videos and remove videos from */
        /* the playlist and find a video. */
        /* Create a playlist object with a value of 4 */
        Playlist[] playlist = new Playlist[4];
        /* Initialize menu option variable */
        String menu = "";
        /* Use a post test loop to  ensure that the program keeps running unless the user types 0(quit) in the menu*/
        do
        {
            /* Print menu and allow user to select the option */
            System.out.println("Playlist Manager by Justin Chan of HELP University");
            System.out.println("Select any options from the menu below by typing the option number");
            System.out.println("1. Add a new video to the playlist");
            System.out.println("2. Show all videos");
            System.out.println("3. Change video information");
            System.out.println("4. Display movie ratings summary information");
            System.out.println("5. Search Video by keyword");
            System.out.println("6. Find videos by minimum ratings");
            System.out.println("Type 0 to quit");
            /* Gather option from user */
            System.out.print("Your option: ");
            menu = input.nextLine();
        }
        while (!menu.equalsIgnoreCase("0"));
    }
    
}
