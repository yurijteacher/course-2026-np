<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2> List categories </h2>
<table>
    <thead>
    <tr>
        <th>id</th>
        <td> img </td>
        <th>name</th>
        <th>description</th>
        <th>image</th>
    </tr>
    </thead>
    <tbody>

    <#if categories??>
        <#list categories as category>
            <tr>
                <td>${category.id}</td>
                <td>
                    <img src="${category.image}" alt="${category.name}" width="50px">
                </td>
                <td>${category.name}</td>
                <td>${category.description}</td>
                <td>${category.image}</td>
            </tr>
        </#list>
    </#if>
    </tbody>

</table>

</body>
</html>