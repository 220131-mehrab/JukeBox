package com.revature.jukebox;

import java.util.List;

public class App {
    public static void main(String[] args){
        MusicRepository musicRepository = new MusicRepository("data.csv");
        MusicService musicService = new MusicService(musicRepository);
        MusicServer musicServer = new MusicServer(musicService);
    }
}
