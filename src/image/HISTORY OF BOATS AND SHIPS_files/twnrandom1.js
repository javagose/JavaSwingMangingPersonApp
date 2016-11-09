//===This is an included file with links to ThenWhatNext challenges which will be randomised when displayed.

//===Specify total number of links to be randomised on the next line
var alllinks=2

var urls=new Array(alllinks)
var descriptions=new Array(alllinks)


//===Change the following to the text and links you want to feature
//===Add more as required incrementing variable number by 1 each time - remember to increase alllinks above too!
urls[0]="http://www.historyworld.net/chronology/teaser93.asp"
descriptions[0]="US Presidents"

urls[1]="http://www.historyworld.net/chronology/teaser19.asp"
descriptions[1]="World Cities"

var randomlinkvar=Math.floor(Math.random()*alllinks)
