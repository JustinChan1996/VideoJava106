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
public class Video {
    /* This class stores the attributes of a certainvideo in a playlist */
    /* The attributes of this class are title, genre, rating(number of stars), and length(minutes)*/
    
    /* Declare attributes */
    private String title;
    private String genre;
    private int rating = 0;
    private int length = 0;
    
    /* Declare constructor with no arguments */
    public Video()
    {
        title = "";
        genre = "";
        rating = 0;
        length = 0;
    }
    
    /* Declare constructor with arguments */
    public Video(String videoTitle,String videoGenre, int videoRating, int videoLength)
    {
        title =  videoTitle;
        genre = videoGenre;
        rating = videoRating;
        length = videoLength;
    }
    
    /* Getter methods */
    public String getTitle()
    {
        return title;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public int getRating()
    {
        return rating;
    }
    
    public int getLength()
    {
        return length;
    }
    
    /* Setter methods */
    public void setTitle(String videoTitle)
    {
        title = videoTitle;
    }
    
    public void setGenre(String videoGenre)
    {
        genre = videoGenre;
    }
    
    public void setRating(int videoRating)
    {
        /* Make sure the input variable is not a negative number */
        if (videoRating > 0)
        {
            rating = videoRating;
        }
        
    }
    
    public void setLength(int videoLength)
    {
        /* Make sure the input variable is not a negative number */
        if (videoLength >0)
        {
            length = videoLength;
        }
        
    }
    /* toString method */
    @Override public String toString()
    {
        /* Convert the video length in minutes to  to hour and minutes forthe toString methods */
        /* Find the number of hours first */
        int hours = length / 60;
        /* Then find the number of remainign minutes */
        int minutes = length % 60;
        return "Video: " + title + "     Genre: " + genre + "     Rating: " + rating + " stars" + "     Length: " + hours + " hours " + minutes + " minutes";   
    }
    
}
