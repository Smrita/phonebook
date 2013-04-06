<%@ include file="../includes/header.jsp"%>

<jsp:include page="../includes/nav.jsp" >
    <jsp:param name="menu" value="add" />
    <jsp:param name="name" value="${user.firstName}" />

</jsp:include>


<div class="container">

    <jsp:include page="../includes/search.jsp" >
        <jsp:param name="search" value="${search}" />
    </jsp:include>
    <legend>
        <h1>Add Contact</h1>
    </legend>
    <div>
        <form class="form-horizontal" action="add" method="POST">
            <div class="control-group">
                <label class="control-label" for="firstName">First Name</label>

                <div class="controls">
                    <input type="text" name="firstName" id="firstName" placeholder="First Name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="middleName">Middle Name</label>

                <div class="controls">
                    <input type="text" name="middleName" id="middleName" placeholder="Middle Name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="lastName">Last Name</label>

                <div class="controls">
                    <input type="text" name="lastName" id="lastName" placeholder="Last Name">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address">Address</label>

                <div class="controls">
                    <input type="text" name="address" id="address" placeholder="Address">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="phone">Phone</label>

                <div class="controls">
                    <input type="text" name="phone" id="phone" placeholder="Phone">
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn">Save</button>
                </div>
            </div>
        </form>
    </div>

</div>
<!-- /container -->
<%@ include file="../includes/footer.jsp"%>