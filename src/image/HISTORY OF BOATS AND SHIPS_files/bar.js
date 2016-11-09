<!--
if(document.images){
menuFind2 = new Image
menuFind2.src = "/CImg/glo_find2.gif"
menuFind1 = new Image
menuFind1.src = "/CImg/glo_find1.gif"
menuHome2 = new Image
menuHome2.src = "/CImg/glo_home2.gif"
menuHome1 = new Image
menuHome1.src = "/CImg/glo_home1.gif"
menuGopara2 = new Image
menuGopara2.src = "/CImg/glo_gopara2.gif"
menuGopara1 = new Image
menuGopara1.src = "/CImg/glo_gopara1.gif"
menuHC2 = new Image
menuHC2.src = "/CImg/glo_historyclub2.gif"
menuHC1 = new Image
menuHC1.src = "/CImg/glo_historyclub1.gif"
menuWH2 = new Image
menuWH2.src = "/CImg/glo_txtwrldhis2.gif"
menuWH1 = new Image
menuWH1.src = "/CImg/glo_txtwrldhis1.gif"
menuTL2 = new Image
menuTL2.src = "/CImg/glo_txttimelines2.gif"
menuTL1 = new Image
menuTL1.src = "/CImg/glo_txttimelines1.gif"
menuA2 = new Image
menuA2.src = "/CImg/glo_txtarticles2.gif"
menuA1 = new Image
menuA1.src = "/CImg/glo_txtarticles1.gif"
}
function IndexSearch(type){
var indexsearch = document.info.indexSearch.value
if (indexsearch!=''){
if(type=='HW')
newLocation(replace('/index/indexsearch.asp?indexsearch='+ indexsearch));
}}
function showMenu(which){
switch(which){
case 'articles':
if (isIE){
document.all["A"].style.zIndex=80;
document.all["Amenu"].style.visibility='visible';
document.all["closer"].style.visibility='visible';
}else{
if(parseInt(navigator.appVersion)>=5){
document.getElementById("A").style.zIndex=80;
document.getElementById("Amenu").style.visibility='visible';
document.getElementById("closer").style.visibility='visible';
}else{
document.layers["A"].zIndex=80;
document.layers["Amenu"].visibility='visible';
document.layers["closer"].visibility='visible';
}}	
break;
case 'worldhistory':
if (isIE){
document.all["WH"].style.zIndex=80;
document.all["WHmenu"].style.visibility='visible';
document.all["closer"].style.visibility='visible';
}else{
if(parseInt(navigator.appVersion)>=5){
document.getElementById("WH").style.zIndex=80;
document.getElementById("WHmenu").style.visibility='visible';
document.getElementById("closer").style.visibility='visible';
}else{
document.layers["WH"].zIndex=80;
document.layers["WHmenu"].visibility='visible';
document.layers["closer"].visibility='visible';
}}	
break;
case 'timelines':
if (isIE){
document.all["TL"].style.zIndex=80;
document.all["TLmenu"].style.visibility='visible';
document.all["closer"].style.visibility='visible';
}else{
if(parseInt(navigator.appVersion)>=5){
document.getElementById("TL").style.zIndex=80;
document.getElementById("TLmenu").style.visibility='visible';
document.getElementById("closer").style.visibility='visible';
}else{
document.layers["TL"].zIndex=80;
document.layers["TLmenu"].visibility='visible';
document.layers["closer"].visibility='visible';
}}
break;
case 'home':
if (isIE){
document.all["HW"].style.zIndex=80;
document.all["HWmenu"].style.visibility='visible';
document.all["closer"].style.visibility='visible';
}else{
 if(parseInt(navigator.appVersion)>=5){
  document.getElementById("HW").style.zIndex=80;
  document.getElementById("HWmenu").style.visibility='visible';
  document.getElementById("closer").style.visibility='visible';
 }else{
document.layers["HW"].zIndex=80;
document.layers["HWmenu"].visibility='visible';
document.layers["closer"].visibility='visible';
}}
break;
}}
function hideMenu(){
if (isIE){
document.all["A"].style.zIndex=10;
document.all["WH"].style.zIndex=10;
document.all["TL"].style.zIndex=10;
document.all["HW"].style.zIndex=10;
document.all["Amenu"].style.visibility='hidden';
document.all["WHmenu"].style.visibility='hidden';
document.all["TLmenu"].style.visibility='hidden';
document.all["HWmenu"].style.visibility='hidden';
document.all["closer"].style.visibility='hidden';
}else{
if(parseInt(navigator.appVersion)>=5){
document.getElementById("A").style.zIndex=10;
document.getElementById("WH").style.zIndex=10;
document.getElementById("TL").style.zIndex=10;
document.getElementById("HW").style.zIndex=10;
document.getElementById("Amenu").style.visibility='hidden';
document.getElementById("WHmenu").style.visibility='hidden';
document.getElementById("TLmenu").style.visibility='hidden';
document.getElementById("HWmenu").style.visibility='hidden';
document.getElementById("closer").style.visibility='hidden';;
}else{
document.layers["A"].zIndex=10;
document.layers["WH"].zIndex=10;
document.layers["TL"].zIndex=10;
document.layers["HW"].zIndex=10;
document.layers["Amenu"].visibility='hidden';
document.layers["WHmenu"].visibility='hidden';
document.layers["TLmenu"].visibility='hidden';
document.layers["HWmenu"].visibility='hidden';
document.layers["closer"].visibility='hidden';
}}}
//-->