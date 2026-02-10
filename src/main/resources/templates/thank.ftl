<#import "client/templ-client.ftl" as p>
<@p.pages>
    <h3>Thank you for the buy!</h3>
    <p><#if info??> ${info}</#if></p>
    <p>Ваше замовлення: <#if id_order??>${id_order}</#if></p>

</@p.pages>