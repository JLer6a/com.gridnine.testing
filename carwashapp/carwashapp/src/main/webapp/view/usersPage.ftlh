<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Email</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>

            </tr>
        </#list>
    </table>

</div>


<div>
    <form action="/users" method="post">
        <input type="text" name="email">
        <input type="text" name="name">
        <input type="password" name="password">
        <input type="submit">
    </form>
</div>


</body>
</html>