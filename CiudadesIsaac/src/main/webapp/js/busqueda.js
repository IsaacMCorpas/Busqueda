(function ()  {
	let sugerencias_ciudades = document.getElementById('sugerencias');
	document.getElementById('busqueda').addEventListener('keyup', function(evnt){
		
		let ciudadesLista= '';
		if(this.value!="") {
			
			
			let city=this.value;
			console.log("muestra city:"+city);
			
			$.ajax({
				url: `./buscador?city=${city}`,
				type: "POST",
				accepts: "application/json"
			}).done(function (data){
				if(data){
					
					ciudadesLista='<ul>';
					console.log("Entro aqui",data);
					for(let index = 0; index <data.length; index++) {
						ciudadesLista+= '<li>'+data[index].name+'</li>';
					}
					
					
					ciudadesLista+= '</ul>';
					sugerencias_ciudades.innerHTML = ciudadesLista;
					console.log(ciudadesLista);
				}
			}).fail(function(err){
				console.log("Error:",err);
				
			});
		}
		else {sugerencias_ciudades.innerHTML = ciudadesLista;}
		
    });

})();


