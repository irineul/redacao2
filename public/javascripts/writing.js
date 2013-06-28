/*Import*/
var imported = document.createElement('script');
imported.src = '/public/javascripts/util.js';
document.head.appendChild(imported);


$(document).ready( function (){
	
	$(".errorMessage").hide();
	
	$("#insertSubmitButton").click(function() {
		  validateForm("formWriting");
	});
})


/*
 * 
 * Validations
 */
function validateForm(formId){
	
	var email        = validateRequired("title",     "Campo obrigatório");
	var password     = validateRequired("writingFile",  "Campo obrigatório");
	
	if (email ==1 && password ==1 ) {
		document.getElementById(formId).submit();
	}
	
}
