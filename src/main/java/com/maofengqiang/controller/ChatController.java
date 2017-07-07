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

/**
 * @ServerEndpoint("/push")的annotation注释端点表示将WebSocket服务端运行在
 * ws://[Server端IP或域名]:[Server端口]/项目/push的访问端点，
 * 客户端浏览器已经可以对WebSocket客户端API发起HTTP长连接了
 * @author Administrator
 *
 */
@ServerEndpoint(value = "/push")
public class ChatController {
	   private String currentUser;
	    
	    //连接打开时执行@PathParam("user") String user,
	    @OnOpen
	    public void onOpen( Session session) {
	        //currentUser = user;
	        System.out.println("Connected ... " + session.getId());
	    }

	    //收到消息时执行
	    @OnMessage
	    public String onMessage(String message, Session session) {
	        System.out.println(currentUser + "：" + message);
	        return currentUser + "：" + message;
	    }

	    //连接关闭时执行
	    @OnClose
	    public void onClose(Session session, CloseReason closeReason) {
	        System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
	    }

	    //连接错误时执行
	    @OnError
	    public void onError(Throwable t) {
	        t.printStackTrace();
	    }
}
