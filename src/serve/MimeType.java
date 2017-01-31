/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Pradyumna
 */
public class MimeType extends Config{
    Dictonary types;
    public MimeType(String fName) throws FileNotFoundException {
        super(fName);
        this.types = new Dictonary();
    }
    
    @Override
    public void load() throws FileNotFoundException, IOException{
        super.load();
        for (String string : data) {
            if(!string.startsWith("#")){
                String[] temp = string.split("\t");
                String[] temp2 = temp[temp.length-1].split(" ");
                for (String string1 : temp2) {
                    types.add(string1, temp[0]);
                }
            }
        }
    }
    
    public String lookup(String ext) throws IOException{
        return this.types.get(ext);
    }
    
    
    
}
