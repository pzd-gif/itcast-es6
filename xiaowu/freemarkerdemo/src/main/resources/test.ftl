<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门demo</title>
</head>
<body>
<#--我只是一个注释，我不会有任何输出  -->
${name},你好。${message}<br>

<#assign linkman="周先生">
联系人：${linkman}<br>

<#assign info={"mobile":"13301231212","address":"北京市昌平区王府街"}>
电话:${info.mobile} 地址:${info.address}

</body>
</html>