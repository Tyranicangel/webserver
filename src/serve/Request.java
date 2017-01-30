/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.util.stream.Stream;

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
    
    public Request(String test){
        
    }
    
    public Request(Stream client){
        
    }
    
    private void parse(){
        
    }

}
