function makeConnectionPanel(){
    var s="<h1>Ouvrir la session</h1>"
    +" <form action=\"javascript:(function(){return;})()\" method=\"get\" " 
    +"onsubmit=\"javascript:fconnexion(this)\"> <div class =\"ids\">"
    +"<span>Login </span> <input type=\"text\" name=\"login\" />" 
    +"</div> <div class=\"ids\"><span>Mot de passe</span>"
    +"<input type=\"password\" name=\"pwd\" />"
    +"</div> <div class=\"buttons\"> <input type=\"submit\" name=\"connexion\"/> </div> <div class=\"links\"> <div id=\"link1\">Mot de passe perdu</div> <div id=\"link2\"> <button onclick=\"makeEnregistrementPanel()\"> Pas encore inscrit? </button> </div> </div> </form>";

    $("body").html(s);
}


function makeEnregistrementPanel(){

    var s="<h1>Enregistrement</h1> </div> <form action=\"\" method=\"get\"> <div class =\"ids\"><span>Prenom </span> <input type=\"text\" name=\"prenom\" /> </div> <div class=\"ids\"><span>Nom</span> <input type=\"text\" name=\"nom\" /> </div> <div class =\"ids\"><span>Email </span> <input type=\"text\" name=\"email\" /> </div> <div class =\"ids\"><span>Login </span> <input type=\"text\" name=\"login\" /> </div> <div class=\"ids\"><span>Mot de passe</span> <input type=\"password\" name=\"pwd\" /> </div> <div class=\"ids\"><span>Retapez le Mot de passe</span> <input type=\"password\" name=\"retype\" /> </div> <div class=\"buttons\"> <input type=\"submit\" name=\"connexion\"/> </div> <button onclick=\"makeConnexionPanel()\"> Déjà inscrit? </button>  </form>";

    $("body").html(s);
}

function whichPanel(){
    if(env.login==null){
        makeConnectionPanel();
    }else{
        makeMainPanel();
    }
}
