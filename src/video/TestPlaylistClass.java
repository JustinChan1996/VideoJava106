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
public class TestPlaylistClass {
        public static void main(String[] args) {
        // TODO code application logic here
        // Create new container class (Successful)
        Playlist playlist = new Playlist(10);
        // Add new objects to the container class (Successful)
        Video video1 = new Video("Pac man","Sci-Fi",5,120);
        playlist.addVideo(video1);
        Video video2 = new Video("The day after tommorow","Aprocalyptic",4,125);
        playlist.addVideo(video2);
        Video video3 = new Video("Ant man","Sci-Fi",3,100);
        playlist.addVideo(video3);
        Video video4 = new Video("Everest","Adventure",4,110);
        playlist.addVideo(video4);
        Video video5 = new Video("TED-2","Triller",5,130);
        playlist.addVideo(video5);
        Video video6 = new Video("Smurfs","Comedy",4,90);
        playlist.addVideo(video6);
        Video video7 = new Video("2012","Aprocalyptic",5,150);
        playlist.addVideo(video7);
        Video video8 = new Video("San Andreas","Triller",5,140);
        playlist.addVideo(video8);
        Video video9 = new Video("Jurassic Park 2","Triller",4,110);
        playlist.addVideo(video9);
        Video video10 = new Video("King Kong","Triller",5,130);
        playlist.addVideo(video10);
        // Test the ShowAllVideos function (Successful)
        System.out.println(playlist.ShowAllVideos());
        // Test the getVideo function
        System.out.println("The position for the San Andreas video is " + playlist.getVideo("San Andreas"));
        // Test the searchVideos function
        System.out.println("The movies with the keyword triller are: \n" + playlist.searchVideos("triller"));
        // Test the showVideoWithMinimum function (successful)
        Video[] solution;
        System.out.println("These are the videos with ratings greater than or equal to 4 stars");
        solution = playlist.showVideosWithMinimum(4);
        for (int i = 0; i < solution.length; i = i + 1)
        {
            System.out.println(solution[i].toString());
        }
        // Testing the showRatingSummary method(successful)
        System.out.println(playlist.showRatingSummary());
    }
}
