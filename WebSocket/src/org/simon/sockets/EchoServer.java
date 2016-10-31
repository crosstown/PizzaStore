package org.simon.sockets;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo") 
public class EchoServer {
	
	private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
    public void onOpenLeg (Session session){
        System.out.println(session.getId() + " has opened a connection"); 
        sendMessageToAll("User has connected");
        try {
            session.getBasicRemote().sendText("Connection Established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        synchronized(Synchro.getSynchro())    //Added from slides
        {
        sessions.add(session);
        }
    }
 
    
    @OnMessage
    public void onMesgSend(String message, Session session){
    	    	
        System.out.println("Message from " + session.getId() + ": " + message);
        System.out.println("Message from " + session.getUserProperties().get("username") + ": " + message);
        sendMessageToAll(message);
//        try {
//            session.getBasicRemote().sendText(message);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }
    
    private void sendMessageToAll(String message){
    	synchronized (Synchro.getSynchro()) {
			
        for(Session s : sessions){
            try {
       //         s.getBasicRemote().sendText(message);
            	s.getAsyncRemote().sendText(message);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    	}
    }
    
    
 
   
    @OnClose
    public void onTerminate(Session session){
    	synchronized(Synchro.getSynchro())
    	{
    	sessions.remove(session);
    	
        System.out.println("Session " +session.getId()+" has ended");
        sendMessageToAll("User has disconnected");
    	}
    }
    
    @OnError
    public void onBigError(Session session, Throwable thr) {
    System.err.println("Session " + session.getId() + " closed suddenly");
    } 
}


