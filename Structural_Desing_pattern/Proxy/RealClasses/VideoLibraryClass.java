package Proxy.RealClasses;

import java.util.Arrays;
import java.util.List;

import Proxy.interfaces.VideoLibrary;

public class VideoLibraryClass implements VideoLibrary{

    @Override
    public List<String> getVideos() {
        return Arrays.asList("video1", "video2", "video3");
    }

    @Override
    public String getVideInfo(String videoId) {
        return "Video Info of " + videoId;
    }

    @Override
    public void downloadVideo(String videoId) {
        System.out.println("Downloading video from the server for videoId: " + videoId);
    }
}
