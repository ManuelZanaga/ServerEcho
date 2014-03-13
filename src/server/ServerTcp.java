package server;

import  java.io. * ;
import  java.net.Socket ;
import  java.util.logging.Level ;
import  java.util.logging.Logger ;


/**
 *
 * @author Manuel
 */
class ServerTcp extends Thread{
    Socket connection;
    String echo="";
    boolean maiusc=false;
    String check;
    public ServerTcp(Socket accept) {
        connection=accept;
    }    
    @Override
    public void run() {
        System.out.println("Apertura porta in corso...");
        
        try{
        BufferedReader  in  =  new  BufferedReader ( new InputStreamReader ( connection . getInputStream ()));
        PrintWriter  out  =  new  PrintWriter ( new  OutputStreamWriter ( connection.getOutputStream ()),  true );
        while(!echo.equals("fine")){
            check= in.readLine();
            echo= in.readLine();
                if(check.equals("maiuscole on")){
                    out.println(echo.toUpperCase());
                }else if(check.equals("maiuscole off")){
                    out.println(echo);
        }
        Thread.sleep(1000);             
        }        
        }catch (IOException ex){} catch (InterruptedException ex) {
            Logger.getLogger(ServerTcp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}