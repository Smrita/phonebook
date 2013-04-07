<!-- Footer
================================================== -->
<footer class="footer">
    <div class="container">
        <p> PhoneBook
            <jsp:useBean id="date" class="java.util.Date"/>
            <fmt:formatDate value="${date}" pattern="yyyy"/>
        </p>
    </div>
</footer>
<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>
