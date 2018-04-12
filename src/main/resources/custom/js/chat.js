/*if(WebSocket){
    var socket = new WebSocket("ws://localhost:9090/websocket");
    socket.onopen = function() {
        console.log("Socket is open");
    };
    socket.onclose = function() {
        console.log("Socket is closed");
    };
    socket.onerror = function(e) {
        console.log("Socket throws exception",e);
    };
    socket.onmessage = function(msg) {
        var data = msg.data;
    };
} else {
    alert("your browser not support WebSockt!");
}*/
var Chat = (function(){
    var $this = null;
    var $defaults = {
        url : '',
        socket : '',
        openCallBack : '',
        closeCallBack : '',
        errorCallBack : '',
        send : '',
        sendCallBack : '',
        onMessageCallBack : ''
    }
    var Chat = function($options){
        $this = this;
        $defaults = $.extend({},$defaults,$options);
        $this.init();
    }
    Chat.prototype.init = function(){
        if(WebSocket){
            $defaults.socket = new WebSocket($defaults.url);
            $this.open();
            $this.error();
            $this.close();
            $this.onmessage();
        } else {
            alert("your browser not support WebSockt!");
        }
    }

    Chat.prototype.onmessage = function() {
        $defaults.socket.onmessage = function(msg) {
            if($defaults.onMessageCallBack){
                $defaults.onMessageCallBack($defaults.socket, msg.data);
            }
        };
    };

    Chat.prototype.open = function(){
        $defaults.socket.onopen = function() {
            console.log("Socket is open");
            if($defaults.openCallBack){
                $defaults.openCallBack($defaults.socket);
            }
        };
    }
    Chat.prototype.error = function(){
        $defaults.socket.onerror = function(e) {
            console.log("Socket throws exception",e);
            if($defaults.errorCallBack){
                $defaults.errorCallBack($defaults.socket, e);
            }
        };
    }
    Chat.prototype.close = function(){
        $defaults.socket.onclose = function() {
            console.log("Socket is closed");
            if($defaults.closeCallBack){
                $defaults.closeCallBack($defaults.socket);
            }
        };
    }
    return Chat;
})(jQuery);