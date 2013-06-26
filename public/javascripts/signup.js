/*Import*/
var imported = document.createElement('script');
imported.src = '/public/javascripts/util.js';
document.head.appendChild(imported);


$(document).ready( function (){
	
	$(".errorMessage").hide();
	
	$("#insertSubmitButton").click(function() {
		  validateForm("formUser");
	});
})


/*
 * 
 * Validations
 */
function validateForm(formId){
	
	var email        = validateRequired("email",     "Campo obrigatório");
	var password     = validateRequired("password",  "Campo obrigatório");
	var confirmation = validateRequired("passwordConfirmation",  "Campo obrigatório");
	
	var emailRule 		 = validateWithRule("email", "contains", "@", "E-mail Inválido");
	var confirmationRule = validateWithRule("passwordConfirmation", "equals"  , $("#password").val(), "As senhas inseridas são diferentes");
	
	if (email ==1 && password ==1 && confirmation ==1 && emailRule == 1 && confirmationRule ==1) {
		document.getElementById(formId).submit();
	}
	
}
