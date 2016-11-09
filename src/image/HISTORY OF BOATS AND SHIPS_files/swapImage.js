<!--
function swapImg(name, newImg) {
	if (document.images)
		document[name].src = eval(newImg+".src");
}
function swapImageSpecial(name, newImg) {
var check1 = document[name].src;
var check2 = name+"4.gif";
	if (document.images)
		if (check1.indexOf(check2) == -1)
			document[name].src = eval(newImg+".src");
}
function Show(show,hide){
var check1 = document[show].src;
var check2 = show+"4.gif";
	if (check1.indexOf(check2) == -1){
		if(isIE){
			document.all[hide +'Layer'].style.visibility='hidden';
			document.all[show +'Layer'].style.visibility='visible';
}else{
if(parseInt(navigator.appVersion)>=5){
document.getElementById(hide +'Layer').style.visibility='hidden';
document.getElementById(show +'Layer').style.visibility='visible';
}else{
			document.layers[hide +'Layer'].visibility='hidden';
			document.layers[show +'Layer'].visibility='visible';
}}
		swapImg(show,show +'4');
		swapImg(hide,hide +'1');
		document.info.view.value=show;
}}
function toggleDateTypes(dateType){
	if (dateType=='BC'){
		swapImg('datebc','datebc4');
		swapImg('datead','datead1');
		document.info.DT.value = 'BC';
}else if (dateType=='AD'){
		swapImg('datead','datead4');
		swapImg('datebc','datebc1');
		document.info.DT.value = 'AD';	
}}
//-->

