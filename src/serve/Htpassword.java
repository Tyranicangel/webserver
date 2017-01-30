/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.io.FileNotFoundException;

/**
 *
 * @author Pradyumna
 */
public class Htpassword extends Config {
    Dictonary users;
    
    public Htpassword(String fName) throws FileNotFoundException {
        super(fName);
    }
    
    public boolean isAuth(String userName, String password){
        return true;
    }
}
