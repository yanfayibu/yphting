$(".top_right").html("");
<<<<<<< HEAD
$.getJSON("/c/szy/user/queryAUser",function(data){
=======
$.getJSON("/c/zrb/user/queryAUser",function(data){
>>>>>>> branch 'master' of https://github.com/yanfayibu/yphting.git
	if(data==null){
		$(".top_right").append($('<a href="/szy-login.html">登录</a><span class="ht_line"></span><a href="/szy-zuce.html">注册</a>'));
	}else{
		$(".top_right").append($('<a href="/c/lhy/center/home">'+data.username+'</a> <span class="ht_line"></span><a href="/c/szy/user/close">退出</a><span class="ht_line"></span><a href="/xx-xtxx.html"><img src="/Public/images/e_i.png" alt=""></a>'));
	}
})

