$(function() {

			//输入开始日期和结束日期
			//定位div上的id，不是input上id，否则后面两个小图标会失效
			$("#startdiv").datetimepicker({
				pickerPosition: "bottom-left",
				language: 'zh-CN',
				format: "yyyy-mm-dd hh:mm:ss",
				weekStart: 1,
				todayBtn: 1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0
			});
			$("#endDiv").datetimepicker({
				pickerPosition: "bottom-left",
				language: 'zh-CN',
				format: "yyyy-mm-dd hh:mm:ss",
				weekStart: 1,
				todayBtn: 1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0
			});

			$('#startdiv').unbind("change");
			$('#startdiv').change(function() {
				$('#endDiv').datetimepicker('setStartDate', $("#start").val());
			});
			$('#endDiv').unbind("change");
			$('#endDiv').change(function() {
				$('#startdiv').datetimepicker('setEndDate', $("#end").val());
			});
		});

		function clearForm() {
			$('#start').val('');
			$('#end').val('');
			  //用于解决清空后，前后日期还会关联的问题
			  //$('.input-group-addon:has(span.glyphicon-remove)').click();
		}