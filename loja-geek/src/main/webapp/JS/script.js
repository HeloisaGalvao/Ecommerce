
 //FAZ ISSO FUNCIONAR PF !!!! 
   //Setar no localStorage como array
$(function(){
    var setLocalStorage = function(obj){
        if(!localStorage.getItem('obj')){
            var arrayObject = [];
            arrayObject.push(obj);
            localStorage.setItem('obj',JSON.stringify(arrayObject));
        }else{
            var objeto = JSON.parse(localStorage.getItem('obj'));
            objeto.push(obj);
            localStorage.setItem('obj',JSON.stringify(objeto));
        }
    }
	});

$(function(){
	$("#Add").on("click", function(){
		var title= $(this).closest(".item").find(".card-title a").text();
		var price= $(this).closest(".item").find("h5").text();

	var obj={titulo:title,preco:price};
	console.log(obj); 
	localStorage.setItem('obj',JSON.stringify(obj))
	});	
});