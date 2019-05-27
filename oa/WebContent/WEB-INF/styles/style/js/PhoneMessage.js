//短信验证码    
var InterValObj; //timer变量，控制时间      
var count = 60; //间隔函数，1秒执行      
var curCount;//当前剩余秒数      
var code = ""; //验证码      
var codeLength = 6;//验证码长度    



function sendMessage(){     
    curCount = count;      
    var jbPhone = $("#telephonename").val();     
    
    var jbPhoneTip = $("#telephonenameTip").text();      
    if (jbPhone != "") {      
      /*   if(jbPhoneTip == "√" || jbPhoneTip == "√ 短信验证码已发到您的手机,请查收"){  */     
            // 产生验证码      
            for ( var i = 0; i < codeLength; i++) {      
                code += parseInt(Math.random() * 9).toString();      
            }  
            alert(code); 
            // 设置button效果，开始计时      
            $("#btnSendCode").attr("disabled", "true");      
            $("#btnSendCode").val("请在" + curCount + "秒内输入验证码");      
            InterValObj = window.setInterval(SetRemainTime, 1000); // 启动计时器，1秒执行一次      
            // 向后台发送处理数据      
            
            $.ajax({ 
            	url:"${ctx}/tree/phone", // 目标地址     
                type: "get", // 用POST方式传输      
                 // 数据格式:JSON
                async:false,
                data:{jbPhone:jbPhone,code:code},      
                error: function (XMLHttpRequest, textStatus, errorThrown) { 
                },      
                success: function (data){       
                    data = parseInt(data, 10);      
                    if(data == 1){      
                        $("#telephonenameTip").html("<font color='#339933'>√ 短信验证码已发到您的手机,请查收</font>");      
                    }else if(data == 0){      
                        $("#telephonenameTip").html("<font color='red'>× 短信验证码发送失败，请重新发送</font>");      
                        return false;    
                    }else if(data == 2){      
                        $("#telephonenameTip").html("<font color='red'>× 该手机号码今天发送验证码过多</font>");      
                    }      
                }      
            });      
       /*  }  */     
    }else{      
        $("#telephonenameTip").html("<font color='red'>× 手机号码不能为空</font>");      
    }      
}    
      
//timer处理函数      
function SetRemainTime() {      
    if (curCount == 0) {                      
        window.clearInterval(InterValObj);// 停止计时器      
        $("#btnSendCode").removeAttr("disabled");// 启用按钮      
        $("#btnSendCode").val("重新发送验证码");      
        code = ""; // 清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
    }else {      
        curCount--;      
        $("#btnSendCode").val("请在" + curCount + "秒内输入验证码");      
    }      
}      
      
$(function(){      
    $("input",$("#codename").next("span")).blur(function(){      
        var SmsCheckCodeVal = $("#codename").val();      
        // 向后台发送处理数据      
        $.ajax({      
            url : '${ctx}/tree/checkCode',       
            data : {SmsCheckCode : SmsCheckCodeVal},       
            type : "POST",       
            dataType : "text",       
            success : function(data) {      
                data = parseInt(data, 10);      
                if (data == 1) {      
                    $("#codenameTip").html("<font color='#339933'>√</font>");      
                } else {      
                    $("#codenameTip").html("<font color='red'>× 短信验证码有误，请核实后重新填写</font>");    
                        
                }      
            }      
        });     
        return true;        
    });      
});    