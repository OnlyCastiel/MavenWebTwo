package com.maofengqiang.controller;

import java.io.IOException;

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
	
	/**
	 * 在这个端点一个新的连接建立时被调用。参数提供了连接的另一端的更多细节
	 * @param session 表明两个WebSocket端点对话连接的另一端，可以理解为类似HTTPSession的概念。
	 * @throws IOException
	 */
	 @OnOpen
	 public void onOpen(Session session) throws IOException {
	 //以下代码省略...
		 System.out.println("Connected ... " + session.getId());
	 }
	 
	 
	 /**
	  * 接收传入的WebSocket信息，这个信息可以是文本格式，也可以是二进制格式。
	  * @param message
	  * @return
	  */
	 @OnMessage
	 public String onMessage(String message) {
	 //以下代码省略...
		 System.out.println("message ..."+message);
		 return "服务器的message消息";
	 }

	 /**
	  * MaxMessageSize属性可以被用来定义消息字节最大限制，在示例程序中，
	  * 如果超过6个字节的信息被接收，就报告错误和连接关闭。
	  * @param t
	  */
//	 @Message(maxMessageSize=6)
//	 public void receiveMessage(String s) {
//	 //以下代码省略...
//	 } 

	 @OnError
	 public void onError(Throwable t) {
		 t.printStackTrace();
	 }
	 
	 /**
	  * 在连接被终止时调用
	  * @param session
	  * @param reason
	  */
	 @OnClose
	 public void onClose(Session session, CloseReason reason) {
	 //以下代码省略...
		 System.out.println(String.format("Session %s closed because of %s", session.getId(), reason));
	 } 
}
