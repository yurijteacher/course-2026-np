<#import "manager/templ-manager.ftl" as p>
<@p.pages>

    <script type="text/javascript">

        $(document).ready(function () {
            showCategory();
        });

        async function add_category() {
            try {
                await $.ajax({
                    url: '/category-rest',
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        name: $("#rest_name").val(),
                        description: $("#rest_description").val(),
                        image: $("#rest_image").val()
                    })
                });
                $("#rest_name, #rest_description, #rest_image").val('');
                showCategory();
            } catch (error) {
                console.error(error);
            }
        }

        function updateCategory(id) {

            $.ajax({
                url: "/category-rest/" + id,
                method: "PUT",
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                data: JSON.stringify({
                    id: $("#id" + id).val(),
                    name: $("#name" + id).val(),
                    description: $("#description" + id).val(),
                    image: $("#image" + id).val()
                }),
                success: function (response) {
                    // console.log("Updated:", response);
                    showCategory();
                    // setTimeout(showCategory, 500);
                },
                error: function (error) {
                    alert(error);
                }
            })
        }

        function deleteCategory(id) {
            $.ajax({
                url: "/category-rest/" + id,
                method: "DELETE",
                success: function () {
                    showCategory();
                },
                error: function (error) {
                    alert(error);
                }
            });
        }


        function showCategory() {
            console.log("Hello!")

            $.get("/category-rest", function (data) {
                console.log(data);
                let table = "<table class='table'>" +
                    "<tr><th>id</th>" +
                    "<th>name</th>" +
                    "<th>description</th>" +
                    "<th>image</th>" +
                    "<th>update</th>" +
                    "<th>delete</th>" +
                    "</tr>";

                for (let i = 0; i < data.length; i++) {
                    table += "<tr>" +
                        "<td><input type='number' id='id" + data[i].id + "' value='" + data[i].id + "'></td>" +
                        "<td><input type='text' id='name" + data[i].id + "' value='" + data[i].name + "'></td>" +
                        "<td><input type='text' id='description" + data[i].id + "' value='" + data[i].description + "'></td>" +
                        "<td><input type='text' id='image" + data[i].id + "' value='" + data[i].image + "'></td>" +
                        "<td><button onclick='updateCategory(" + data[i].id + ")'>Update</button></td>" +
                        "<td><button onclick='deleteCategory(" + data[i].id + ")'>Delete</button></td>" +
                        "</tr>"
                }

                table = table + "</table>";

                $(".test_category").html(table);
            });
        }
    </script>

    <h2> AJAX </h2>
    <div class="test_category"></div>
    <h3></h3>

    <h2> Save new Category By Rest Api</h2>
    <form>
        <label for="rest_name">Name</label>
        <input type="text" id="rest_name" placeholder="name"><br>
        <label for="rest_description">Description</label>
        <input form="text" id="rest_description" placeholder="description"><br>
        <label for="rest_image">Image</label>
        <input form="text" id="rest_image" placeholder="image"><br>

        <input type="button" onclick="add_category()" value="addCategory">
    </form>

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
                        <th>
                            <button type="submit">Update</button>
                        </th>
                    </form>
                    <form method="post" action="/deleteCategory">
                        <input type="hidden" name="id" value="${category.id}">
                        <th>
                            <button type="submit">Delete</button>
                        </th>
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