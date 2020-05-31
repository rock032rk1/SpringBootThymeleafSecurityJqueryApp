/**
 * 
 */
$(document).ready(function() {

	$('.table .eBtn').on('click', function(event) {

		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(st, status) {
			$('#editid').val(st.id);
			$('#editmobile').val(st.mobile);
			$('#editname').val(st.username);
			$('#editemail').val(st.email);
//			$('#editupdateOn').val(st.updateOn.substr(0, 10));
			$('#editdob').val(st.dob);
			$('#editpassword').val(st.password);
		});
		$('#editModal').modal();
	});

	$('.table .dBtn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');

		$('#deleteModal #delBtn').attr('href', href);
		$('#deleteModal').modal();
	});
	
	 $('.nBtn').on('click',function(){
		    
		    $('#id').val('');
			$('#username').val('');
			$('#mobile').val('');
			$('#email').val('');
			$('#dob').val('');
			$('#password').val();
			$('#addModal').modal();
	  });
});