package Composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    private String name;
    private List<FileSystem> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        children.add(fileSystem);
    }

    public void remove(FileSystem fileSystem){
        children.remove(fileSystem);
    }

    @Override
    public void ls() {
        
        System.out.println("Directory: " + name);

        for (FileSystem fileSystem : children) {
            fileSystem.ls();
        }

    }

}
