<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:include page="../common/common.jsp"></jsp:include>
<script src="/js/chat.js" type="text/javascript"></script>
<div data-am-widget="tabs" class="am-tabs am-tabs-default chatDiv">
    <div class="am-tabs-bd" style="height: 70%">
        <div friends class="am-tab-panel am-active">
            <div style="width: 40%">
            <ul class="am-list admin-sidebar-list" id="collapase-nav-1">
                <li class="am-panel">
                    <a data-am-collapse="{parent: '#collapase-nav-1', target: '#user-nav'}">
                        <i class="am-icon-users am-margin-left-sm"></i> 组1 <i class="am-icon-angle-right am-fr am-margin-right"></i>
                    </a>
                    <ul class="am-list am-collapse admin-sidebar-sub" id="user-nav">
                        <li><a href="#/userAdd"><i class="am-icon-user am-margin-left-sm"></i> aaa </a></li>
                        <li><a href="#/userList/0"><i class="am-icon-user am-margin-left-sm"></i> bbb </a></li>
                    </ul>
                </li>
            </ul>
            </div>
        </div>
        <div chat class="am-tab-panel">
            <div class="am-panel am-panel-default" style="height: 85%;">
                <div class="am-panel-bd" style="height: 65%">
                </div>
                <div class="am-panel-hd" style="height: 30px"></div>
                <div class="am-panel-bd" style="height: 30%;padding: 0px 0px 0px 0px;">
                    <textarea name="message" style="min-width: 100%;max-width: 100%;min-height: 100%;max-height: 100%"></textarea>
                </div>
            </div>
            <div class="am-form-group" style="width: 100%">
                <button type="button" class="am-btn am-btn-secondary am-btn-sm" id="send" style="width: 25%;float: right;">发送</button>
            </div>
        </div>
        <div my class="am-tab-panel">
        </div>
    </div>
    <ul class="am-tabs-nav am-cf">
        <li class="am-active"><a href="[friends]">好友</a></li>
        <li class=""><a href="[chat]">聊天</a></li>
        <li class=""><a href="[my]">我的</a></li>
    </ul>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        var socket = null;
        var $options = {
            url : 'ws://localhost:9090/websocket',
            openCallBack : openCallBack
        }
        var chat = new Chat($options);
        function openCallBack($socket){
            socket = $socket;
        }
        $('#send').off().on('click',function(){
            var message = $('[name="message"]').val();
            socket.send(message);
        });
    });
</script>