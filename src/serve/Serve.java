/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Pradyumna
 */
public class Serve {
    Server server;
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{ 
        Serve serve = new Serve();
        serve.run();
    }
    
    public void run() throws FileNotFoundException, IOException{
        this.server=new Server();
        server.start();
    }
    
}
