$(function() {
	
	$('.create_button').puibutton({
		icon: 'fa-plus',
		click: function() {
			$('#create_applicant_dialog').puidialog('show');
		}
	});
	
	$('.edit_button').puibutton({
		icon: 'fa-pencil'
	});
	
	$('.delete_button').puibutton({
		icon: 'fa-trash'
	});

	$('#create_applicant_dialog').puidialog({
		responsive: true,
		minWidth: 600,
		minHeight: 500,
		modal: true,
		buttons: [{
			text: 'Cancel',
			icon: 'fa-ban',
			click: function() {
				$('#create_applicant_dialog').puidialog('hide');
			}
		},{
			text: 'Save',
			icon: 'fa-save',
			click: function() {
				$('#create_applicant_dialog').puidialog('hide');
			}
		}]
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

