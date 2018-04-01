if(WebSocket){
    var socket = new WebSocket("ws://localhost:8080/websocket");
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
}