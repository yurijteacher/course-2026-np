<#import "client/templ-client.ftl" as p>
<@p.pages>


    <h2> Categories </h2>

    <div class="row row-cols-2 row-cols-md-3 g-4">

        <#if categories??>

            <#list categories as category>

                <div class="col">
                    <div class="card">
                        <a href="/category/${category.id}">
                        <img src="${category.image}" class="card-img-top" alt="${category.name}">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title">${category.name}</h5>
                            <p class="card-text">${category.description}</p>

                        </div>
                    </div>
                </div>

            </#list>
        </#if>

        <#--    <div class="col">-->
        <#--        <div class="card">-->
        <#--            <img src="/static/images/categories/air.jpg" class="card-img-top" alt="...">-->
        <#--            <div class="card-body">-->
        <#--                <h5 class="card-title">Pro</h5>-->
        <#--                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>-->
        <#--            </div>-->
        <#--        </div>-->
        <#--    </div>-->
        <#--    <div class="col">-->
        <#--        <div class="card">-->
        <#--            <img src="/static/images/categories/pro.jpg" class="card-img-top" alt="...">-->
        <#--            <div class="card-body">-->
        <#--                <h5 class="card-title">iPad</h5>-->
        <#--                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p>-->
        <#--            </div>-->
        <#--        </div>-->
        <#--    </div>-->
        <#--    <div class="col">-->
        <#--        <div class="card">-->
        <#--            <img src="/static/images/categories/pro.jpg" class="card-img-top" alt="...">-->
        <#--            <div class="card-body">-->
        <#--                <h5 class="card-title">iPhone</h5>-->
        <#--                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>-->
        <#--            </div>-->
        <#--        </div>-->
        <#--    </div>-->
    </div>

</@p.pages>
