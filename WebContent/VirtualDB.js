/**
 * 
 */

function setVirtualDB(){
	localdb=[]
	follows=[]
	var v1={id:1,login:"toto"};
	follows[1]=new Set();
	follows[1].add(2);
	
	var com1=new Commentaire(1,v1,"bla",new Date());
	var m1=new Message(1,v1,"blabla",new Date(),[com1]);
	localdb[1]=m1;
}

function init(){
	noConnection=true;
	env=new Object();
	env.key="ABCD";
	env.idUser=1;
	setVirtualDB();
	
}