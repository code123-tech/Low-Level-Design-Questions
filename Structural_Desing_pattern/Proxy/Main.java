package Structural_Desing_pattern.Proxy;

import Structural_Desing_pattern.Proxy.ProxyClasses.ProxyVideoLibraryClass;
import Structural_Desing_pattern.Proxy.RealClasses.VideoLibraryClass;
import Structural_Desing_pattern.Proxy.interfaces.VideoLibrary;

public class Main {
    
    public static void main(String[] args) {
        
        VideoLibrary videoProxyLibrary = new ProxyVideoLibraryClass(new VideoLibraryClass());

        System.out.println(videoProxyLibrary.getVideos());
        System.out.println(videoProxyLibrary.getVideInfo("video1"));
        videoProxyLibrary.downloadVideo("video1");

        System.out.println("====== After caching ======");
        // after caching
        System.out.println(videoProxyLibrary.getVideos());
        System.out.println(videoProxyLibrary.getVideInfo("video1"));
        videoProxyLibrary.downloadVideo("video1");
    }
}
