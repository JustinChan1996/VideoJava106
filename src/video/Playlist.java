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
        if (size >= 0)
        {
            list = new Video [size];
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
        for (int i = 0 ; i < list.length; i = i + 1)
        {
            stringVar = stringVar + list[i].toString() + "\n";
            
        }
        return stringVar;
    }
            
    /* the searchVideo method searches for the video with the same title as the input argument */
    /* If no such video exists, return null.
    /* The return type of the method is an integer value which states the position of the array. */
    public int searchVideo(String title)
    {
        /* Declare variable to hold position of the object in the array */
        /* Initialize it with the null value which is -1(title not found */
        int pos = -1;
        /* Loop through the array to search for the video object with the same title as the input argument */
        for (int i = 0; i < list.length; i = i + 1)
        {
            if (list[i].getTitle().equals(title))
            {
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    /* The showVideosWithMinimum returns an array of videos with greather than or equal to the number of
    ratings in terms of stars */
    public String[] showVideoWithMinimum()
    {
        
    }
    
    
    
    
}
