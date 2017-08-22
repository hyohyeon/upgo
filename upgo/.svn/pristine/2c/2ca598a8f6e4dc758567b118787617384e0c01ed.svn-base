function Popup(boxID, iframeURL) {
    this.boxID = boxID;
    this.iframeURL = iframeURL;
    this.$box = $("<div id=\"popup_" + boxID + "\" style=\"position:absolute; left:0; top:0; z-index:40;\"></div>");
    this.$disabledBox = $("<div id=\"popup_" + boxID + "_BG\" style=\"position:absolute; left:0; top:0; z-index:35; width:100%; margin:0; padding:0 0 20px 0; background-color:#000;\"></div>");
    $("body").append(this.$box);
    $("body").append(this.$disabledBox);

    this.$box.hide();
    this.$disabledBox.hide();
    this.SetOpacity(this.$disabledBox, 0.5);
}

Popup.prototype.View = function() {
    //var footerPos = $("#footer").offset();
    //this.$disabledBox.height(footerPos.top + $("#footer").outerHeight(true));
    var innerHtml = "<iframe src=\"" + this.iframeURL + "\" width=\"1\" height=\"1\" frameborder=\"0\" scrolling=\"no\"></iframe>";
    this.$box.html(innerHtml);
    this.$box.show();
}

Popup.prototype.SetPosition = function() {
    var boxLeft = (this.$disabledBox.outerWidth() - this.$box.outerWidth()) / 2;
    var boxTop = $(document).scrollTop() + 250;

    this.$box.css({ "left": boxLeft + "px", "top": boxTop });

    this.$disabledBox.height($(document).height());
    this.$disabledBox.show();
}

Popup.prototype.SetResize = function(width, height) {
    this.$box.css({ "width": width + "px", "height": height + "px" });
    this.$box.find("iframe").css({ "width": width + "px", "height": height + "px" });
    this.SetPosition();    
}

Popup.prototype.SetOpacity = function(el, opacity) {
    if ($.browser.msie) {
        el.css("filter", "alpha(opacity=" + (opacity * 100) + ")");
    }
    else {
        el.css("opacity", opacity);
    }
}

Popup.prototype.Close = function() {
    this.$disabledBox.hide();
    this.$box.hide();
}


var PopupLib = {
    Init: function() {
	var $items = $("div.popupBox");

	for (var i = -1; ++i < $items.length; ) {
	    var savedValue = parseInt(cookie.get($items.eq(i).attr("id")));

	    if (!isNaN(savedValue)) {
		var today = new Date();

		if (today.getDate() == savedValue) $items.eq(i).show();
	    }
	    else
		$items.eq(i).show();
	}
    },

    NotSeeToday: function(popID) {
	var today = new Date();
	var nextDay = new Date(today.getFullYear(), today.getMonth(), today.getDate() + 1);

	cookie.set(popID, nextDay.getDate(), nextDay);

	this.Close(popID);
    },

    Close: function(popID) {
	var $currentBox = $("#" + popID);

	if ($currentBox.length > 0) {
	    $currentBox.hide();
	}
    }
}