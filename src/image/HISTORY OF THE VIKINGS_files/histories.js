<!--
function makePath(nid,pid,from,back){
	return 'histories.asp?nid='+ nid +'&pid='+ pid +'&from='+ from +'&back='+ back;
}
function GoTo(where){
	var pid = document.info.pid.value;
	var	nid = document.info.nid.value;
	var from = document.info.from.value;
	var back = escape(document.info.back.value);
	var selection = document.info.selection.value;
	var view = document.info.view.value;
	var path;
	switch (where){
		case 'WWW':
			path = 'whwhwh.asp?pid='+ pid +'&nid='+ nid +'&main=False&selection='+ selection +'&view='+ view;
			newLocation(path);
			break;
		case 'T':
			path = 'tours.asp?pid='+ pid +'&nid='+ nid + '&main=False&selection='+ selection +'&view='+ view;
			newLocation(path);
			break;
		case 'textonly':
			openWindow('textonly',replace('/textonly/textonly.asp?type=histories&pid='+ pid +'&nid='+ nid));
			break;
		case 'textonlylllm':
			openWindow('textonly',replace('/textonly/textonly.asp?type=historieslllm&pid='+ pid +'&nid='+ nid));
			break;	
		case 'sections':
			var title = document.info.title.value;
			openWindow('sections',replace('wrldhis_sections.asp?title='+ title +'&nid='+ nid+'&from='+ from +'&back='+ back +'#'+pid));	
			break;
		case 'dropDown':
			pid = document.info.headlines[document.info.headlines.selectedIndex].value;
			if (pid == -1)
				pid = document.info.headlines[document.info.headlines.selectedIndex+1].value;
			else if (pid == -2)
				pid = document.info.headlines[document.info.headlines.selectedIndex-1].value;
			if(pid!='')
				newLocation(makePath(nid,pid,from,back));
			break;
		case 'before':
			nid = document.info.nid.value;
			pid = document.info.bpid.value;
			if (pid != '')
				newLocation(makePath(nid,pid,from,back));
			break;
		case 'after':
			nid = document.info.nid.value;
			pid = document.info.apid.value;
			if (pid != '')
				newLocation(makePath(nid,pid,from,back));
			break;
		case 'treasure':
			var No5;
			var Id5;
			No5 = document.info.No5.value;
			Id5 = document.info.Id5.value;
			openWindow('treasure','/images/imagepopup.asp?No5='+ No5 +'&Id5='+Id5);
			break;
		case 'back':
			var back = document.info.back.value;
			newLocation(replace(back));
}}
function sidelineGoTo(sdlid, sdltitle){
	openWindow('sideline',replace('notes.asp?sdlid='+ sdlid +'&sdltitle='+ sdltitle));
}
function referenceGoTo(ntitle, nid, pid){
	var from = document.info.from.value;
	var back = escape(document.info.back.value);
	if (pid != '')
		newLocation(makePath(nid,pid,from,back));
}
if(document.images){
txtonly2 = new Image
txtonly2.src = "img/btn_txtonly2.gif"
txtonly1 = new Image
txtonly1.src = "img/btn_txtonly1.gif"
sections2 = new Image
sections2.src = "/CImg/btn_dissections2.gif"
sections1 = new Image
sections1.src = "/CImg/btn_dissections1.gif"
tothti2 = new Image
tothti2.src = "img/btn_tothti2.gif"
tothti1 = new Image
tothti1.src = "img/btn_tothti1.gif"
whwhwh2 = new Image
whwhwh2.src = "img/btn_whwhwh2.gif"
whwhwh1 = new Image
whwhwh1.src = "img/btn_whwhwh1.gif"
scrollup2 = new Image
scrollup2.src = "img/contentscroll_up2.gif"
scrollup1 = new Image
scrollup1.src = "img/contentscroll_up1.gif"
scrolldown2 = new Image
scrolldown2.src = "img/contentscroll_down2.gif"
scrolldown1 = new Image
scrolldown1.src = "img/contentscroll_down1.gif"
enlargeimg2 = new Image
enlargeimg2.src = "img/btn_enlargeimg2.gif"
enlargeimg1 = new Image
enlargeimg1.src = "img/btn_enlargeimg1.gif"
prev2 = new Image
prev2.src = "img/ppage2.gif"
prev1 = new Image
prev1.src = "img/ppage1.gif"
next2 = new Image
next2.src = "img/npage2.gif"
next1 = new Image
next1.src = "img/npage1.gif"
top2 = new Image
top2.src = "img/top2.gif"
top1 = new Image
top1.src = "img/top1.gif"
ppg2 = new Image
ppg2.src = "img/printpage2.gif"
ppg1 = new Image
ppg1.src = "img/printpage1.gif"
phis2 = new Image
phis2.src = "img/printhistory2.gif"
phis1 = new Image
phis1.src = "img/printhistory1.gif"
ibut2 = new Image
ibut2.src = "img/interactive2.gif"
ibut1 = new Image
ibut1.src = "img/interactive1.gif"
int2 = new Image
int2.src = "img/textonly2.gif"
int1 = new Image
int1.src = "img/textonly1.gif"
playwq1 = new Image
playwq1.src = "../CImg/adplay.gif"
playwq2 = new Image
playwq2.src = "../CImg/adplay_o.gif"

}
//-->
