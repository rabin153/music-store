
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Inventory Page</h1>

			<p class="lead">This is a product inventory page</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Photo Thumb</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><img
						src="<c:url value="/admin/product/displayimage/${product.id}"/>"
						alt="image" style="width: 100%"></td>
					<td>${product.productName}</td>
					<td>${product.productCategory}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice}USD</td>
					<td><a
						href="<spring:url value="/product/viewProduct/${product.id}" />"><span
							class="glyphicon glyphicon-info-sign" /></a> <a
						href="<spring:url value="/admin/product/deleteproduct/${product.id}" />"><span
							class="glyphicon glyphicon-trash" /></a> <a
						href="<spring:url value="/admin/product/editproduct/${product.id}" />"><span
							class="glyphicon glyphicon-pencil" /></a></td>

				</tr>
			</c:forEach>
		</table>

		<a href="<spring:url value="/admin/product/addproduct" />"
			class="btn btn-primary">Add Product</a>



		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>