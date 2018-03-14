$(document).ready(function(){  
    //全局ajax开始事件  
    $("#msg").ajaxStart(function(){  
        $(this).html("正在登陆系统...")  
    })  
  
    $("#btnLogin").on('click',function(){ 
        var userName = document.getElementById('userName').value
        var password = document.getElementById('password').value
        if(userName==""){  
            alert("用户名不能为空")  
            userName.focus()  
            return false  
        }else if(password==""){  
            alert("密码不能为空")  
            password.focus()  
            return false  
        }else{  
        	$("#msg").html("正在登录中...")  
            userLogin(userName,password)  
        }  
    })  
})  
  
//ajax登陆处理  
function userLogin(userName,password){  
    $.ajax({  
        type:"post",  
        url:"/DataSourceMSystem/loginValidate",  
        data:{"userName":userName,"password":password},  
        dataType:'text',  
        success:function(data){ 
        	
            if(data == "success"){  
                window.location.href="/DataSourceMSystem/index";  
            }else{  
                $("#msg").html("用户名或密码错误，请重新登录")  
                return false  
            }  
        }  
        
    })  
}  