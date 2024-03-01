var c = {
	$ddmenu: null, // dropdown menu jquery object
	$bgr: null, // buger icon jquery object
	$preloader:null,
	addBgrBtnEventHandle: function() {
		var $ddmenu = this.$ddmenu;
		this.$bgr.on('click', function() {
			var $this = $(this);
			$this.toggleClass('open');
	
			if ($this.hasClass('open')) {
				$ddmenu.show();
				return;
			}
			
			$ddmenu.hide()
		});
	},
	hidePreloader: function() {
		this.$preloader.css('display', 'none');
	},
	showPreloader: function() {
		this.$preloader.css('display', 'flex');
	},
	init: function() {
		this.$ddmenu = $('#ddmenu');
		this.$preloader = $('.preloaderDiv');
		this.$bgr = $('#bgr');
		this.addBgrBtnEventHandle();
	}
};