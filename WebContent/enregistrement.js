function enregistrement(formulaire){

    var prenom = formulaire.prenom.value;
    var nom = formulaire.nom.value;
    var login = formulaire.login.value;
    var password = formulaire.password.value;
    var retype = formulaire.retype.value;

    if(verif_formulaire_enregistrement(prenom,nom,login,password,retype)){
        enregistre(login,password); 
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