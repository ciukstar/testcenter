$(function() {
	
	$('.create_button').puibutton({
		icon: 'fa-plus'
	});
	
	$('.edit_button').puibutton({
		icon: 'fa-pencil'
	});
	
	$('.delete_button').puibutton({
		icon: 'fa-trash'
	});

	$('#applicants_list').puidatatable({
		caption: 'Applicants',
		paginator: { rows: 10 },
		columns: [
			{field: 'surname', headerText: 'Surname'},
			{field: 'name', headerText: 'Name'},
			{field: 'patronymic', headerText: 'Patronymic'}
		],
		datasource: function(callback) {
			$.ajax({
				type: "GET",
				url: 'applicants',
				dataType: "json",
				context: this,
				success: function(response) {
					callback.call(this, response);
				}
			});
	}
});

});

