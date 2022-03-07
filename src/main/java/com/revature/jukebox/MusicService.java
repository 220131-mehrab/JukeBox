package com.revature.jukebox;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MusicService extends HttpServlet {
    MusicRepository musicRepository;
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput;
        userInput = req.getParameter("searchSong");
        if (userInput != null){
            String result = musicRepository.getSong(userInput);
            resp.getWriter().println(result);
        } else {
            for (String song: musicRepository.getMusicRecords()){
                resp.getWriter().println(song);
            }
        }
    }
}
