 //提示框
    function showTool(str){
        var ele =  document.getElementById("tooltip");
        ele.innerHTML = str;
        ele.style.display="";
        setTimeout(hideTool,3000);
    }
    function hideTool(str){
        var ele =  document.getElementById("tooltip");
        ele.innerHTML = str;
        ele.style.display="none";
    }
    
 //退出系统
    function signout(){
    	qikoo.dialog.confirm('确定要退出吗？',function(){
    			alert("退出成功");
    			 			 
            },function(){
    			//alert("取消啦！");
    	});
    }
    
  