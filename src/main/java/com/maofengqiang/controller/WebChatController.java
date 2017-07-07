package com.maofengqiang.controller;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/webChat")
public class WebChatController {
	
	//给连接上的客户端进行命名
	private static final String GUEST_PERFIX = "Guest";
	//自增的客户端连接数（计数器）
	private static final AtomicInteger connectNum = new AtomicInteger(0);
	//客户端连接集合
	private static final Set<WebChatController> connections = new CopyOnWriteArraySet<>();
	//客户端连接会话
	private Session session=null;
	
	private String gusetName;
	
	public WebChatController() {
		//给每一个连接上的客户端进行命名
		gusetName = GUEST_PERFIX + connectNum.getAndIncrement();
	}
	
	/**客户端连接方法*/
	@OnOpen
	public void onOpen(Session session){
		this.session=session;
		System.out.println("connection from"+session.getId());
		connections.add(this);
		String message = String.format("* %s %s", gusetName, "has joined.");
		broadcast(message);
	}
	
	@OnMessage
	public void onMessage(String message){
		// Never trust the client
    	// TODO: 过滤输入的内容
		broadcast(message);
	}
	
	@OnClose
	public void onClose(Session session, CloseReason reason){
		connections.remove(this);
        String message = String.format("* %s %s",gusetName, "has disconnected.");
        broadcast(message);
		System.out.println(String.format("Session %s closed because of %s", session.getId(), reason));	
	}
	
	@OnError
	public void onError(Throwable t){
		 System.out.println("Chat Error: " + t.toString());
	}
	
	//广播方法
	public static void broadcast(String message){
		//遍历客户端
		for(WebChatController client : connections){
			try {
				synchronized(client){
					client.session.getBasicRemote().sendText(message);					
				}
			} catch (IOException e) {
				connections.remove(client);
				try {
					client.session.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//TODO 暂不处理
				}
				String msg ="客户端连接断开:"+client.gusetName;
				broadcast(msg);
			}
		}
	}
}
