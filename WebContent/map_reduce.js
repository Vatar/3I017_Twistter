function calculDF(){
    var text=this.text;
    var id=this.id;
    var words=text.match("/\w+\g");
    var tf={};

    for(var i=0;i<words.length();i++){
        if(tf[words[i]]==null){
            tf[words[i]]+=1;
        }
        else{}   
    }

}