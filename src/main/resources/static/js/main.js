var m = {
	_timer: null,
	_interval: 600000, //default 10 min
	_battery: 9, //current battery
	_batteryFull: 9,
	_batteryRecharge: 0.15,
	_batRead: 0.025,
	_batInject: 0.05,
	_insulin: 10, //current insulin amount
	_insulinFull: 10,
	_insulinResupply: 0.15,
	_insulinDose: 0.05,
	_safeMin: 100,
	_safeMax: 120,
	_capMax: 200,
	_prev: null,
	_current: null,
	_decSlop: -5,
	_alertTimeout: 5000,
	$glucose: null, // jquery object, used to display the glucose level on the screen
	$band: null, // jquery object, used to display the band (safe, dangerous, undesirable)
	$band2: null,
	$battery: null, // jquery object, used to display the battery on the screen
	$insulin: null, // jquery object, used to display the insulin level remained on the screen
	$action: null, // jquery object, used to display the action (read, warning, inject)
	$start: null, // jquery object for start button
	$stop: null, // jquery object for stop button
	$mdate: null, // last measured on...
	$item: null,
	getBattery: function() {
		return this._battery;
	},
	getInsulin: function() {
		return this._insulin;
	},
	getPrev: function() {
		return this._prev;
	},
	setInterval: function(interval) {
		this._interval = interval;
	},
	setTimer: function(fn) {
		var that = this;
		this._timer = setTimeout(function() {
			fn();
			that.setTimer(fn);
		}, this._interval);
	},
	clearTimer: function() {
		if (!this._timer) {
			return;
		}

		clearTimeout(this._timer);
		this._timer = null;
	},
	alert: function() {
		var that = this;
		this.$item.addClass('alert');
		setTimeout(function() {
			that.$item.removeClass('alert');
		}, this._alertTimeout);
	},
	//change the setting of the pump
	changeSetting: function(fn, interval) {
		this.setInterval(interval);
		this.clearTimer();
		this.setTimer(fn);
	},
	//read glucose level and return it
	read: function() {
		this.checkBattery();
		fetch('/insulin/read')
		.then(response => response.json())
		.then(data => {
			if (data.returnCode != '200') {
				swal(data.returnCode, 'Oops! Something went wrong.', 'error');
				this.clearTimer();
				return;
			}

			this.useBattery(this._batRead); //each check uses battery.
			this._prev = this._current;
			this._current = data.data.glucoseLevel;
			this.$glucose.text(this._current);
			this.setBandTxtCls(this._current)
			this.$battery.text(this.getBattery());
			this.$insulin.text(this.getInsulin());
			this.$mdate.text(data.data.measureDate);
		})
		.catch(error => {
			swal('Error', 'Oops! Something went wrong.', 'error');
			//TODO : button change
			//TODO : abort
			this.clearTimer();
			console.log(error);
		})
	},
	//get the latest record for initial display
	getLatestRecord: function() {
		fetch('/insulin/latest')
		.then(response => response.json())
		.then(data => {
			if (data.returnCode != '200') {
				swal(data.returnCode, 'Oops! Something went wrong.', 'error');
				this.clearTimer();
				return;
			}

			this.setBandTxtCls(this._current)
			this.$glucose.text(data.data.glucoseLevel);
			this.$mdate.text(data.data.measureDate);
			c.hidePreloader();
		})
		.catch(error => {
			swal('Error', 'Oops! Something went wrong.', 'error');
			console.log(error);
		});
	},
	//inject insulin
	inject: function() {
		this.checkInsulin();
		this.checkBattery();
		this._insulin -= this._insulinDose;
		this._insulin = this._insulin.toFixed(2);
		this.useBattery(this._batInject); //each inject uses battery.
	},
	//check insulin remained
	checkInsulin: function() {
		if (this._insulin < this._insulin * this._insulinFull)
			this._insulin = this._insulinFull;
	},
	//use battery
	useBattery: function(n) {
		this._battery -= n
		this._battery = this._battery.toFixed(3);
	},
	//check battery
	checkBattery: function() {
		//recharge
		if (this._battery < (this._batteryFull * this._batteryRecharge)) {
			this._battery = this._batteryFull;
		}

		return this._battery;
	},
	//decide whether the glucose level is in safe/unsafe/undesirable area
	setBandTxtCls: function(n) {
		var band = 'safe';
		var action = 'read';
		var cls = 'safe';
		
		if (n < this._safeMin) {
			band = 'dangerous';
			action = 'warning';
			cls = 'dang';
			this.alert();
		} else if (n < this._safeMax) {
			band = 'safe';
			action = 'read';
			cls = 'safe';
		} else {
			band = 'undesirable';
			cls = 'undesirable';
			//check slope
			if (!this.safeSlope()) {
				action = 'inject';
				this.inject();
			}
		}

		this.$band.text(band);
		this.$band2.text(band);
		this.$action.text(action);
		this.$band.attr('class', cls);
	},
	safeSlope: function() {
		if (!this.prev) {
			return false;
		}

		var s = (this._current - this._prev) / this._interval;
		console.log('slope: ' + s);

		if (s < 0 && s >= this._decSlop) {
			return true;
		}

		return false;
	},
	//start button on click event
	addStartBtnEventHandle: function() {
		var $start = this.$start;
		var $stop = this.$stop;
		var that = this;
		$start.on('click', function() {
			$start.prop('disabled', true);
			$stop.prop('disabled', false);
			$start.hide();
			$stop.show();
			
			that.setTimer(function() {
				that.read();
			});
		});
	},
	addStopBtnEventHandle: function() {
		var $stop = this.$stop;
		var $start = this.$start;
		var that = this;
		$stop.on('click', function() {
			$start.prop('disabled', false);
			$stop.prop('disabled', true);
			$start.show();
			$stop.hide();
			that.clearTimer();
		});
	},
	init: function() {
		this._battery = this._batteryFull;
		this._insulin = this._insulinFull;
		this._prev = null;
		this._current = null;
		this.$glucose = $('.glucose');
		this.$band = $('#band');
		this.$band2 = $('#band2');
		this.$battery = $('#battery');
		this.$insulin = $('#insulin');
		this.$action = $('#action');
		this.$start = $('#start');
		this.$stop = $('#stop');
		this.$mdate = $('.mdate');
		this.$item = $('.item');
		this.addStartBtnEventHandle();
		this.addStopBtnEventHandle();
	}
};

$(document).ready(function() {
	c.init();
	m.init();
	m.setInterval(15000);
	m.getLatestRecord();
});