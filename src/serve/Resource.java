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
    public Resource(String uri, Httpd config){
        
    }
    
    public String absolutePath(){
        return null;
    }
    
    public boolean isScript(){
        return false;
    }
    
    public boolean isProtected(){
        return false;
    }
}
