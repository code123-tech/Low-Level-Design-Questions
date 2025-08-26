package Proxy.interfaces;

import java.util.List;

public interface VideoLibrary {

    List<String> getVideos();
    String getVideInfo(String videoId);
    void downloadVideo(String videoId);
}
