/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Pradyumna
 */
public class Response {
   int code;
   String resourcePhrase;
   private final Resource resource;
   private MimeType mimeTypes;
   
   public Response(Resource resource) throws FileNotFoundException, IOException{
       this.resource=resource;
       this.mimeTypes=new MimeType("mime.types");
       this.mimeTypes.load();
   }
   
   public String getExtension(File f){
       String fName=f.getName();
       return fName.substring(fName.lastIndexOf(".")+1);
   }
   
   public void send(OutputStream output) throws IOException{
       PrintWriter out = new PrintWriter(output,true);
       File f = new File(this.resource.absolutePath());
       if(!f.exists()){
           this.resourcePhrase="404 Not Found";
           out.println("HTTP/1.1 "+this.resourcePhrase);
           out.println("\r\n");
           out.println("<p> Hello world </p>");
           out.flush();
           out.close();
       }
       else{
        if(f.isDirectory()){
            File[] list=f.listFiles();
             ArrayList<String> fileList = new ArrayList<>();
             for (File file : list) {
                 if(file.isFile()){
                     fileList.add(file.getName());
                 }
             }
             for (String fname : this.resource.config.DirectoryIndex) {
                 if(fileList.contains(fname)){
                     if(this.resource.absolutePath().endsWith("/")){
                         f = new File(this.resource.absolutePath()+fname);
                     }
                     else{
                         f = new File(this.resource.absolutePath()+"/"+fname);
                     }
                     break;
                 }
             }
            }
            String ext = getExtension(f);
            out.println("HTTP/1.1 "+this.resourcePhrase);
            out.println("Content-Type: "+this.mimeTypes.lookup(ext));
//            pw.println("Date: " + gmtFrmt.format(new Date()));
            out.println("\r\n");
//            out.flush();
            BufferedInputStream fData=new BufferedInputStream(new FileInputStream(f));
            byte[] bytes=new byte[(int)f.length()];
            fData.read(bytes,0,bytes.length);
            output.write(bytes);
            out.close();
       }
   }
}
