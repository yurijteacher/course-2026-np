<#import "client/templ-client.ftl" as p>
<#import "/spring.ftl" as s>
<@p.pages>


    <h2> Registration Form</h2>
    <@s.bind "users"/>

    <form method="post" action="/registration">
        <fieldset name="Form Registration">

        <#if info??> ${info} </#if>
        <label>Username *</label>
        <@s.formInput "users.username"/><br>
        <@s.showErrors "<br>"/><br>

        <label>Password *</label>
        <@s.formInput "users.password"/><br>
        <@s.showErrors "<br>"/><br>

        <@s.bind "clients"/>
        <label>firstName *</label>
        <@s.formInput "clients.firstName"/><br>
        <@s.showErrors "<br>"/><br>

        <label>last Name * </label>
        <@s.formInput "clients.lastName"/><br>
        <@s.showErrors "<br>"/><br>

        <label>email * </label>
        <@s.formInput "clients.email"/><br>
        <@s.showErrors "<br>"/><br>


        <label>phone * </label>
        <@s.formInput "clients.phone"/><br>
        <@s.showErrors "<br>"/><br>

        <label>age * </label>
        <@s.formInput "clients.age"/><br>
        <@s.showErrors "<br>"/><br>

        <button type="submit">add</button>
        </fieldset>
    </form>

</@p.pages>