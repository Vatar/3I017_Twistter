/**
 * 
 */



function Auteur(id,login){
	this.id=id;
	this.login=login;
}

Auteur.prototype.getHTML =
	function(){
	s="<div id=\"auteur"+ this.id +"\">" +
			"<div>"+this.login+"</div>";
		return s;
}


function Commentaire(id,auteur,texte,date){
	this.id=id;
	this.auteur=auteur;
	this.texte=texte;
	this.date=date;
}

Commentaire.prototype.getHTML=
	function(){
	s="<div id=\"commentaire"+ this.id +"\">" +
			"<div><div>"+this.auteur+"</div>" +
					"<div>"+this.date+"</div></div>" +
							"<div>"+this.texte+"</div>" +
									"</div>";
		return s;
	}

function Message(id,auteur,texte,date,comments){
	this.id=id;
	this.auteur=auteur;
	this.texte=texte;
	this.date=date;
	if(comments==undefined){
		comments=[];
	}
	this.comments=comments;
	
}

Message.prototype.getHTML=
	function(){
	s="<div id=\"message"+ this.id +"\">" +
			"<div><div>"+this.auteur.getHTML()+"</div>" +
					"<div>"+this.date+"</div></div>" +
							"<div>"+this.texte+"</div>" +
									"</div>";
		for(var i=0;i<this.comments.length;i++){
			s+=this.comments[i].getHTML();
		}
		s+="</div></div>"
			return s;
	}

M1=function(key,val){
	if(!val.com==undefined){
		return new Message(val.id,val.auteur,val.texte,val.date);
	}
	
	return new Message(val.id,val.auteur,val.texte,val.date);
}

function completeMessages(){
	if(!noConnection){
		$.ajax({
			type="POST",
			url="listMsg",
			data="key="+env.key+"&query="+env.query+"&from="+env.fromId+"&id_max="+env.minId,
			datatype="text",
			success=function(rep){completeMessagesReponse(rep);},
			error=function(rep){func_error(rep.error);}
		})
	}
	else{
		var tab=getFromLocalDB(env.fromId,1,1);
		completeMessagesReponse(JSON.stringify(tab));
	}
}


function completeMessagesReponse(rep){
	var tab=JSON.parse(rep,M1);
	var s="";
	for(var i=0;i<tab.length;i++){
		var n=tab[i];
		alert(n.getHTML());
		s+=n.getHTML();
		env.msgs[n.id]=n;
		if(n.id>env.maxId){
			env.maxId=n.Id;
		}
		if(env.minId<0 || (n.id < env.minId)){
			env.minId=n.Id; 
		}
	$("#message".append(html(s)));
	}
	
}

function refreshMessages(){
	if(!noConnection){
		$.ajax({
			type="POST",
			url="listMsg",
			data="key"+env.key+"&id_max=-1&id_min="+env.maxId+"nb=-1",
			datatype="text",
			success=function(rep){refreshMessagesReponse(rep);},
			error=function(rep){func_error(rep.error)}
		})
	}
}

function refreshMessagesReponse(rep){
	var tab=JSON.parse(rep,M1);
	for(var i=tab.length-1;i>=0;i++){
		var n=tab[i];
		$("#messages").prepend(n.getHTML());
		env.msgs[n.id]=n;
		//a finir
	}


}




