<html>
<head>
<title>"Welcome to fruit picker"</title>
</head>
<body>
<form action="fruit_picker" method="POST">
<#list fruits as fruit>
<input type="radio" name="fruit" value="${fruit}" >${fruit}</input>
</#list>
<input type="submit" >submit</input>
</form>
</body>
</html>