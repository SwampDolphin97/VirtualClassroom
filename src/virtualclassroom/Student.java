/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualclassroom;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kartikey
 * 
 */
public class Student {
  public void studentConnection()
  {
      try {
          Socket sock = new Socket("127.0.0.1", 3000);
          // reading from keyboard (keyRead object)
          BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
          // sending to client (pwrite object)
          OutputStream ostream = sock.getOutputStream();
          PrintWriter pwrite = new PrintWriter(ostream, true);
          // receiving from server ( receiveRead  object)
          InputStream istream = sock.getInputStream();
          BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
          System.out.println("What is your question?");
          String receiveMessage, sendMessage;
          while(true)
          {
              sendMessage = keyRead.readLine();  // keyboard reading
              pwrite.println(sendMessage);       // sending to server
              pwrite.flush();                    // flush the data
              if((receiveMessage = receiveRead.readLine()) != null) //receive from server
              {
                  System.out.println(receiveMessage); // displaying at DOS prompt
              }
          }
      } catch (IOException ex) {
          Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);               
      }
    } 

    public static void main(String args[]) throws Exception
   {
     new Student().studentConnection();
  }  
}
