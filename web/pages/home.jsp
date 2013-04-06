<%@ include file="../includes/header.jsp"%>

<jsp:include page="../includes/nav.jsp" >
    <jsp:param name="menu" value="home" />
    <jsp:param name="name" value="${user.firstName}" />
</jsp:include>


<div class="container">

        <jsp:include page="../includes/search.jsp" >
            <jsp:param name="search" value="${search}" />
        </jsp:include>


    <legend>

        <h1>Contact List</h1>

    </legend>
    <div>
        <table class="table table-bordered table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>


            <c:if test="${contacts.size()>0}">
                <c:forEach var="contact" varStatus="count" items="${contacts}">
                    <tr>
                        <td>${count.index+1}</td>
                        <td>${contact.firstName}</td>
                        <td>${contact.middleName}</td>
                        <td>${contact.lastName}</td>
                        <td>${contact.address}</td>
                        <td>${contact.phone}</td>
                        <td>
                            <form action="delete" method="POST" class="" style="margin: 0;">
                                <a class="btn btn-mini btn-success" href="#">Call</a>
                                <input type="hidden" name="id" value="${contact.id}">
                                <input class="btn btn-mini btn-danger " type="submit" value="Delete"/>
                                <a class="btn btn-mini " href="edit?id=${contact.id}">Edit</a>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

            </tbody>
        </table>
    </div>

</div>

<%@ include file="../includes/footer.jsp"%>