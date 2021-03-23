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
            <th>Number</th>
            <th>Time</th>
            <th>Service</th>
        </tr>
        <#list cars as car>
        <tr>
            <td>${car.id}</td>
            <td>${car.number}</td>
            <td>${car.time}</td>
            <td>${car.service}</td>
        </tr>
    </#list>
    </table>

</div>


<div>
    <form action="/car" method="post">
        <input type="text" name="number">
        <input type="text" name="time">
        <input type="text" name="service">
        <input type="submit">
    </form>
</div>

</body>
</html>