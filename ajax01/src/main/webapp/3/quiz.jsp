<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>quiz.jsp</title>
</head>
    <script type="text/javascript">
        var xhr = null;
        function getResult() {
            var num1 = document.getElementById("num1").value;
            var num2 = document.getElementById("num2").value;
            var oper = document.getElementById("oper").value;
            xhr = new XMLHttpRequest();
            xhr.onreadystatechange = callback;
            xhr.open('get', 'calc.jsp?num1=' + num1 + '&num2=' + num2 + '&oper='+oper, true);
            xhr.send();
        }

        function callback() {
        	 if (xhr.readyState == 4 && xhr.status == 200) {
                 var data = xhr.responseXML;
                var num1 = data.getElementsByTagName("num1")[0].firstChild.nodeValue;
                var num2 = data.getElementsByTagName("num2")[0].firstChild.nodeValue;
                var num3 = data.getElementsByTagName("num3")[0].firstChild.nodeValue;
                var oper = data.getElementsByTagName("oper")[0].firstChild.nodeValue;
                var div = document.getElementById("result");
                div.innerHTML=num1+oper+num2 +"="+num3;
                
            }
        }
    </script>
<body>
<p>두 정수를 입력 후 계산 버튼을 누르면 ajax를 사용해서 두수합을 dix#result에 출력되도록 해보세요</p>
<input type="text" id="num1" size="10">
<select id = "oper">
    <option value="1">+</option>
    <option value="2">-</option>
    <option value="3">*</option>
    <option value="4">/</option>
</select>
<input type="text" id="num2" size="10">
<input type="button" value="계산" onclick="getResult()">
<div id="result"></div>
</body>
</html>
