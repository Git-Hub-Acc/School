/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*--------------------------------------------------------------------------------------------------------
    *Q2 a:
    * This is a program to hash user passwords read from a json file.
    * The hashed passwords are then written to a text file as json objects. 
    * The original file is an array of json objects, each object includes username and password. 
    * The output file is actualy a json object made of the title 'users' and an array.
    * The inner array is made of json objects made of users and hashed passswords.
    --------------------------------------------------------------------------------------------------------*/
 /*Q2 b:*/
public class Hash_Passwords_JSON {

    // Function to hash passwords.
    public void hash() {
        try {
            JSONParser parser = new JSONParser(); // create json parser object.
            JSONObject output = new JSONObject(); // json object to save in file.
            JSONArray users_array = new JSONArray(); // array to hold users and passwords as json objects.
            JSONArray input_array = (JSONArray) parser.parse(new FileReader("src/ex1/j.json")); // input file path.

            // run over the input array and hash each password in it.
            // add each user and their hashed password into the users array.            
            for (int i = 0; i < input_array.size(); i++) {
                JSONObject user = (JSONObject) input_array.get(i); // an individual user from the array.
                String username = user.get("username").toString(); // username of the current user.
                int hashed_password = user.get("password").toString().hashCode(); // hashed password of the current user.
                users_array.add(username + ":" + hashed_password); // add user and ahshed password into the users sarray.
            }

            // output object as title 'users' and array of users and their passwords.
            output.put("users", users_array);

            // write the output object into a text file as string.
            try (FileWriter file = new FileWriter("src/ex1/users.txt")) {
                file.write(output.toJSONString());
            }

            // print to the output object to the console.
            System.out.println("\nJSON Object: " + output);

            // handle exceptions.    
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
