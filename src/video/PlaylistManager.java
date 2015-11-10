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
                    System.out.print("Select movie title: ");
                    String name = input.nextLine();
                    /* Get video from playlist */
                    Video selectedVideo = playlist.getVideo(name);
                    /* if video object is null, display error message */
                    if (selectedVideo == null)
                    {
                        System.out.println("Movie not found");
                    }
                    else
                    {
                        /* If movvie is present, show video attributes */
                        System.out.println("\n" + selectedVideo.toString());
                        /* Present option to the users to change the attributes */
                        System.out.println("Select attributes to modify:");
                        System.out.println("1. Title");
                        System.out.println("2. Genre");
                        System.out.println("3. Rating");
                        System.out.println("4. Movie Length");
                        System.out.print("Option: ");
                        String optionModify = input.nextLine();
                        /* Change atribute based on user's option */
                        switch (optionModify)
                        {
                            case "1":
                                
                                    /* Let user change title */
                                    String newtitle = "";
                                    System.out.print("New title: ");
                                    newtitle = input.nextLine();
                                    /* Save changes to edited title */
                                    selectedVideo.setTitle(newtitle);
                                    System.out.println("Title for the video is successfully edited");
                                    break;
                                    
                            case "2":
                                
                                    /* Let user change genre */
                                    String newGenre = "";
                                    System.out.print("New genre: ");
                                    newGenre = input.nextLine();
                                    /* Save changes to edited title */
                                    selectedVideo.setGenre(newGenre);
                                    System.out.println("Genre for the video is successfully edited");
                                    break;
                                
                            case "3":
                                
                                    /* Let user change rating */
                                    int newRating = 0;
                                    System.out.print("New rating(1-5 stars): ");
                                    newRating = input.nextInt();
                                    /* Check if user input is within acceptable range */
                                    if ((newRating > 0) && (newRating <= 5))
                                    {
                                        /* Save changes to the edited rating */
                                        selectedVideo.setRating(newRating);
                                        System.out.println("Rating for the video is successfully edited");
                                    }
                                    else
                                    {
                                        /* If the user input is invalid, display error message and do not record change */
                                        System.out.println("Invalid input, changes will not be recorded");
                                    }
                                    break;
                            
                            case "4":
                                
                                    /* Let user change duration of video */
                                    int newLength = 0;
                                    System.out.print("New Duration(minutes): ");
                                    newLength = input.nextInt();
                                    /* Check if user input is within acceptable range */
                                    if (newLength > 0)
                                    {
                                        /* Save changes to the edited rating */
                                        selectedVideo.setLength(newLength);
                                        System.out.println("Length of the video is successfully edited");
                                    }
                                    else
                                    {
                                        /* If the user input is invalid, display error message and do not record change */
                                        System.out.println("Invalid input, changes will not be recorded");
                                    }
                                    break;
                                    
                                
                            default:
                                    System.out.println("Invalid option");
                                    System.out.println("Returning to main menu");
                                    break;
                        }
                    }
                    break;
                            
            case "4":
                    
                    /* If the user selects the 4th option, display the summary information about the movie ratings in the playlist */
                    System.out.println(playlist.showRatingSummary());
                    break;
                
            case "5":
                
                    /* If the user selects the 5th option, */
                    /* show the details of all the Videos with ANY non-numeric attribute that matches this keyword. */
                    /* If no Videos are found, show an error message. */
                    String keyword;
                    System.out.print("Enter keyword to search videos: ");
                    keyword = input.nextLine();
                    /* Search playlist for videos with the keyword */
                    System.out.println("\n" + playlist.searchVideos(keyword));
                    break;
                
            case "6":
                
                    /* If the user selects the 6th option, show the videos with the minimum of stars(ratings) that is selected by the user */
                    int stars = 0;
                    System.out.print("Enter the minimum amount of stars(from 1 to 5): ");
                    stars = input.nextInt();
                    /* Only perform operation if input is greater than zero but less or equal to 5 */
                    if ((stars > 0) && (stars <= 5))
                    {
                        /* Create video array to store the objects from the showVideosWithMinimum() function */
                        Video[] minimumStars;
                        minimumStars = playlist.showVideosWithMinimum(stars);
                        /* if array is null, display error message, otherwise, display the title and value of videos with the minimum stars */
                        if (minimumStars == null)
                        {
                            System.out.println("No videos satisfy the input requirements");
                        }
                        else
                        {
                            /* Print the header */
                            System.out.println("Movies with ratings of " + stars + " or greater" + "\n");
                            /* Loop through the array to print the movie's title and value */
                            for (int i = 0; i < minimumStars.length; i = i + 1)
                            {
                                System.out.println("Title: " + minimumStars[i].getTitle());
                                /* Find the length and find its hours and minutes */
                                int movieLength = minimumStars[i].getLength();
                                int hours = movieLength / 60;
                                int minutes = movieLength % 60;
                                System.out.println("Length: " + hours + " hours " + minutes + "minutes" + "\n");
                            }
                        }
                    }
                    else
                    {
                        /* Print error message if input value is invalid */
                        System.out.println("Input value is invalid");
                    }
                    input.nextLine();
                    break;
                
            default:
                
                    /* If the user types anything other than 1 to 6, display an error message */
                    System.out.println("Invalid option");
        }
        }
        while (!menu.equalsIgnoreCase("0"));
        System.out.println("Thank you for using the program");
}
}
    