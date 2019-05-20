
$(function(){
	
	// Star display
	$('.starrr').starrr({
	  change: function(e, value){
	    $(this).next().val(value)
	  }
	});
	
	// Check if the login user is the author of the review
	var loginName = $('#studentName').text(); 
	$("div.review-item").each(function(){
		let item = $(this);
		let reviewerName = item.children("#reviewerName").text();
		if (loginName != reviewerName){
			//item.find('.comment_edit').attr('disabled', true);
			item.find('.comment_edit').addClass('d-none');
			// Hidden instead of disabled
			//item.find('.comment_delete').attr('disabled', true);
			// Hidden instead of disabled
			item.find('.comment_delete').addClass('d-none');
		}
	});
	
	// To have scrollable bar
	$('.pre-scrollable').css('max-height', '500px');
	$('.pre-scrollable').css('overflow-x', 'hidden');
	

});