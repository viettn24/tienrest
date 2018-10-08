<html>
<head>
	<title>Viet TN API</title>
	<style type="text/css">
		input{
			width: 200px;
			height: 50px;
			display: block;
		}
		h5,a{
			color: green;
			border-top: 30px solid pink;
			padding-top:20px;
		}
		.input-box{
		}
		
	</style>
</head>
<body>
<h2>VietTN API</h2> <br><br>
<a href="api/students">API Show All Students (Method = GET)</a> <br><br>
<div class="input-box"><input type="text" value="http://thisdomain/api/students"></div>
<hr>

<h5>Show a Student (Method = GET)</h5>
<div class="input-box"><input type="text" value="http://thisdomain/api/students/{studentId}"></div>
<hr>

<h5>Add Student (Method = POST, JSON)</h5>
<div class="input-box"><input type="text" value="http://thisdomain/api/students"></div>
<div class="input-box">
Example: <br>
{<br>
	"firstName": "Mary",<br>
	"lastName": "Quill",<br>
	"email": "maryquill@gmail.com"<br>
}
</div>
<hr>

<h5>Update Student (Method = POST), JSON</h5>
<div class="input-box"><input type="text" value="http://thisdomain/api/students/"></div>
<div class="input-box">
Example: <br>
{<br>
	"id":"3"
	"firstName": "Mary",<br>
	"lastName": "Quill",<br>
	"email": "maryquill@gmail.com"<br>
}
</div>
<hr>

<h5>Delete Student (Method = DELETE)</h5>
<div class="input-box"><input type="text" value="http://thisdomain/api/students/{studentId}"></div>
<hr>


	
</body>
</html>
