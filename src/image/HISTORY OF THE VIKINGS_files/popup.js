<!--


function whatsInFocus(value){
document.info.inFocus.value=value
}
var isNS = false;
var isIE = false;
var isFOX = false;

checkBrowser();

function checkBrowser(){

var brow = navigator.appName;
var agent = navigator.userAgent;

if (brow == "Netscape")
{
	if (agent.indexOf('Firefox') > -1)
	{
	isFOX = true;
	isIE = true;
	}
	else
	{
	isNS = true;
	}
}
else if (brow == "Microsoft Internet Explorer")
{
	isIE = true;
}

}

function replace(string){
var find = / /g;
string = string.replace(find,'%20');
//find = /:/g;
//string = string.replace(find,';');
return string
}
function closeWindow(){
self.close();
}
function closeWindowM(){
top.window.self.close();
}
function treasureDetails(type,url){
window.opener.openWindow(type,url);
}
function loadMainWindow(url){
top.window.opener.location = replace(url);
top.closeWindow();
}
function loadMainWindow2(url){
top.window.opener.location = replace(url);
closeWindowM();
}
function newLocation(path){
	window.location.href = replace(path);
}
function openWindow(type,url){
var extraWidth = 0;
var extraHeight= 0;
var extraHeight2 = 0;
var popup;
var blank;
var popupVar = 'toolbar=no,menubar=no,scrollbars=yes,titlebar=no,alwaysRaised=yes,screenX=0,screenY=0,resizable=yes';
var popupVarNormal = 'toolbar=yes,menubar=yes,scrollbars=yes,titlebar=yes,location=yes,alwaysRaised=yes,screenX=0,screenY=0,resizable=yes';
url=replace(url);
if(isIE){
extraWidth = 12;
extraHeight= 161;
extraHeight2 = 50;
}
switch (type){
case 'treasureplus':
extraHeight= extraHeight + 110;
popup = window.open(url,'popup','width=355,height=585,'+ popupVar);
popup.resizeTo(355+extraWidth,485+extraHeight);
break;
case 'treasure':
popup = window.open(url,'popup','width=355,height=585,'+ popupVar);
popup.resizeTo(355+extraWidth,485+extraHeight);
break;
case 'multiTreasure':
popup = window.open(url,'popup','width=520,height=587,'+ popupVar);
popup.resizeTo(520+extraWidth,487+extraHeight);
break;
case 'quiz':
popup = window.open(url,'popup','width=390,height=430,'+ popupVar);
popup.resizeTo(390+extraWidth,380+extraHeight2);
break;	
case 'sections':
popup = window.open(url,'popup','width=233,height=450,'+ popupVar);
popup.resizeTo(233+extraWidth,360+extraHeight);
break;
case 'sideline':
popup = window.open(url,'popup','width=400,height=500,'+ popupVar);
popup.resizeTo(400+extraWidth,500+extraHeight);
break;
case 'textonly':
popup = window.open(url,'popup','width=370,height=500,'+ popupVar);
popup.resizeTo(370+extraWidth,500+extraHeight);
break;	
case 'gotoPara':
popup = window.open(url,'popup','width=20,height=295,'+ popupVar);
popup.resizeTo(240+extraWidth,195+extraHeight);
break;
case 'rules':
popup = window.open(url,'popup','width=300,height=400,'+ popupVar);
popup.resizeTo(300+extraWidth,300+extraHeight);
break;
case 'details':
popup = window.open(url,'popup','width=300,height=400,'+ popupVar);
popup.resizeTo(300+extraWidth,300+extraHeight);
break;
case 'contract':
popup = window.open(url,'popup','width=640,height=600,'+ popupVar);
popup.resizeTo(640+extraWidth,600+extraHeight);
break;
case 'terms':
popup = window.open(url,'popup','width=500,height=580,'+ popupVar);
popup.resizeTo(500+extraWidth,580+extraHeight);
break;	
case 'HCguides':
popup = window.open(url,'popup','width=520,height=580,'+ popupVar);
popup.resizeTo(520+extraWidth,580+extraHeight);
break;
case 'HCterms':
popup = window.open(url,'popup','width=340,height=365,'+ popupVar);
popup.resizeTo(340+extraWidth,365+extraHeight);
break;
case 'HCsubmit':
popup = window.open(url,'popup','width=390,height=383,'+ popupVar);
popup.resizeTo(390+extraWidth,383+extraHeight);
break;
case 'blank':
blank = window.open(url,'blank','width=750,height=550,'+ popupVarNormal);
blank.focus();
break;
}}
function is13(value){
if(value==13)
return true;
else
return false;
}


function thumbpop(pagetoshowb){
    thumbwin =
	window.open('','thumbwin','width=550,height=500,toolbar=1,location=1,scrollbars=1,resizable=1,screenX=40,screenY=40,top=40,left=40');
    thumbwin.location.href = pagetoshowb ;
    if (thumbwin.opener == null) thumbwin.opener = self; 
    return(0);
}

//-->