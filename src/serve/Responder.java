/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.IOException;

/**
 *
 * @author Pradyumna
 */
public class Responder {
    public Response getReponse(Request req, Resource res) throws IOException{
        return new Response(res);
    }
}
