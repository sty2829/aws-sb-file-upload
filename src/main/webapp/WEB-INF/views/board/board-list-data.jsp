<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/datatable/datatables.css"/>
<script src="/resources/datatable/datatables.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
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
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<table id="example" class="display" style="width:100%">
					<thead>
						<tr>
							<th>boNum</th>
							<th>boTitle</th>
							<th>boContent</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
</body>
</html>