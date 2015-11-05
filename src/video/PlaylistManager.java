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
                
                    /* if user selects option 1, allow uset to enter video information to be added to the playlist */
                    /* Display prompt to enter information */
                    System.out.println("Enter video information");
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Genre: ");
                    String genre = input.nextLine();
                    /* Intialize rating varable(number of stars) */
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
                    boolean bool = playlist.addVideo(video);
                    if (bool == true)
                    {
                        /* the playlist methods returns true if the array is not full */
                        System.out.println("Movie: " + title + " Successfully added to the playlist");
                    }
                    else
                    {
                        System.out.println("The playlist is full, video addition failed ");
                    }
                    input.nextLine();
                    break;
                    
            case "2":
                
                    /* If user selects option number 2, display the information of all videos in the playlist */
                    System.out.println("Information about the videos in the playlist" + "\n");
                    System.out.print(playlist.ShowAllVideos());
                    break;
                
            case "3":
                
                    /* if the user selects the 3rd option, allow the user to change the movie attributes */
                    /* Gather movie title from the user */
                    System.out.println("Edit movie attributes");
                    System.out.println("Select movie title: ");
                    String name = input.nextLine();
                    /* Check if movie title is in the playlist */
                    int position = playlist.getVideo(name);
                    /* if position is null, display error mesage */
                    if (position == -1)
                    {
                        System.out.println("Movie not found");
                    }
                    else
                    {
                        /* Present option to the users to change the attributes */
                        System.out.println("Select attributes to modify:");
                        System.out.println("1. Title");
                        System.out.println("2. Genre");
                        System.out.println("3. Rating");
                        System.out.println("4. Movie Length");
                        System.out.println("Option: ");
                        String optionModify = input.nextLine();
                        /* Change atribute based on user's option */
                        switch (optionModify)
                        {
                            case "1":
                                
                                    /* Let user change title */
                                    String newtitle = "";
                                    System.out.println("New title: ");
                                    newtitle = input.nextLine();
                                    
                            case "2":
                            case "3":
                            case "4":
                            default:
                                    System.out.println("Invalid option");
                        }
                    }
                            
            case "4":
            case "5":
            case "6":
            default:
                    System.out.println("Invalid option");
        }
        }
        while (!menu.equalsIgnoreCase("0"));
        System.out.println("Thank you for using the program");
}
}
    