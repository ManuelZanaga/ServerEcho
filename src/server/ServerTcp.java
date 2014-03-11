package server;

import  java.io. * ;
import  java.net.Socket ;
import  java.util.logging.Level ;
import  java.util.logging.Logger ;


/**
 *
 * @author Manuel
 */
class ServerTcp implements Runnable{
    Socket connection;
    String echo="";
    boolean maiusc=false;
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
                echo= in.readLine();
                
                if(echo.equals("maiuscole on")){
                    maiusc=true;
                    out.println("Maiuscole attivate!");
                }else if(echo.equals("maiuscole off")){
                    maiusc=false;
                    out.println("Maiuscole disattivate!");
                }else{
                    if(maiusc==true){
                    out.println(echo.toUpperCase());  
                    }else{
                    out.println(echo); 
                    }
                }
                Thread.sleep(1000);
                
        }        
        }catch (IOException ex){} catch (InterruptedException ex) {
            Logger.getLogger(ServerTcp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}