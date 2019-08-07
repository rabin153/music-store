<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/jsp/template/header.jsp"%>




<div class="container-wrapper">

	<div class="container">

		<div class="page-header">

			<h1>Product Details</h1>

			<p class="lead">Here is the Detail information of the Product!</p>

		</div>

		<div class="container">
			<div class="row">

				<div class="col-md-5">
					<img
						src="<c:url value="/admin/product/displayimage/${product.id}"/>"
						alt="image" style="width: 100%; height: 100%;">
				</div>

				<div class="col-md-5">
					<h3>${product.productName}</h3>
					<p>Product Description</p>
					<p>Manufactrer</p>
					<p>Category</p>
					<p>Condition</p>
					<p>Price</p>
				</div>



			</div>

		</div>
		<%@include file="/WEB-INF/jsp/template/footer.jsp"%>
	</div>

</div>