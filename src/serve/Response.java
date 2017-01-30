/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.OutputStream;

/**
 *
 * @author Pradyumna
 */
public class Response {
   int code;
   String resourcePhrase;
   Resource resource;
   
   public Response(Resource resource){
       
   }
   
   public void send(OutputStream output){
       
   }
}
