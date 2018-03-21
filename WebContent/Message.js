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


function completeMessagesReponse(rep){
	var tab=JSON.parse(rep,M1);
	var s="";
	
}








