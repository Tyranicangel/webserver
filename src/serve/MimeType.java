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
public class MimeType extends Config{
    
    public MimeType(String fName) throws FileNotFoundException {
        super(fName);
    }
    
    public String lookup(String ext) throws IOException{
        super.load();
        
        return null;
    }
    
    
    
}
