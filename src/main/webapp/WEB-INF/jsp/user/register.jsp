<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../common/common.jsp"></jsp:include>
<div style="height: 100%">
  <div class="middleDiv">
    <fieldset>
      <div class="am-form-group">
        <label for="loginName" class="label-block">账号</label>
        <input type="text" class="" id="loginName" placeholder="">
      </div>
      <div class="am-form-group">
        <label for="password" class="label-block">密码</label>
        <input type="password" class="" id="password" placeholder="">
      </div>
      <div class="am-form-group">
        <label for="reTypePassword" class="label-block">确认密码</label>
        <input type="password" class="" id="reTypePassword" placeholder="">
      </div>
      <div class="am-form-group">
        <button type="button" id="register" class="am-btn am-btn-secondary">注册</button>
      </div>
    </fieldset>
  </div>
</div>
<script type="text/javascript">
  $(document).ready(function(){
    $('#register').off().on('click',function(){
      var $loginName = $('#loginName').val();
      var $password = $('#password').val();
      $.ajax({
        url:'/webChat/doRegister',
        data : {loginName : $loginName, password : $password},
        dataType : 'json'
      }).done(function(result){
          if(result.statusCode == 'success'){
            window.location.href = '/webChat/login';
          }
      });
    });
    $('#loginName').off().on('click',function(){

    });
  });
</script>