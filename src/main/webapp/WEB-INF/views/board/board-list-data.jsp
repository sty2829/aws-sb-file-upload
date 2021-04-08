<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/datatable/datatables.css"/>
<script src="/resources/datatable/datatables.js"></script>
</head>
<body>
<script>
var draw = 1;
$(document).ready(function() {
	$('#example').DataTable({
		processing : true,
		serverSide : true,
		columns : [
			{'data' : 'boNum'},
			{'data' : 'boTitle'},
			{'data' : 'boContent'},
		],
		fnServerData: function( sSource, orgP, fnCallback){
			console.log(orgP[1]);
			console.log(orgP[2]);
			var sort = orgP[1]['value'][orgP[2]['value'][0]['column']].data + ',' + orgP[2]['value'][0]['dir'];
			console.log(sort);
            var params = [
               {name : "page", value: (orgP[3].value/orgP[4].value)},
               {name : "size", value: orgP[4].value},
               {name : "sort", value: sort}
               
            ]
			$.getJSON( '/boards', params, function (json) {
				console.log(json);
				json.draw = ++draw;
				fnCallback(json)
			});
		}
	})
});
</script>
	<table id="example" class="display" style="width:70%">
		<thead>
			<tr>
				<th>boNum</th>
				<th>boTitle</th>
				<th>boContent</th>
			</tr>
		</thead>
	</table>
	<script>
	</script>
</body>
</html>