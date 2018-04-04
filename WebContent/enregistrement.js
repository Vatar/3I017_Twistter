function enregistrement(formulaire){

    var prenom = formulaire.prenom.value;
    var nom = formulaire.nom.value;
    var login = formulaire.login.value;
    var password = formulaire.password.value;
    var retype = formulaire.retype.value;

    if(verif_formulaire_enregistrement(prenom,nom,login,password,retype)){
        enregistre(prenom,nom,login,password); 
    }
    return;
}

function verif_formulaire_enregistrement(prenom,nom,login,pwd,retype){
    if(login.length==0 || login.length >19){
        func_error("login erroné");
        return false;
    }
    if(pwd.length==0 || password.length>19){
        func_error("mot de passe erroné");
        return false;
    }

    if(prenom.length==0 || prenom.length>19){
        func_error("prenom erroné");
        return false;
    }

    if(nom.length==0 || nom.length>19){
        func_error("nom erroné");
        return false;
    }

    if(retype.length==0 || retype.length>19 || pwd.valueOf()!=retype.valueOf() ){
        func_error("veuillez retapez le mot de passe correctement");
        return false;
    }

    return true;
}


function enregistre(prenom,nom,login,pwd){
    console.log("enregistre"+login+";"+pwd);
    if(!noConnection){
        $.ajax({
            type:"POST",
            url:"CreateUser",
            data:"prenom="+prenom+"&nom="+nom+"&login="+login+"&pwd="+pwd,
            datatype:"text",
            success:function(rep){responseEnregistrement(rep)},
            error:function(rep){func_error(rep.error)}
        })
    }
    else{
        responseEnregistrement(JSON.stringify( {"key":key,"id":1,"login":toto,
    "follows":[2] } ));
        
    }
}



function responseEnregistrement(rep){
    resp=JSON.parse(rep);
    if(rep.error==undefined){
        env.key=resp.key;
        env.id=resp.id;
        env.login=resp.login;
        env.follows=new Set();
        for(var i=0;i<resp.follows.length;i++){
            env.follows[resp.follows[i]];
        }
    }

    if(!noConnection){
        env.follows[rep.id]=new Set();
        for(var i=0;i<resp.follows[rep.id].length;i++){
            env.follows[rep.id]=resp.follows[rep.id][i];
        }

    
    makeMainPanel(-1,-1,-1);

    }

    else{
        func_error(rep.error);
    }

}


function func_error(msg){
    var msg_box="<div id= \"err_msg\"> "+msg+"</div>";
    var old_msg=$("#css_msg");
    if(old_msg.length==0){
        $("form").prepend(msg_box);
    }
    else{
        old_msg.replaceWith(msg_box);
    }
    $("#err_msg").css("color.red");
}