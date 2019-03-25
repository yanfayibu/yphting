
	//webscoket
	if (window.WebSocket) {
		
		
var mysocket = new WebSocket("ws://127.0.0.1:1001/ws/news");

mysocket.onopen = function() {
	
	console.debug('建立连接');
}
mysocket.onclose = function() {
	console.debug('关闭连接');
}
mysocket.onerror = function() {
	console.debug('通讯异常');
}

mysocket.onmessage = function(e) {
	if(e.data=="reload"){
		
		
		setTimeout(function(){
			unreadinfo();
			//弹出提示框
	$.messager.lays(400, 200);
	$.messager.show(0, '<h3 style="color:red">你有新的消息，请注意查收！</h3>			');
	},1000);
	
		//自动播放
		var myAuto = document.getElementById('myaudio');
	    myAuto.src="/Public/music/你有新的短消息-铃声-4573787.mp3";
		
		
	}
}
} else {
alert("不支持WebSocket");
}	
//查询未读信信息
function unreadinfo(){
	$.ajax({
		type:"get",
		url:"/c/lz/user/QueryUserunread",
		async:true,
		success:function(result){
		
			
			if(result!=0){
				$("#eif").show();
			}
			$("#count").text(result);
		}
	});
}




