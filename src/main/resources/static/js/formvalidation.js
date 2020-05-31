/**
 * 
 */
function validation(){
	
	var name_val=$('#username').val();
	var mobile_val=$('#mobile').val();
	var email_val=$('#email').val();
	var dob_val=$('#dob').val();
	var password_val=$('#password').val();
	
	 var namechk=/^[A-Za-z. ]{3,30}$/;
	 var mobilechk=/^[789][0-9]{9}$/;
	 var emailchk=/^[A-Za-z0-9_.]{3,}@[A-Za-z]{3,}[.]{1}[A-Za-z.]{2,6}$/;
	 
	 // For Username Check Validation
	 if(name_val==''){
		 $('#namecheck').html('**Name Should not be blank');
		 return false;
	 }
	 
	 // For Mobile Number Check Validation
	 if(mobile_val==''){
		 $('#mobilecheck').html('**Mobile Number Should not be blank');
		 return false;
	 }
	 
	 // For Email Id Check Validation
	 if(email_val==''){
		 $('#emailcheck').html('**Email Id Should not be blank');
		 return false;
	 }
	 
	 // For Date of Birth Check Validation
	 if(dob_val==''){
		 $('#dobcheck').html('**Date of Birth Should not be blank');
		 return false;
	 }
	 
	 // For Password Check Validation
	 if(password_val==''){
		 $('#passwordcheck').html('**Password Should not be blank');
		 return false;
	 }
	 
	 // For Username Check Validation
	 if(namechk.test(name_val)){
		 $('#namecheck').html('');
	 }else{
		 $('#namecheck').html('**Name Should not start with digit');
		 return false;
	 }
	 
	// For Mobile Number Check Validation
	 if(mobilechk.test(mobile_val)){
		 $('#mobilecheck').html('');
	 }else{
		 $('#mobilecheck').html('**Invalid Mobile Number please write correct mobile no');
		 return false;
	 }
	 
	// For Email Id Check Validation
	 if(emailchk.test(email_val)){
		 $('#emailcheck').html('');
	 }else{
		 $('#emailcheck').html('**Invalid Email Id please write correct email-id');
		 return false;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
}