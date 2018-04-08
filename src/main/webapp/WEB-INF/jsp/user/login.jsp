<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<style>
  .middleDiv{
    max-width: 25%;
    min-width:25%;
    max-height: 60%;
    margin: auto;
    margin-top: 10%;
    box-shadow:0 0 2px 2px grey;
  }
</style>
<div style="height: 100%">
  <div class="middleDiv">
    <fieldset>
      <div class="am-form-group">
        <label for="loginName">账号</label>
        <input type="text" class="" id="loginName" placeholder="输入登录账号">
      </div>
      <div class="am-form-group">
        <label for="password">密码</label>
        <input type="password" class="" id="password" placeholder="输入密码">
      </div>
      <div class="am-form-group">
        <button type="button" id="login" class="am-btn am-btn-secondary">登录</button>
      </div>
    </fieldset>
  </div>
</div>
<jsp:include page="../common/common.jsp"></jsp:include>
<script type="text/javascript">
  $(document).ready(function(){
    $('#loginName').change(function(){
      $.ajax({
        url: '/webChat/validateLoginName',
        data: {loginName: this.value},
        dataType: 'json',
        type: 'post'
      }).done(function(result){
        if(result.statusCode == "error"){

        }
      });
    });
    $('#login').off().on('click', function(){
      var $loginName = $('#loginName').val();
      var $password = $('#password').val();
      $.ajax({
        url: '/webChat/validateLoginInfo',
        data: {loginName: $loginName, password: $password},
        dataType: 'json',
        type: 'post'
      }).done(function(result){
        if(result.statusCode == "error"){

        }
      });
    });
  });
</script>