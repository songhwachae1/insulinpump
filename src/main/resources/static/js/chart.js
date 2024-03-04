var h = {
	_startPicker: null, // mobiscroll datepicker object for start date
	_endPicker: null, // mobiscroll datepicker object for end date
	_today: null, // moment object
	_sqlDateFormat: 'YYYY-MM-DD',
	_recordList: null,
	_chart: null, //echarts object
	_loading: false,
	$srchBtn: null,
	$nodata: null,
	$startBtn: null,
	$endBtn: null,
	getRecordList: function(start, end) {
		if (this._loading) {
			return;
		}
		
		this._loading = true;
		const today = this._today.format(this._sqlDateFormat);
		
		if (!start) {
			start = today;
		}

		if (!end) {
			end = today;
		}

		c.showPreloader();
		var url = '/insulin/getRecord'
		url = url + '?startDate=' + start + '&endDate=' + end;
		fetch(url)
		.then(response => response.json())
		.then(data => {
			this._loading = false;
			if (data.returnCode != '200') {
				swal(data.returnCode, 'Oops! Something went wrong.', 'error');
				c.hidePreloader();
				return;
			}

			this._recordList = data.data;
			dateList = {};
			x = this._recordList.map(function(item) {
				return item.measureDate;
			});
			y = this._recordList.map(function(item) {
				return item.glucoseLevel;
			});
			this.plot(x, y);
			c.hidePreloader();
		})
		.catch(error => {
			swal('Error', 'Oops! Something went wrong.', 'error');
			console.log(error);
		});
	},
	plot: function(x, y) {
		// Specify the configuration items and data for the chart
		var option = {
			title: {
				text: 'Glucose Level',
				left: 'center'
			},
			tooltip: {
				trigger: 'axis'
			},
			xAxis: {
				type: 'category',
				data: x
				},
			yAxis: {
				type: 'value'
				},
			series: [
				{
					data: y,
					type: 'line'
				}
			]
		};
			
		// Display the chart using the configuration items and data just specified.
		this._chart.setOption(option);
	},
	init: function() {
		var that = this;
		this._today = moment();
		this.$startBtn = $('#picker1');
		this.$endBtn = $('#picker2');
		this.$srchBtn = $('#search');
		this.$nodata = $('#nodata');
		//start datepicker initial setting
		this._startPicker = mobiscroll.datepicker('#start', {
			controls: ['calendar'],
			touchUi: true,
			showOnClick: true,
			showOnFocus: true,
			dateFormat: 'MM-DD-YYYY',
			onInit: function(event, inst) {
				var val = moment().subtract(1, 'days');
				inst.setVal(val, true);
				that.getRecordList(val.format(that._sqlDateFormat));
			}
		});
		//end datepicker initial setting
		this._endPicker = mobiscroll.datepicker('#end', {
			controls: ['calendar'],
			touchUi: true,
			showOnClick: true,
			showOnFocus: true,
			dateFormat: 'MM-DD-YYYY',
			onInit: function(event, inst) {
				inst.setVal(that._today, true);
			}
		});
		//add start datepicker btn click handler
		this.$startBtn.on('click', function() {
			that._startPicker.open();
		});
		//add end datepicker btn click handler
		this.$endBtn.on('click', function() {
			that._endPicker.open();
		});
		this.$srchBtn.on('click', function() {
			var start = moment(that._startPicker.getVal()).format(that._sqlDateFormat);
			var end = moment(that._endPicker.getVal()).format(that._sqlDateFormat);
			that.getRecordList(start, end);
		});
		// init echarts object
		this._chart = echarts.init(document.getElementById('chart'));
	}
};

$(document).ready(function() {
	c.init();
	h.init();
});