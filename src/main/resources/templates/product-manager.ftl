<#import "manager/templ-manager.ftl" as p>

<@p.pages>
    <h2> Product Manager </h2>

    <h2> List Products</h2>
    <table class="table">
        <thead>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>category.name</th>
        <th>price</th>
        <th>image</th>
        </thead>
        <tbody>

        <#if products??>
            <#list products as product>
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.category.name}</td>
                    <td>${product.price}</td>
                    <td>${product.image}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


    <h2> Update/Delete Product</h2>
    <table class="table">
        <thead>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>category.name</th>
        <th>price</th>
        <th>image</th>
        <th>update</th>
        <th>delete</th>


        </thead>
        <tbody>

        <#if products??>
            <#list products as product>
                <tr>
                    <form action="/updateProduct" method="post">
                        <td><input type="text" name="id" value="${product.id}"/></td>
                        <td><input type="text" name="name" value="${product.name}"/></td>
                        <td><input type="text" name="description" value="${product.description}"/></td>
                        <td>
                            <input type="text" name="category" value="${product.category.id}"/>
                        </td>
                        <td><input type="number" step="0.1" min="0" name="price" value="${product.price?c}"/></td>
                        <td><input type="text" name="image" value="${product.image}"/></td>
                        <td>
                            <button type="submit">Update</button>
                        </td>
                    </form>
                    <form method="post" action="/deleteProduct">
                        <input type="hidden" name="id" value="${product.id}">
                        <td>
                            <button type="submit">Delete</button>
                        </td>
                    </form>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


    <h3> Save New Product</h3>

    <form method="post" action="/saveNewProduct">

    <label for="name">Name</label>
    <input type="text" id="name" name="name" placeholder="name"><br>

    <label for="description">Description</label>
    <input type="text" id="description" name="description" placeholder="description"><br>

    <label for="image">Image</label>
    <input type="text" id="image" name="image" placeholder="image"><br>

    <label for="price">Price</label>
    <input type="number" id="price" name="price" placeholder="price"><br>


    <label for="category">Category</label>
    <select name="category" id="category">
        <#if categories??>
            <#list categories as category>
                <option value="${category.id}">${category.name}</option>
            </#list>
        </#if>
    </select>

    <button type="submit">Add</button>
    <form>





</@p.pages>