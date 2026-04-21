<#import "manager/templ-manager.ftl" as p>
<@p.pages>

    <h2 class="text-center"> Category Pages </h2>

    <h3>List Category</h3>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>images</th>
        </tr>
        </thead>
        <tbody>
        <#if categories??>
            <#list categories as category>
                <tr>
                        <td>${category.id}</td>
                        <td>${category.name}</td>
                        <td>${category.description}</td>
                        <td>${category.image}</td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


    <h3> Update/Delete </h3>

    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>images</th>
            <th>update</th>
            <th>delete</th>
        </tr>
        </thead>
        <tbody>
        <#if categories??>
            <#list categories as category>
                <tr>
                    <form method="post" action="/updateCategory">
                    <td><input type="text" name="id" value="${category.id}"/></td>
                    <td><input type="text" name="name" value="${category.name}"/></td>
                    <td><input type="text" name="description" value="${category.description}"/></td>
                    <td><input type="text" name="image" value="${category.image}"/></td>
                    <th><button type="submit">Update</button></th>
                    </form>
                    <form method="post" action="/deleteCategory">
                        <input type="hidden" name="id" value="${category.id}">
                        <th><button type="submit">Delete</button></th>
                    </form>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>

    <h3> Save New Category </h3>

    <form method="post" action="/saveNewCategory">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="name"><br>
        <label for="description">Description</label>
        <input type="text" id="description" name="description" placeholder="description"><br>
        <label for="image">Image</label>
        <input type="text" id="image" name="image" placeholder="image"><br>

        <button type="submit">Add</button>
    </form>

</@p.pages>