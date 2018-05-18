<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Palkkatiedot</title>
<link href="./CSS/styles.css" rel="stylesheet" type="text/css">
<!-- styles.css, mobiiliresponsiivisuus, käytettävyys, tietoturva -->

</head>
<body>

	<h1 align="center">Palkat</h1>
	<a href="syota-tiedot">Lisää palkka</a>
	<table class="table_on_the_left" width="420" border="2">
		<tr>

			<td>Bruttopalkka</td>
			<td>Nettopalkka</td>
			<td>Opintotuki</td>

		</tr>

		<c:forEach items="${opiskelijat}" var="palkka">

			<tr>
				<td><c:out value="${palkka.brutto}" /></td>
				<td><c:out value="${palkka.netto}" /></td>
				<td><c:out value="${palkka.opintotuki}" /></td>
				<td><a
					href="http://localhost:8080/OpiskelijaLaskuriSampo/poista-tiedot?opiskelijaId=${palkka.id}">Poista</a></td>



			</tr>

		</c:forEach>

	</table>
	
	<br>
	<p>Tähän mennessä tienattu bruttopalkka:
	<font color="green"><c:out value="${totalbrutto}" /></font>
	<br /> Tähän mennessä tienattu nettopalkka:
	<font color="green"><c:out value="${totalnetto}" /></font>
	<br /> Tähän mennessä käytetyt opintotuki kuukaudet:
	<font color="red"><c:out value="${totalopintotuki}" /></font></p>
	
	
	<table  class="table_on_the_right" BORDER="5">
		<tr>
			<th COLSPAN="2">
				<h3>
					<br>Tarkista alla olevasta taulukosta tulorajasi
				</h3>
			</th>
		</tr>


		<tr>
			<th>Tukikuukausia<br>kalenterivuoden aikana
			</th>

			<th>Vuosituloraja<br>(euroa/kalenterivuosi)
			</th>
		</tr>

		<tr>
			<TD>1</TD>
			<TD>22 557</TD>

		</TR>
		<TR>
			<TD>2</TD>
			<TD>21 234</TD>
		</TR>
		<TR>
			<TD>3</TD>
			<TD>19 911</TD>
		</TR>
		<TR>
			<TD>4</TD>
			<TD>18 588</TD>
		</TR>
		<TR>
			<TD>5</TD>
			<TD>17 265</TD>
		</TR>
		<TR>
			<TD>6</TD>
			<TD>15 942</TD>
		</TR>
		<TR>
			<TD>7</TD>
			<TD>14 619</TD>
		</TR>
		<TR>
			<TD>8</TD>
			<TD>13 296</TD>
		</TR>
		<TR>
			<TD>9</TD>
			<TD>11 973</TD>
		</TR>
		<TR>
			<TD>10</TD>
			<TD>10 650</TD>
		</TR>
		<TR>
			<TD>11</TD>
			<TD>9 327</TD>
		</TR>
		<TR>
			<TD>12</TD>
			<TD>8 004</TD>
		</TR>

	</table>
</body>
</html>