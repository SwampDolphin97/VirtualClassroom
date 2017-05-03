/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualclassroom;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kartikey
 */
public class Faculty {
         public void FacultyConnection() 
         {
             try {
                 ServerSocket sersock = new ServerSocket(3000);
                 System.out.println("Faculty is online!");
                 Socket sock = sersock.accept( );
                 // reading from keyboard (keyRead object)
                 BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
                 // sending to client (pwrite object)
                 OutputStream ostream = sock.getOutputStream();
                 PrintWriter pwrite = new PrintWriter(ostream, true);
                 // receiving from server ( receiveRead  object)
                 InputStream istream = sock.getInputStream();
                 BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
                 String receiveMessage, sendMessage;
                 while(true)
                 {
                     if((receiveMessage = receiveRead.readLine()) != null)
                     {
                         System.out.println(receiveMessage);
                     }
                     sendMessage = keyRead.readLine();
                     pwrite.println(sendMessage);
                     pwrite.flush();
                 }      } catch (IOException ex) {
                 Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE, null, ex);    
             }
         }
    public static void main(String[] args) throws Exception
  {
               Faculty obj = new Faculty();
               obj.FacultyConnection();
    }                    

    
}
