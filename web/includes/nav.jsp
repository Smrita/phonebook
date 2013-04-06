<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Contacts</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="${(param.menu  eq "home") ? "active" : " "}"><a href="home">Home</a></li>
                    <li class="${(param.menu  eq "add") ? "active" : " "}"><a href="add">Add Contact</a></li>
                    <li class="${(param.menu  eq "about") ? "active" : " "}"><a href="#aboutModal" data-toggle="modal">About</a></li>
                </ul>
                <ul class="nav pull-right">

                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${param.name} <b
                                class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <%--<li><a href="#">Profile</a></li>--%>

                            <%--<li class="divider"></li>--%>
                            <li><a href="logout">Logout</a></li>
                        </ul>
                    </li>
                </ul>

            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>
<!-- Modal -->
<div id="aboutModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <h3 id="myModalLabel">About Contacts</h3>
    </div>
    <div class="modal-body">
        <p>Contacts Version 1.0</p>
        <p>Desined and developed in Nepal</p>
        <p>By Pramod Bhandari</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
    </div>
</div>