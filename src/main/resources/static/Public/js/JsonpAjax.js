

$(function(){
//当键盘键被松开时发送Ajax获取数据
		$('#text').keyup(function(){
			
			var keywords = $(this).val();
			if (keywords=='') { $('#word1').hide(); return };
			$.ajax({
				url: '/c/lz/likeServicesAll/'+keywords,
				type:"get",
				dataType: 'json',
				beforeSend:function(){
					$('#word1').append('<div>正在加载。。。</div>');
				},
				success:function(data){
					
					$('#word1').empty().show();
					if (data=='')
					{
						$('#word1').append('<div class="error">Not find  "' + keywords + '"</div>');
					}
					$.each(data, function(index,temp){
						$('#word1').append('<div class="click_work"><lable>'+  temp.serviceTitle +'</lable> </div>');
					})
				},
				error:function(){
					$('#word1').empty().show();
					$('#word1').append('<div class="click_work">Fail "' + keywords + '"</div>');
				}
			})
		})
//点击搜索数据复制给搜索框
		$(document).on('click','.click_work',function(){
			var word = $(this).children("lable").text();
			$('#text').val(word);
			$('#word1').hide();
			/*$('#texe').trigger('click');触发搜索事件*/
		})

		
		//获得焦点
		$( '#text' ).focus( function(){
			
			if($(this).val()==""){
				$.ajax({
					url: '/c/lz/redisRecommendedTen',
					type:"get",
					dataType: 'json',
					beforeSend:function(){
						$('#word1').append('<div>正在加载。。。</div>');
					},
					success:function(result){
						$('#word1').empty().show();
						
						if (result=='')
						{
							$('#word1').append('<div class="error">Not find  "' + keywords + '"</div>');
						}
						$.each(result, function(index,temp){
							
							$('#word1').append('<div class="click_work"><span style="color:red;font-weight: bold;">HOT</span><lable>'+ temp.servicetitle +'</lable><input type="hidden"  id="stid" value='+temp.stid+' /></div>');
						})
					},
					error:function(){
						$('#word1').empty().show();
						$('#word1').append('<div class="click_work">Fail "' + keywords + '"</div>');
					}
				})

			}
			} );
	})