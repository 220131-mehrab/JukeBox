package com.revature.jukebox;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicRepository implements IMusicRepoHandler{
    private List<String> musicRecords;
    private InputStream file;

    public MusicRepository(String file) {
        this.musicRecords = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(file);
        System.out.println("File is in the JVM");
        load();
    }

    private void load(){
        Scanner scanner = new Scanner(this.file);
        System.out.println("Preparing to load file into program");
        scanner.useDelimiter("]");
        while (scanner.hasNext()){
            this.musicRecords.add(scanner.next());
        }
        System.out.println("Done loading file into program");
    }

    public List<String> getMusicRecords() {
        return musicRecords;
    }

    public String getSong(String song){
        String result = new String();
        for (String songName : this.musicRecords){
            if (musicRecords.contains(song)){
                result = songName;
            }
        }
        return result;
    }
}
