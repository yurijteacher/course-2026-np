<#import "client/templ-client.ftl" as p>
<@p.pages>

    <h3> Order </h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>first Name</th>
            <th>last Name</th>
            <th>phone</th>
            <th>email</th>
        </tr>
        </thead>
        <tbody>
        <#if client??>
            <tr>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.phone}</td>
                <td>${client.email}</td>
            </tr>
        </#if>
        </tbody>
    </table>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>image</th>
            <th>name</th>
            <th>quantity</th>
            <th>price</th>
            <th>value</th>
        </tr>
        </thead>
        <tbody>
        <#if cart.getCart()??>
            <#list cart.getCart() as itemCart>
                <tr>
                    <td>${itemCart.products.id}</td>
                    <td><img src="${itemCart.products.image}" alt="${itemCart.products.name}" width="50px"></td>
                    <td>${itemCart.products.name}</td>
                    <td>${itemCart.quantity}</td>
                    <td>${itemCart.products.price}</td>
                    <td>${itemCart.quantity * itemCart.products.price}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <p>Кількість нуменклатурних позицій: ${el}</p>
    <p>Вартість замовлення: ${value} грн.</p>


    <form action="/buy" method="post">

        <label for="delivery">Delivery</label><br>
        <select name="delivery" id="delivery">
            <option value="1">Самовивіз</option>
            <option value="2">Нова пошта</option>
        </select><br>
        <br>

        <label for="payment">Payment</label><br>
        <select name="payment" id="payment">
            <option value="1">Готівка</option>
            <option value="2">Оплата картою</option>
        </select><br>
        <br>

        <button type="submit" class="btn btn-primary"> Buy</button>
    </form>
</@p.pages>