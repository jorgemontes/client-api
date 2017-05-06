<html>
<body>
	<h2>Client Form</h2>
	<form action="${pageContext.request.contextPath}/createClient"
		method="post">
		<p>
			Name: <input type="text" name="name" />
		</p>
		<p>
			ID: <input type="text" name="id" />
		</p>
		<p>
			Age: <input type="text" name="age" />
		</p>
		<p>
			Address: <input type="text" name="address" />
		</p>
		<p>
			<input type="submit" name="submit" value="submit" />
		</p>
	</form>
</body>
</html>
