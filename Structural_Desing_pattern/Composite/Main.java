package Composite;

public class Main {

    public static void main(String[] args) {
        
        // take a good example of folder name and its subfolders
        Directory music = new Directory("Music");

        Directory rock = new Directory("Rock");
        Directory pop = new Directory("Pop");

        File song1 = new File("Humnava by Papon");

        music.add(song1);
        
        music.add(rock);
        music.add(pop);
            
        // rock song
        File song2 = new File("Thunderstruck by AC/DC");
        rock.add(song2);

        // pop song
        File song3 = new File("Shape of You by Ed Sheeran");
        pop.add(song3);

        music.ls();

    }

}
