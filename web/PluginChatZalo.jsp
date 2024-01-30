<%-- 
    Document   : PluginChatZalo
    Created on : Jan 30, 2024, 8:12:01 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://static.zalo.me/z/s/zalo-sdk.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
    <div id="zalo-chat-widget"></div>

    <script>
        var options = {
            width: "350",
            height: "420",
            zalo_app_id: "3298570899247383438",
            embed_type: "floating",
            embed_content: {
                "button": "Gửi tin nhắn",
                "title": "Liên hệ qua Zalo",
                "description": "Chúng tôi sẽ trả lời bạn sớm nhất có thể",
            }
        };
        new ZaloChatWidget('3298570899247383438', options);
    </script>
</body>
</html>
