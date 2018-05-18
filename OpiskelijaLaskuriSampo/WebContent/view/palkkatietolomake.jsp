<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="./CSS/styles.css" rel="stylesheet" type="text/css">
<title>Anna palkka tiedot:</title>
</head>
<body>
	<h1>Lisää saatu palkka</h1>
	<form method="post">
		
		<input type="hidden" name= "id" value="0">
		<table>
			

			<tr>
				<td>Brutto:</td>
				<td><input type="text" value="" name="brutto" size="50" /></td>
			</tr>
			<tr>
				<td>Netto:</td>
				<td><input type="text" value="" name="netto" size="50" /></td>
			</tr>
			<tr>
				<td>Opintotuki:</td>
				<td><input type="text" value="" name="opintotuki" size="50" /></td>
			</tr>
			<tr>
				<td><div class="button">
						<a href="listaa-tiedot">Peruuta</a>
					</div></td>
				<td><input type="submit" name="submit-button"
					class="submit-button" value="Tallenna" /></td>
			</tr>
		</table>
	</form>

</body>
</html>