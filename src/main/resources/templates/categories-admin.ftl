<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Categories</title>
    <link rel="stylesheet" type="text/css" href="/static/css/my.css">
</head>
<body>

<div class="container">
    <h1>Заголовок</h1>
    <h2>Заголовок</h2>
    <h3>Заголовок</h3>
    <p>Text text text <b>Жирним</b> <i>Курсив</i> <u>Підкреслити</u></p>
</div>

<h2>Table</h2>
<table border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>1</td>
        <td>C#</td>
        <td>asd asd</td>
    </tr>
    <tr>
        <td>2</td>
        <td>Java</td>
        <td>asd asd</td>
    </tr>
    <tr>
        <td>3</td>
        <td>Java Script</td>
        <td>asdf asd</td>
    </tr>
    </tbody>
</table>

<div class="cards">
    <div class="box">
        <h2>List</h2>
        <ul>
            <li>C#</li>
            <li>Java</li>
            <li>Ruby</li>
        </ul>
    </div>

    <div class="box">
        <h2> List2 </h2>
        <ol>
            <li>C#</li>
            <li>C</li>
            <li>C++</li>
        </ol>
    </div>
</div>

<h2> Image</h2>
<img src="/static/images/user.jpg" alt="user" width="150px">

<h2> Form Auth </h2>
<form method="post" action="/login">
    <fieldset>
        <legend>Form Auth</legend>


        <label for="username">User</label>
        <input type="text" name="username" id="username" placeholder="login"><br>
        <label for="password">Pass</label>
        <input type="password" name="password" id="password" placeholder="pass"><br>

        <label for="age">Age</label>
        <input type="number" id="age" min="1" max="120" step="1" value="20">

        <input type="submit" value="add"/>
        <button type="submit">Add</button>
    </fieldset>
</form>

<h2> Select </h2>
<select name="prof">
    <option value="student" selected>Student</option>
    <option value="teacher">Teacher</option>
    <option value="programmer">Programmer</option>
</select>

<h2> Select multiple </h2>
<select name="prof" multiple>
    <option value="student">Student</option>
    <option value="teacher">Teacher</option>
    <option value="programmer">Programmer</option>
</select>

<h2> Radio </h2>
<input type="radio" name="gender" value="man" checked> Чоловік <br>
<input type="radio" name="gender" value="woman"> Жінка <br>

<a href="http://localhost:8080/categories">Перехід на сторінку категорій</a>

<p>Text</p>


</body>
</html>