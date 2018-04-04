
function follow(){
    if(!noConnection){ 
        //appel au serveur
    }

    else{
        responseFellow({});
    }
}


function responseFollow(rep){
    if(rep.error==undefined){
        env.follows.add(env.fromId);
    }   

    if(noConnection){
        follows[env.id].add[env.fromId];
    }
    $("#add").replaceWith("<span id=\"del\">ne plus suivre</span>");

}

function stopFollow(rep){
    if(!noConnection){
        //appel au serveur
    }
    else{
        responseStopFellow({});
    }
}

function responseStopFellow(rep){
    if(rep.error==undefined){
        env.follows.delete(env.fromId);
    }

    if(noConnection){
        follows[env.id].delete[env.fromId];
    }
    $("#add").replaceWith("<span id=\"del\">suivre</span>");
}