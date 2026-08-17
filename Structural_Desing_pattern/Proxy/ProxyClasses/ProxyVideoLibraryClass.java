package Structural_Desing_pattern.Proxy.ProxyClasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Structural_Desing_pattern.Proxy.interfaces.VideoLibrary;

public class ProxyVideoLibraryClass implements VideoLibrary{

    private VideoLibrary videoLibrary;
    private List<String> videoCaches;
    private Map<String, String> videoInfoCache = new HashMap<>();

    public ProxyVideoLibraryClass(VideoLibrary videoLibrary) {
        this.videoLibrary = videoLibrary;
    }

    @Override
    public List<String> getVideos() {
        if(videoCaches == null){
            System.out.println("Fetching videos from the server");
            videoCaches = videoLibrary.getVideos();
        }
        return videoCaches;
    }

    @Override
    public String getVideInfo(String videoId) {
        if(videoInfoCache.get(videoId) == null){
            System.out.println("Fetching video info from the server");
            videoInfoCache.put(videoId, videoLibrary.getVideInfo(videoId));
        }
        return videoInfoCache.get(videoId);
    }

    @Override
    public void downloadVideo(String videoId) {
        videoLibrary.downloadVideo(videoId);
    }

}
