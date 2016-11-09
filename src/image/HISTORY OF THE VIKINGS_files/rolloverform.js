/*
091006 modified rollover.js function to allow for rollover on form image input button
*/

function initformRollovers() 
{
	if (!document.getElementById)
		return;
	
	var aPreLoad = new Array();
	var aPreLoadD = new Array();		// 3-state
	var sTempSrc;
	var aImages = document.getElementsByTagName('input');

	for (var i = 0; i < aImages.length; i++) 
	{
		if (aImages[i].className.match('search-image'))
		{
			var src = aImages[i].getAttribute('src');
			var ftype = src.substring(src.lastIndexOf('.'), src.length);
			var hsrc = src.replace(ftype, '_o'+ftype);
			var dsrc = src.replace(ftype, '_d'+ftype); 		// 3-state

			aImages[i].setAttribute('hsrc', hsrc);
			aImages[i].setAttribute('dsrc', dsrc);
			
			aPreLoad[i] = new Image();
			aPreLoad[i].src = hsrc;
	
			aImages[i].onmouseover = function() 
			{
				sTempSrc = this.getAttribute('src');
				this.setAttribute('src', this.getAttribute('hsrc'));

			}
			
			aImages[i].onmouseout = function()
			{
				if (!sTempSrc)
					sTempSrc = this.getAttribute('src').replace('_o'+ftype, ftype);
				this.setAttribute('src', sTempSrc);

			}

			aImages[i].onmousedown = function()  // 3-state
			{
				this.setAttribute('src', this.getAttribute('dsrc'));

			}

			aImages[i].onmouseup = function() // 3-state
			{
				this.onmouseout();
			}
		}
	}
}

window.onload = initformRollovers;

