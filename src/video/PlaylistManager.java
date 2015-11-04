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
        Playlist playlist = new Playlist(4);
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
            /* perform action based on user's option */
            switch (menu)
            {
                case "1":
                
                    /* if user selects option one, allow uset to enter video information to be added to the playlist */
                    /* Display prompt to enter information */
                    System.out.println("Enter video information");
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Genre: ");
                    String genre = input.nextLine();
                    /* Intialize rating variable(number of stars) */
                    int rating = 0;
                    /*For the rating variable, make sure the value is between 1 and 5 */
                    do
                    {
                        System.out.print("Enter rating (number of stars) from 1 to 5: ");
                        rating = input.nextInt();
                    }
                    while ((rating <= 0) || (rating > 5));
                    /* Initialize the length of video variable(minutes) */
                    int length = -1;
                    /* For the video length variable, make sure the value is always positive */
                    do
                    {   
                        System.out.print("Enter the length of the video(minutes): ");
                        length = input.nextInt();
                    }
                    while (length <= 0);
                    /* If all variables are validated, add the video object to the array */
                    /* Initialize a video object with the information provided */
                    Video video = new Video(title,genre,rating,length);
                    /* Add the video object to the array if the array is not full*/
                    if (playlist.addVideo(video))
                    {
                        /* the playlist methods returns true if the array is not full */
                        System.out.println("Movie: " + title + " Successfully added to the playlist");
                    }
                    else
                    {
                        System.out.println("The playlist is full, video addition failed ");
                    }
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":    
        }
        }
        while (!menu.equalsIgnoreCase("0"));
        System.out.println("Thank you for using the program");
}
}
    