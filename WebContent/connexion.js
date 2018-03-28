function connexion(formulaire){
    var login = formulaire.login.value;
    var password = formulaire.password.value;

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
    if(pwd.length==0 || password.length>19){
        func_error("mot de passe erroné");
        return false;
    }

    return true;
}

function connecte(login,pwd){

    
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