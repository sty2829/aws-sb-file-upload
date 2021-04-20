<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody id="tBody">
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
  <ul class="pagination" id="pageNumberList">
  	<li class="page-item" onclick="pageCount(this)" id="prev">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item" onclick="pageCount(this)" id="next">
      <a class="page-link" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
	<script>
		window.addEventListener('load', page(3));
		function page(page){
			
			var url = '/board?size=20&page=' + (page-1); 
			var xhr = new XMLHttpRequest();
			//xhr.open('GET', '/board?size=5&sort=boNum,desc&page=4');
			xhr.open('GET', url);
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && xhr.status == 200){
					var res = JSON.parse(xhr.responseText);
					console.log(res);
					var html = '';
					var li = '';
					for(var board of res.content){
						html += '<tr>';
						html += '<td>' + board.boNum + '</td>';
						html += '<td>' + board.boTitle + '</td>';
						html += '<td>' + board.boContent + '</td>';
						html += '</tr>';
					}
					for(var i=1; i<=res.totalPages; i++){
						li += '<li class="page-item"><a class="page-link" href="#">'+ i +'</a></li>';
					}
					
					document.querySelector('#tBody').innerHTML = html;
					document.querySelector('#pageNumberList').innerHTML = li;
				}
			}
			//xhr.send();
		}
		function pageCount(obj){
			var ul = document.querySelector('#pageNumberList'); 
			
			var prev = document.querySelector('#prev');
			var next = document.querySelector('#next');
			var firstItem = prev.nextSibling.nextSibling;
			var lastItem = next.previousSibling.previousSibling;
			
			if(obj.id == 'next'){
				var firstNumber = document.createTextNode(Number(firstItem.firstChild.innerHTML) + 1);
				var firstReplaceItem = createNode(firstNumber);
				ul.replaceChild(firstReplaceItem, firstItem);
				var lastNumber = document.createTextNode(Number(lastItem.firstChild.innerHTML) + 1);
				var lastReplaceItem = createNode(lastNumber);
				ul.replaceChild(lastReplaceItem, lastItem);
			}else{
				firstVal.innerHTML = (Number(firstVal.innerHTML) - 1);
				lastVal.innerHTML = (Number(lastVal.innerHTML) - 1);
			}
			
		}
		function createNode(number){
			var li = document.createElement("li");
			li.className = "page-item";
			var a = document.createElement("a");
			a.className = "page-link";
			a.href = "#";
			li.appendChild(a).appendChild(number);
			return li;
			
		}
	</script>
</body>
</html>