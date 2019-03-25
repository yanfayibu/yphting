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
    		$.ajax("/c/lz/user/loginout",{
				type:"GET",
				dataType:"text",
				success:function(result){
					
					
					if(result=="true"){
						
					window.location.href="/c/tsy/gologin";
						
					}
					
					else{
						showTool("系统异常！")
					}
					
				}
			}); 			 
            },function(){
    			//alert("取消啦！");
    	});
    }
    
  