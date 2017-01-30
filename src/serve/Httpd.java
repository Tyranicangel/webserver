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
public class Httpd extends Config{
    Dictonary aliases;
    Dictonary scriptAliases;
    int PORT;
    String ServerRoot;
    String DocumentRoot;
    String LogFile;
    String AccessFileName;
    ArrayList<String> DirectoryIndex;
    
    
    public Httpd(String fName) throws FileNotFoundException, IOException {
        super(fName);
        this.PORT=80;
        this.load();
        this.DirectoryIndex = new ArrayList<>();
    }   
    
    /**
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public void load() throws FileNotFoundException, IOException{
        super.load();
        data.stream().filter((string) -> (!string.startsWith("#"))).map((string) -> string.split(" ", 2)).forEachOrdered((reference) -> {
            switch (reference[0]){
                case "PORT": this.PORT=Integer.parseInt(reference[1]);
                case "ServerRoot":this.ServerRoot=reference[1].replaceAll("^\"|\"$", "");
                case "DocumentRoot":this.DocumentRoot=reference[1].replaceAll("^\"|\"$", "");
                case "LogFile":this.LogFile=reference[1].replaceAll("^\"|\"$", "");
                case "AccessFileName":this.AccessFileName=reference[1].replaceAll("^\"|\"$", "");
            }
        });
    }
}
