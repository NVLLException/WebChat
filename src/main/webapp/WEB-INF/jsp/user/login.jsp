<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    </fieldset>
  </div>
</div>
<jsp:include page="../common/common.jsp"></jsp:include>
<script type="text/javascript">
  $('#loginName').change(function(){
    $.ajax({
      url: '',
      data: {loginName: this.value},
      dataType: 'json',
      type: 'post'
    }).done(function(result){
      if(result.statusCode == "error"){
      }
    });
  });
</script>
<style>
  .middleDiv{
    max-width: 25%;
    min-width:25%;
    min-height: 60%;
    max-height: 60%;
    margin: auto;
    margin-top: 10%;
    box-shadow:0 0 2px 2px grey;
  }
</style>