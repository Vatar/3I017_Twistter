
function follow(id_friend){
    if(!noConnection){ 
        $.ajax({
            type:"POST",
            url:"AddFriend",
            data:"key="+env.key+"&id_friend="+id_friend,
            datatype:"text",
            success:function(rep){responseFollow(rep)},
            error:function(rep){func_error(rep.error)}
        })
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

function stopFollow(id_friend){
    if(!noConnection){
        $.ajax({
            type:"POST",
            url:"RemoveFriend",
            data:"key="+env.key+"&id_friend="+id_friend,
            datatype:"text",
            success:function(rep){responseStopFollow(rep)},
            error:function(rep){func_error(rep.error)}
        })
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