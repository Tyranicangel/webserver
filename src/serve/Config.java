/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pradyumna
 */
public class Config {
    final File file;
    Scanner reader;
    protected ArrayList<String> data;
    
    public Config(String fName) throws FileNotFoundException{
        this.file=new File(fName);
        this.data=new ArrayList<>();
    }
    
    public void load() throws FileNotFoundException, IOException{
        this.reader=new Scanner(this.file);
        while(this.hasMoreLines()){
            String dat=this.nextLine();
            if(dat!=null){
                this.data.add(dat);
            }
        }
        
    }
    
    public String nextLine(){
        String out = this.reader.nextLine();
        if(!out.isEmpty()){
         return out;
        }
        return null;
    }
    
    public boolean hasMoreLines(){
        return this.reader.hasNextLine();
    }
}
