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
                case "Listen": this.PORT=Integer.parseInt(reference[1]);break;
                case "ServerRoot":this.ServerRoot=reference[1].replaceAll("^\"|\"$", "");break;
                case "DocumentRoot":this.DocumentRoot=reference[1].replaceAll("^\"|\"$", "");break;
                case "LogFile":this.LogFile=reference[1].replaceAll("^\"|\"$", "");break;
                case "AccessFileName":this.AccessFileName=reference[1].replaceAll("^\"|\"$", "");break;
                case "DirectoryIndex":
                    String[] indexes=reference[1].split(" ");
                    for (int i = 0; i < indexes.length; i++) {
                        this.DirectoryIndex.add(indexes[i]);
                    }
                    break;
                default:break;
            }
        });
    }
}
