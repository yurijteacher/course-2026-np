<#macro pages>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col">
<#--            <h2>navbar</h2>-->
            <#include "navbar.ftl"/>
        </div>
    </div>
    <div class="row">

        <div class="col-md-3">
<#--            <h2>left menu</h2>-->
            <#include "left.ftl"/>
        </div>

        <div class="col-md-9">
<#--            <h2>work area</h2>-->
            <#nested/>
        </div>

    </div>
    <div class="row">
        <div class="col">
<#--            <h2>footer</h2>-->
            <#include "footer.ftl"/>
        </div>
    </div>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>

</#macro>