var code_c;
var show_num = [];
$(function() {

	draw(show_num);
	$("#canvas").on('click', function() {
		draw(show_num);
	})
});

$(document).on("click", "#getCode", function() {
	if (!/(^1[3|5|8][0-9]{9}$)/.test($("#tel_r").val())) { //值工符合手机的格式
		alert("手机格式不正确");
	} else {
		alert("会向你的手机发送一条验证码，请注意接收");
		$("#getCode").attr("disabled", true);

		// 提交业务

		// 10秒后启用点击事件
		setTimeout(function() {
			$("#getCode").removeAttr("disabled");
		}, 10000);
		$.ajax({
			type: "post",
			url: "http://192.168.8.123:8080/user/getCode",
			async: true,
			contentType: "application/json",
			dataType: "json",
			data: JSON.stringify(GetJsonData_tel()),
			success: function(msg) {
				console.log(msg);
				if (msg.code == 2000) {
					alert(msg.data);
					msg_1 = msg.data;
					console.log(msg_1); //打印验证码
					//						console.log(msg.data); 控制台打印data
					code_c = msg_1;
				};
			},
		});

		function GetJsonData_tel() {
			var json = {
				"tel": $(".mobile").val()
			};
			return json;
		};
	}
});


$(document).on("click", "#registe", function() {

	console.log($("#password_r").val())
	if (!/(^1[3|5|8][0-9]{9}$)/.test($("#tel_r").val())) { //值工符合手机的格式
		alert("手机格式不正确");
	} else if ($("#password_r").val() == "" || $("#password_r").val() != $("#passwordtwo_r").val()) {
		alert("密码不一致或为空");
	} else if (code_c != $("#code").val()) {
		alert("验证码错误，请重新输入！");
	} else if ($("#email_r").val() == "" || !/^([a-zA-Z\d])(\w|\-)+@[a-zA-Z\d]+\.[a-zA-Z]{2,4}$/.test($("#email_r").val())) {
		alert("邮箱格式不正确");
	} else {
		$.ajax({
			type: "post",
			url: "/user/register",
			async: true,
			contentType: "application/json",
			dataType: "json",
			data: JSON.stringify(GetJsonData_tel()),
			success: function(msg) {
				console.log(msg);
				if (msg.code == 2000) {
					alert(msg.message);
					login.style.backgroundColor = "blue";
					body_login.style.display = "block";
					body_registe.style.display = "none";
					registe.style.backgroundColor = "";
				} else {
					alert(msg.message);
				}
			},
		});

		function GetJsonData_tel() {
			var json = {
				"uName": $("#uName_r").val(),
				"tel": $("#tel_r").val(),
				"password": $("#password_r").val(),
				"email": $("#email_r").val()
			};
			return json;
		};
		//    var uName=$("#uName_r").val();
		// var tel=$("#tel_r").val();
		// var password=$("#password_r").val();
		// var passwordtwo=$("#passwordtwo_r").val();
		// var email=$("#email_r").val();
	}
});

$(document).on("click", "#login", function() {
	var val = $("#png_code").val().toLowerCase();
	var num = show_num.join("");
	if (val == num) {
		$.ajax({
			type: "post",
			url: "/user/login",
			async: true,
			contentType: "application/json",
			dataType: "json",
			data: JSON.stringify(GetJsonData_tel()),
			success: function(msg) {
				console.log(msg);
				if (msg.code == 2000) {
					alert(msg.message);
					window.location.href = "./index.html"
				} else {
					alert(msg.message);
				}
			},
		});

		function GetJsonData_tel() {
			var json = {
				"tel": $("#tel").val(),
				"password": $("#pwd").val()
			};
			return json;
		};
		//    var uName=$("#uName_r").val();
		// var tel=$("#tel_r").val();
		// var password=$("#password_r").val();
		// var passwordtwo=$("#passwordtwo_r").val();
		// var email=$("#email_r").val();
	} else {
		alert("验证码错误")
		draw(show_num);
	}

});

function draw(show_num) {
	var canvas_width = $('#canvas').width();
	var canvas_height = $('#canvas').height();
	var canvas = document.getElementById("canvas"); //获取到canvas的对象，演员
	var context = canvas.getContext("2d"); //获取到canvas画图的环境，演员表演的舞台
	canvas.width = canvas_width;
	canvas.height = canvas_height;
	var sCode =
		"a,b,c,d,e,f,g,h,i,j,k,m,n,p,q,r,s,t,u,v,w,x,y,z,A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
	var aCode = sCode.split(",");
	var aLength = aCode.length; //获取到数组的长度
	for (var i = 0; i < 4; i++) { //这里的for循环可以控制验证码位数（如果想显示6位数，4改成6即可）
		var j = Math.floor(Math.random() * aLength); //获取到随机的索引值
		// var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
		var deg = Math.random() - 0.5; //产生一个随机弧度
		var txt = aCode[j]; //得到随机的一个内容
		show_num[i] = txt.toLowerCase();
		var x = 10 + i * 20; //文字在canvas上的x坐标
		var y = 20 + Math.random() * 8; //文字在canvas上的y坐标
		context.font = "bold 23px 微软雅黑";
		context.translate(x, y);
		context.rotate(deg);
		context.fillStyle = randomColor();
		context.fillText(txt, 0, 0);
		context.rotate(-deg);
		context.translate(-x, -y);
	}
	for (var i = 0; i <= 5; i++) { //验证码上显示线条
		context.strokeStyle = randomColor();
		context.beginPath();
		context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
		context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
		context.stroke();
	}
	for (var i = 0; i <= 30; i++) { //验证码上显示小点
		context.strokeStyle = randomColor();
		context.beginPath();
		var x = Math.random() * canvas_width;
		var y = Math.random() * canvas_height;
		context.moveTo(x, y);
		context.lineTo(x + 1, y + 1);
		context.stroke();
	}
}
//得到随机的颜色值
function randomColor() {
	var r = Math.floor(Math.random() * 256);
	var g = Math.floor(Math.random() * 256);
	var b = Math.floor(Math.random() * 256);
	return "rgb(" + r + "," + g + "," + b + ")";
}