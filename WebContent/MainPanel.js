/**
 * 
 */


function makeMainPanel(fromID,fromLogin,query){
	env.msgs=[];
	if(fromID=undefined){
		fromID=-1;
	}
	
	env.fromID=fromID;
	env.fromLogin=fromLogin;
	
	var s="";
	if(env.fromID<0){
		s="<div id=\"table\">Actualités....";
	}
	else{
		if(env.id==end.fromId){
			//afficher messages
		}
	
		else if(!env.follows.has(env.frontID)){
			//Afficher lka page de l'utiliasateyr & proposition de le suivre
		}
	
		else{
			//Afficher utilisateur et proposer de ne plus suivre
		}

	}

	$(body).html(s);
	completeMessages();

}

function pageUser(id,login){
	makeMainPanel(id,login,env.query);
}