<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Student Registration Form</title>

</head>

<body>
 	<form:form action="processForm" modelAttribute="student">
	First name: <form:input path="firstName" />
	
	<br><br>
	
	Last name: <form:input path="lastName" />
	
	<br><br>
	Country:
	<form:select path="country">
	<!-- on submit, Spring will call Student.setCountry() 
	das hei�t, das muss ich in der Student klasse implementieren-->
	
	<!--  	<form:option value="Brazil" label="Brazil" />
		<form:option value="France" label="France" />
		<form:option value="Germany" label="Germany" />
		<form:option value="India" label="India" />
	das geht aber auch k�rzer: �ber eine Linked Hashmap in der Student Klasse. Dann:-->
	
	<form:options items="${student.countryOptions}"/>
	
	</form:select>
	<br><br>
	Favourite Language:
	<!-- on Submit, student.setFavoriteLanguage will be called -->
	Java <form:radiobutton path="favoriteLanguage" value="Java" />
	C# <form:radiobutton path="favoriteLanguage" value="C#" />
	Python <form:radiobutton path="favoriteLanguage" value="Python" />
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
		<br><br>
	Operating Systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
		
	<br><br>
	<input type="submit" value="Submit" />

	</form:form>




</body>



</html>