<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .button {
            display: inline-block;
            border-radius: 4px;
            border: none;
            text-align: left;
            padding: 0px 0px;
            transition: all 0.5s;
            cursor: pointer;
            margin: 0px 0px;
            background-color: rgba(255, 255, 255, .0);
        }

    </style>

</head>
<body>

<div id="sidebar" class="span3">
    <div class="well well-small">
        <ul class="nav nav-list">
            <!--
            <form action="/categories/women" method="post">
                <li><a href=""><span class="icon-chevron-right"><button class="button">Women</button></span></a></li>
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
            </form>
            <form action="/categories/men" method="post">
                <li><a href=""><span class="icon-chevron-right"><button class="button">Men</button></span></a></li>
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
            </form>
            -->
            <form action="/categories/shoes" method="post">
                <li><a href=""><span class="icon-chevron-right"><button class="button">${Shoes}</button></span></a></li>
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
            </form>
            <form action="/categories/accessory" method="post">
                <li><a href=""><span class="icon-chevron-right"><button class="button">${Accessory}</button></span></a></li>
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
            </form>
            <form action="/categories/clothes" method="post">
                <li><a href=""><span class="icon-chevron-right"><button class="button">${Clothes}</button></span></a></li>
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
            </form>
            <form action="/categories/cosmetic" method="post">
                <li><a href=""><span class="icon-chevron-right"><button class="button">${Cosmetic}</button></span></a></li>
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
            </form>
            <form action="/categories/electronics" method="post">
                <li><a href=""><span class="icon-chevron-right"><button class="button">${Electronics}</button></span></a></li>
                <input type="hidden"  name="loggedUsername" value="${loggedUser.username}" placeholder="Search" class="search-query span2">
            </form>



            <li style="border:0"> &nbsp;</li>
        </ul>
    </div>
</div>


</body>
</html>