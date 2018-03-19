$(function() {
		//setMenuHeight
		$('.menu').height($(window).height() - 51 - 27 - 26);
		$('.sidebar').height($(window).height() - 51 - 27 - 26);
		$('.page').height($(window).height() - 51 - 27 - 26);
		$('.page iframe').width($(window).width() - 15 - 168);

		//menu on and off
		$('.btn').click(function() {
			$('.menu').toggle();

			if ($(".menu").is(":hidden")) {
				$('.page iframe').width($(window).width() - 15 + 5);
			} else {
				$('.page iframe').width($(window).width() - 15 - 168);
			}
		});

		//
		$('.subMenu a[href="#"]').click(function() {
			$(this).next('ul').toggle();
			return false;
		});
	})

