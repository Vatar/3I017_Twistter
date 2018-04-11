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
	
	var s="Twister";
	if(env.fromID<0){
		s="<title>Twister</title><link href=\"main_simple.css\" rel=\"stylesheet\" type=\"text/css\" /></head><body onLoad=\"javascript:init();javascript:test()\"><script src=\"Message.js\"></script><script>function setVirtualDB(){var v1=new Auteur(1,\"toto\");var com1=new Commentaire(1,v1,\"bla\",new Date());var m1=new Message(1,v1,\"blabla\",new Date(),[com1]);localdb=[m1];follows=[];follows[1]=new Set();follows[1].add(2);}function init(){noConnection=true;env=new Object();env.key=\"ABCD\";env.idUser=1;setVirtualDB();}function test(){s=localdb[0];$(\"#list_message\").html(s.getHTML())}</script><div id=\"list_message\"></div><div id=\"top\"><div id=\"logo\"><IMG SRC=\"logo.png\" ALT=\"logo\"></div><div id=\"deco\"></div></div><div id=\"left\"></div><div id=\"main\"><div id=\"new-message\"></div><div id=\"messages\"></div></div></body></html>";
	}
	else{
		if(env.id==env.fromId){
			//afficher messages
		}
	
		else if(!env.follows.has(env.frontID)){
			//Afficher la page de l'utiliasateyr & proposition de le suivre
		}
	
		else{
			//Afficher utilisateur et proposer de ne plus suivre
		}

	}

	$("body").html(s);
	completeMessages();

}

function pageUser(id,login){
	makeMainPanel(id,login,env.query);
}