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

function getFromLocalDB(from,minId,maxId,nbMax){
	var tab=[];
	var nb=0;
	var f=undefined;
	if(from>0){
		f=follows[from];
		if(undefined==f){
			f=new Set();
		}
	}

	for(var i=0;i<localdb.length;i++){
		if(nbMax>=0 && nb>=nbMax){
			break;
		}
		var n=localdb[i];
		if(n==undefined){
			continue;
		}
		if((maxId<0 || n.id<maxId) && n.id>minId ){
			if(f==undefined || n.auteur.id == f.nom){
				if(f.has(n.auteur.id)){
					tab.push(n);
					nb++;
				}
			}

		}
	}
	return tab;
}