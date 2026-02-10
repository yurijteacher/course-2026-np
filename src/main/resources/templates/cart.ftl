<#import "client/templ-client.ftl" as p>
<@p.pages>

    <h2> Cart </h2>

    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>image</th>
            <th>name</th>
            <th>quantity</th>
            <th>price</th>
            <th>value</th>
            <th>update</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <#if cart.cart??>
            <#list cart.cart as itemCart>
                <tr>
                    <form method="post" action="/updateItemFromCart">
                        <input type="hidden" name="id" value="${itemCart.products.id}">

                        <td>${itemCart.products.id}</td>
                        <td><img src="${itemCart.products.image}" alt="${itemCart.products.name}" width="50"></td>
                        <td>${itemCart.products.name}</td>
                        <td><input type="number" min="1" step="1" name="quantity" value="${itemCart.quantity}"></td>
                        <td>${itemCart.products.price}</td>
                        <td>${itemCart.quantity * itemCart.products.price}</td>
                        <td>
                            <button type="submit">Update</button>
                        </td>
                    </form>
                    <td>
                        <form method="post" action="/deleteItemFromCart">
                            <input type="hidden" name="id" value="${itemCart.products.id}">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <p> Total Value: ${value}</p>
    <p> Sum el from cart: ${el} </p>

    <form action="/deleteAllItemFromCart" method="post">
        <button type="submit" class="btn btn-primary">Видалити всі дані і повернутись до купівля продукції</button>
    </form>


    <form action="/order" method="get">
        <button type="submit" class="btn btn-primary">Перейти до оформлення замовлення</button>
    </form>

</@p.pages>