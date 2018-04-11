function fconnexion(formulaire){

    var login = formulaire.login.value;
    var password = formulaire.pwd.value;
   
    if(verif_formulaire_connexion(login,password)){
        connecte(login,password);
    }
    return;
}

function verif_formulaire_connexion(login,pwd){
    if(login.length==0 || login.length >19){
        func_error("login erroné");
        return false;
    }
    if(pwd.length==0 || pwd.length>19){
        func_error("mot de passe erroné");
        return false;
    }

    return true;
}

function connecte(login,pwd){
    console.log("connecte"+login+";"+pwd);
    if(!noConnection){
        $.ajax({
            type:"POST",
            url:"login",
            data:"login="+login+"&pwd="+pwd,
            datatype:"text",
            success:function(rep){responseConnexion(rep)},
            error:function(rep){func_error(rep.error)}
        })
    }
    else{
        responseConnexion(JSON.stringify( {"key":1,"id":1,"login":"toto",
    "follows":[2] } ));
        
    }
}


function responseConnexion(rep){
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

