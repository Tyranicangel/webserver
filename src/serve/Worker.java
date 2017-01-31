/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pradyumna
 */
public class Worker extends Thread{
    Socket client;
    MimeType mimeType;
    Httpd config;
    
    public Worker(Socket client,MimeType mimeType, Httpd config){
        this.client=client;
        this.mimeType=mimeType;
        this.config=config;
    }
    
    @Override
    public void run(){
        try {
            processRequest();
        } catch (IOException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processRequest() throws IOException{
        BufferedReader inpt = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
        Request req = new Request(inpt);
        this.sendResponse();
        client.close();
    }
    
    protected void sendResponse() throws IOException{
        System.out.println("Sending Response");
        System.out.println(this.client);
        try (PrintWriter out = new PrintWriter(this.client.getOutputStream(),true)) {
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("\r\n");
            out.println("<p> Hello world </p>");
            out.flush();
        }
    }
}
