<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>



<div class="container-wrapper">

	<div class="container">

		<div class="page-header">

			<h1>All Products</h1>

			<p class="lead">Checkout all the awesome products available now !</p>

		</div>

		<table class="table table-stripped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Product Thumb</th>
					<th>Product Name</th>
					<th>Product Category</th>
					<th>Product Condition</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tbody>
					<tr>
						<td><img
							src="<c:url value="/admin/product/displayimage/${product.id}"/>"
							alt="image" style="width: 100%"></td>

						<td>${product.productName}</td>
						<td>${product.productCategory}</td>
						<td>${product.productCondition}</td>
						<td>${product.productDescription}</td>
						<td>${product.productPrice}</td>
						<td><a href="/productList/viewProduct/${product.id}"><span
								class="glyphicon glyphicon-info-sign"></span> </a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>




		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
	</div>

</div>