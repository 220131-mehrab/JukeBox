package com.revature.jukebox;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class MusicServer {
    String webAppName = "/JukeBox";

    public MusicServer (MusicService musicService){
        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(0);
        server.getConnector();
        server.addContext(webAppName, null);
        server.addServlet(webAppName,"top200", musicService).addMapping("/List");
        server.addServlet(webAppName,"searchSong", new SearchFormServlet()).addMapping("/searchSong");
        try {
            server.start();
            System.out.println("Server running on http://localhost:" + server.getConnector().getLocalPort() + webAppName);
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
