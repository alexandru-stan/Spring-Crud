let datos;
fetch("http://localhost:8080/recuperarTodos").then(response => response.json()).then(data => {datos = data; main();});


function main(){
	
	console.log(Object.values(datos)[0]);
	table = document.createElement("table");
	let raiz = document.getElementById("usuarios");
	for(let i=0;i<datos.length;i++){
		
		
		tr = document.createElement("tr");
		
		for(j=0;j<Object.keys(datos).length;j++){
			
			tdKey= document.createElement("td");
			tdVal = document.createElement("td");
			tdKey.appendChild(document.createTextNode(Object.keys(datos[i])[j]));
			tdVal.appendChild(document.createTextNode(Object.values(datos[i])[j]));
			
			tr.appendChild(tdKey);
			tr.appendChild(tdVal);
			
			
		}
		
		
		table.appendChild(tr);
		
	}
	
	raiz.appendChild(table);
	
}

