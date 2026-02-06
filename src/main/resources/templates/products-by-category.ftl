<#import "client/templ-client.ftl" as p>
<@p.pages>

    <h2> List products by category </h2>

    <div class="row row-cols-2 row-cols-md-4 g-4">

    <#if products??>

        <#list products as product>

            <div class="col">
                <div class="card">
                        <img src="${product.image}" class="card-img-top" alt="${product.name}">
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.description}</p>

                        <form action="/addItemFromCart" method="post">
                        <input type="hidden" name="id" value="${product.id}">

                        <input name="quantity" type="number" value="1" min="1" maxlength="1000" step="1">
                        <p><b>Price:</b> ${product.price}</p>

                        <button class="btn btn-success" type="submit">Add to cart</button>
                        </form>

                    </div>
                </div>
            </div>

        </#list>
    </#if>
    </div>




</@p.pages>