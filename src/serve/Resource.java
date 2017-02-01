/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

/**
 *
 * @author Pradyumna
 */
public class Resource {
    public final Httpd config;
    private final String uri;
    public Resource(String uri, Httpd config){
        this.uri=uri;
        this.config=config;
        
    }
    
    public String absolutePath(){
        return config.DocumentRoot+uri;
    }
    
    public boolean isScript(){
        return false;
    }
    
    public boolean isProtected(){
        return false;
    }
}
