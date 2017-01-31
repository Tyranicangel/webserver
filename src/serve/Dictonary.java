/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serve;

import java.util.*;

/**
 *
 * @author Pradyumna
 */
class Dictonary {
   public Map<String, String> dict;

    Dictonary() {
        this.dict = new HashMap<>();
    }
    
    public void add(String key, String value){
        this.dict.put(key, value);
    }
    
    public String get(String key){
        return this.dict.get(key);
    }
}
