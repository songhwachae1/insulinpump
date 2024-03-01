var h = {
	_startPicker: null,
	_endPicker: null,
	$start: null,
	$end: null,
	init: function() {
		this.$start = $('#start');
		this.$end = $('#end');
		var that = this;
		var yesterday = moment().subtract(1, 'days');
		console.log(yesterday);
		//start datepicker initial setting
		this._startPicker = mobiscroll.datepicker('#picker1', {
			controls: ['calendar'],
			touchUi: true,
			showOnClick: true,
			showOnFocus: true,
			dateFormat: 'YYYY-MM-DD',
			defaultValue: yesterday,
			onChange: function(event, inst) {
				that.$start.val(event.valueText);
			},
			onInit: function(event, inst) {
				console.log(inst);
				that.$start.val(event.valueText);
			}
		});
		//end datepicker initial setting
		this._startPicker = mobiscroll.datepicker('#picker2', {
			controls: ['calendar'],
			touchUi: true,
			showOnClick: true,
			showOnFocus: true,
			dateFormat: 'YYYY-MM-DD',
			onChange: function(event, inst) {
				that.$end.val(event.valueText);
			},
			onInit: function(event, inst) {
				that.$end.val(moment().format('YYYY-MM-DD'));
			}
		});
	}
};

$(document).ready(function() {
	c.init();
	h.init();
});