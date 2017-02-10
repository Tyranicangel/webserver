/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author Pradyumna
 */
public class Request {
    String uri;
    Object body;
    String verb;
    String httpVersion;
    Dictonary headers;
    
    public Request(BufferedReader client) throws IOException{
        StringTokenizer tokens = new StringTokenizer(client.readLine());
        //@todo:Raise Bad request for each here
        this.verb=tokens.nextToken();
        this.uri=tokens.nextToken();
        this.httpVersion=tokens.nextToken();
        this.headers = new Dictonary();
        
        //@todo: Raise bad request here
        while(true){
            String line=client.readLine();
            if(line.isEmpty()) break;
            String[] dat = line.split(":",2);
            this.headers.add(dat[0], dat[1]);
        }
    }
    
    private void parse(){
        
    }

}
