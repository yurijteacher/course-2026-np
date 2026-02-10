<#import "client/templ-client.ftl" as p>
<@p.pages>
    <h3 class="text-center"> Login </h3>

    <div class="row justify-content-center">
        <div class="col-7">


            <form method="post" action="/login" class="card p-4 shadow">

                <label for="username">User</label>
                <input type="text" name="username" id="username" placeholder="user"><br>
                <label for="password">Pass</label>
                <input type="text" name="password" id="password" placeholder="pass"><br>

                <button class="btn btn-success" type="submit">Add</button>
                <br>
                <a href="/registration">перехід на сторінку реєстрації</a>
            </form>
        </div>
    </div>
</@p.pages>