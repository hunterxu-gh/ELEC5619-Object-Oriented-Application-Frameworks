
$(function(){
	
	// show how many stars
	$('.starrr').starrr({
	  change: function(e, value){
	    $(this).next().val(value)
	  }
	});
	
	//
	var loginName = $('#studentName').text(); 
	$("div.review-item").each(function(){
		let item = $(this);
		let reviewerName = item.children("#reviewerName").text();
		if (loginName != reviewerName){
//			console.info(loginName + ":" + reviewerName)
			item.find('.comment_edit').attr('disabled', true);
			item.find('.comment_delete').attr('disabled', true)	
		}

	});
	
	$('.pre-scrollable').css('max-height', '500px');
	$('.pre-scrollable').css('overflow-x', 'hidden');	
	

});