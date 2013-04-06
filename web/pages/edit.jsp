<%@ include file="../includes/header.jsp"%>

<jsp:include page="../includes/nav.jsp" >
    <jsp:param name="menu" value="edit" />
    <jsp:param name="name" value="${user.firstName}" />

</jsp:include>


<div class="container">

    <jsp:include page="../includes/search.jsp" >
        <jsp:param name="search" value="${search}" />
    </jsp:include>
    <legend>
        <h1>Edit Contact</h1>
    </legend>
    <div>
        <form class="form-horizontal" action="edit" method="POST">
            <div class="control-group">
                <label class="control-label" for="firstName">First Name</label>

                <div class="controls">
                    <input type="text" name="firstName" id="firstName" placeholder="First Name" value="${contact.firstName}"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="middleName">Middle Name</label>

                <div class="controls">
                    <input type="text" name="middleName" id="middleName" placeholder="Middle Name" value="${contact.middleName}"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="lastName">Last Name</label>

                <div class="controls">
                    <input type="text" name="lastName" id="lastName" placeholder="Last Name" value="${contact.lastName}"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="address">Address</label>

                <div class="controls">
                    <input type="text" name="address" id="address" placeholder="Address" value="${contact.address}"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="phone">Phone</label>

                <div class="controls">
                    <input type="text" name="phone" id="phone" placeholder="Phone" value="${contact.phone}"/>
                </div>
            </div>

            <%--Hidden field for id--%>
            <input type="hidden" name="id" value="${contact.id}">

            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn">Update</button>
                </div>
            </div>
        </form>
    </div>

</div>
<!-- /container -->

<%@ include file="../includes/footer.jsp"%>
