<#import "client/templ-client.ftl" as p>
<@p.pages>
    <h2> Login </h2>
    <form method="post" action="/login">

        <label for="username">User</label>
        <input type="text" name="username" id="username" placeholder="user"><br>
        <label for="password">Pass</label>
        <input type="text" name="password" id="password" placeholder="pass"><br>

        <button type="submit">Add</button>
        <br>
        <a href="/registration">перехід на сторінку реєстрації</a>
    </form>
</@p.pages>