$("#confirm").click(function() {
	if (typeof (WebSocket) == "undefined") {
		alert("您的浏览器不支持WebSocket");
	}
	alert("jquery功能有效");
});


var socket;
if (typeof (WebSocket) == "undefined") {
	alert("您的浏览器不支持WebSocket");
}

$("#btnConnection").click(function() {
	//实现化WebSocket对象，指定要连接的服务器地址与端口
	socket = new WebSocket("ws://localhost:8080/push");
	//打开事件
	socket.onopen = function() {
		alert("Socket 已打开");
		//socket.send("这是来自客户端的消息" + location.href + new Date());
	};
	//获得消息事件
	socket.onmessage = function(msg) {
		alert(msg.data);
	};
	//关闭事件
	socket.onclose = function() {
		alert("Socket已关闭");
	};
	//发生了错误事件
	socket.onerror = function() {
		alert("发生了错误");
	}
});

//发送消息
$("#btnSend").click(function() {
	socket.send("这是来自客户端的消息" + location.href + new Date());
});

//关闭
$("#btnClose").click(function() {
	socket.close();
});

