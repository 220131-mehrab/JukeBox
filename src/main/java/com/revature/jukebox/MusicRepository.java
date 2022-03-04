package com.revature.jukebox;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicRepository {
    private List<String> musicRecords;
    private InputStream file;

    public MusicRepository(String file) {
        this.musicRecords = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(file);
        System.out.println("File is in the JVM");
    }

    private void load(){
        Scanner scanner = new Scanner(this.file);
        System.out.println("Preparing to load file into program");
        this.musicRecords.add(scanner.next());
        System.out.println("Done loading file into program");
    }
}
