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
import java.util.*;
public class Playlist {
    /* Container class for the video class. Each object here belongs to the video class */
    /* Declare array to store video objects */
    private Video[] list;
    /* Declare Count variable which keep tracks of number of Videos currently in the collection */
    private int Count = 0;
    
    /* A constructor with arguments to initialize the container class. It accepts an integer to set the size
    of the array
    */
    public Playlist(int size)
    {
        /* Set the array size to the argument if the input argument is not negative, else
        set the array size to 20
        */
        if (size > 0)
        {
            list = new Video[size];
        }
        else 
        {
            list = new Video[20];
        }
        /* Set the count to 0 */
        Count = 0;
    }
    
    /* The addVideo method adds a video object to the array. If the array is full, don't add and return false */
    /* The return type is boolean */
    public boolean addVideo(Video video)
    {
        if (Count == list.length)
        {
            return false;
        }
        else
        {
            list[Count] = video;
            Count = Count + 1;
            return true;
        }
    }
    
    /* The ShowAllVideos method shows all the information of the videos in the playlist using the toString method */
    /* Return type is String */
    public String ShowAllVideos()
    {
        /* Initialize string variable to hold all the information */
        String stringVar = "";
        for (int i = 0 ; i < Count; i = i + 1)
        {
            stringVar = stringVar + list[i].toString() + "\n";
            
        }
        return stringVar;
    }
            
    /* the getVideo method searches for the video with the same title as the input argument */
    /* If no such video exists, return null.
    /* The return type of the method is an integer value which states the position of the array. */
    public Video getVideo(String title)
    {
        /* Declare video variable */
        /* Initialize it with the null value */
        Video video = null;
        /* Loop through the array to search for the video object with the same title as the input argument */
        for (int i = 0; i < Count; i = i + 1)
        {
            if (list[i].getTitle().equals(title))
            {
                video = list[i];
                break;
            }
        }
        return video;
    }
    
    /* The searchVideos method accepts a keyword and searches for all videos with the keyword as a substring in
    all its text attributes */
    /* The method returns a string containing all the information about the videos which have matching keywords. */
    /* If there are no videos with matching keywords, return the String "no matching videos found ".
    */
    public String searchVideos(String keyword)
    {
        /* Declara string variable variable to hold the videos information */
        String info = "";
        /* Loop through the array to search for videos with matching keywords in any of its attributes */
        for(int i = 0; i < Count; i = i + 1)
        {
            /* detect keyword in any of the attributes by searching for the index within the string of the last occurance of the substring */
            /* Initlialize index position of each attribute to null(-1). */
            int isTitle = -1;
            int isGenre = -1;
            /* Scan attribute for index of substring regardless of case sensitivity */
            isTitle = list[i].getTitle().toLowerCase().lastIndexOf(keyword.toLowerCase());
            isGenre = list[i].getGenre().toLowerCase().lastIndexOf(keyword.toLowerCase());
            /* If the index of the substring exists in both attributes, add the video informaiton to the string*/
            if ((isTitle >= 0) || (isGenre >= 0))
            {
                info = info + list[i].toString() + "\n";
            }
        }
        /* Return the string if the string is not null, otherwise, display no videos with this keyword found */
        if (info.isEmpty())
        {
            return "No videos with this keyword";
        }
        else
        {
            return info;
        }
    }
        
    
    /* The showVideosWithMinimum returns an array of videos with greater than or equal to the number of
    ratings in terms of stars */
    /* The return type of the function is video object */
    public Video[] showVideosWithMinimum(int stars)
    {
	/* Use an arraylist to store all the videos that satify the requirements */
        /* Initialize arraylist to store all the objects */
        ArrayList<Video> arraylist = new ArrayList<Video>();
        /* Use a loop to scan through all the objects and add the items to the arraylist object */
        for (int i = 0; i < Count; i = i + 1)
        {
            /* if the video's rating satisfy the input requirements, add it to the arraylist object */
            if (list[i].getRating() >= stars)
            {
                arraylist.add(list[i]);
            }
        }
        /* After scanning through the loop, if the arraylist is empty, return null, otherwise add it to the array */
        if (arraylist.isEmpty())
        {
            return null;
        }
        else 
        {
            /* Create an array with the same size as the arraylist */
            /* Copy all the contents of the arraylist to the array */
            Video returnArray[] = arraylist.toArray(new Video[arraylist.size()]);
            /* Return the array */
            return returnArray;
        }
    }
        
    /* The showRatingSumary method shows the summary information about the movie ratings in the playlist */
    /* It displays the number of movies that recieives each category of rating from 1 to 5*/
    /* The return type is a string containing all the summary information */
    public String showRatingSummary()
    {
	/* Initialize variables to store number of ratings */
	int oneStar = 0;
	int twoStar = 0;
	int threeStar = 0;
	int fourStar = 0;
	int fiveStar = 0;
	/* Loop through the array and increment each counter whenever each citeria is fullfiled */
	for (int i = 0; i < Count; i = i + 1)
	{
		switch (list[i].getRating())
		{
			case 1: oneStar = oneStar + 1;
				break;
			case 2: twoStar = twoStar + 1;
				break;
			case 3: threeStar = threeStar + 1;
				break;
			case 4: fourStar = fourStar + 1;
				break;
			case 5: fiveStar = fiveStar + 1;
				break;
		}
	}
	/* Return the summary information as a string */
	return "Summary information for video ratings in the playlist" + "\n" + "1 stars: " + 		oneStar + "\n" + "2 stars: " + twoStar + "\n" + "3 stars: " + threeStar + "\n" + "4 stars: " + fourStar + "\n" + "5 stars: " + fiveStar + "\n";
    }
}
        
    
    
    
