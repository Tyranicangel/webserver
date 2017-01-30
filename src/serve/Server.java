/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Dictionary;

/**
 *
 * @author Pradyumna
 */
public class Server {
    Httpd config;
    MimeType mimeTypes;
    ServerSocket socket;
    Dictionary accessFiles;
    
    public Server() throws FileNotFoundException, IOException{
        config=new Httpd("httpd.conf");
        config.load();
    }
    
    public void start() throws FileNotFoundException, IOException{
        ServerSocket server = new ServerSocket(config.PORT);
        System.out.println("Server listening on PORT:"+config.PORT);
        while(true){
            Socket client = server.accept();
            Worker thread = new Worker(client, mimeTypes, config);
            thread.start();
        }
    }
}
