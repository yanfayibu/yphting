/*底部加侧边悬浮以及一些其他*/

$(document).ready(function() {

			/* ----- 侧边悬浮 ---- */
			$(document).on("mouseenter", ".suspension .a", function() {
				var _this = $(this);
				var s = $(".suspension");
				var isService = _this.hasClass("a-service");
				var isServicePhone = _this.hasClass("a-service-phone");
				var isQrcode = _this.hasClass("a-qrcode");
				if(isService) {
					s.find(".d-service").show().siblings(".d").hide();
				}
				if(isServicePhone) {
					s.find(".d-service-phone").show().siblings(".d").hide();
				}
				if(isQrcode) {
					s.find(".d-qrcode").show().siblings(".d").hide();
				}
			});
			$(document).on("mouseleave", ".suspension, .suspension .a-top", function() {
				$(".suspension").find(".d").hide();
			});
			$(document).on("mouseenter", ".suspension .a-top", function() {
				$(".suspension").find(".d").hide();
			});
			$(document).on("click", ".suspension .a-top", function() {
				$("html,body").animate({
					scrollTop: 0
				});
			});
			$(window).scroll(function() {
				var st = $(document).scrollTop();
				var $top = $(".suspension .a-top");
				if(st > 400) {
					$top.css({
						display: 'block'
					});
				} else {
					if($top.is(":visible")) {
						$top.hide();
					}
				}
			});

		});



		

		/*底部二维码*/

		$(".weibo_icon").hover(function() {
			$(".weibo").fadeIn(500);
			$(".qq,.twitter,.wechat").fadeOut(0);
			$(".code_wrap").css("z-index", 200);
		}, function() {
			$(".weibo").fadeOut(0);
			$(".code_wrap").css("z-index", 50);
		});

		$(".qq_icon").hover(function() {
			$(".qq").fadeIn(500);
			$(".weibo,.twitter,.wechat").fadeOut(0);
			$(".code_wrap").css("z-index", 200);
		}, function() {
			$(".qq").fadeOut(0);
			$(".code_wrap").css("z-index", 50);
		});
		$(".twitter_icon").hover(function() {
			$(".twitter").fadeIn(500);
			$(".weibo,.qq,.wechat").fadeOut(0);
			$(".code_wrap").css("z-index", 200);
		}, function() {
			$(".twitter").fadeOut(0);
			$(".code_wrap").css("z-index", 50);
		});
		$(".wechat_icon").hover(function() {
			$(".wechat").fadeIn(500);
			$(".weibo,.qq,.twitter").fadeOut(0);
			$(".code_wrap").css("z-index", 200);
		}, function() {
			$(".wechat").fadeOut(0);
			$(".code_wrap").css("z-index", 50);
		});
		$(".weibo,.twitter,.wechat").hover(function() {
			$(this).fadeIn(0);
			$(".code_wrap").css("z-index", 200);
		}, function() {
			$(this).fadeOut(500);
			$(".code_wrap").css("z-index", 50);
		});