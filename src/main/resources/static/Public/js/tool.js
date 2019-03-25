function timeCheckFun(startTime,endTime){
  var t = endTime-startTime;
  //获取年数时间差
  var year=parseInt((t/(1000*60*60*24))/365);
  //获取月数时间差
  var month=parseInt((t/(1000*60*60*24))/30);
  //获取天数时间差
  var days=parseInt(t/(1000*60*60*24));
  //获取小时时间差
  var HH=parseInt(t/(1000*60*60));
  //获取分钟时间差
  var mm=parseInt(t/(1000*60));
  //获取秒时间差
  var ss=parseInt(t/(1000));
  var gaidongtime;
  if(days<=1){
    if(ss<=60){
      gaidongtime="刚刚";
    }else if(ss>60&&ss<=60*60){
      gaidongtime=mm+"分钟前";
    }else if(ss>60*60&&ss<=60*60*24){
      gaidongtime=HH+"小时前";
    }else{
      gaidongtime=days+"天前";
    }
  }else if(days<30&&days>1){
    gaidongtime=days+"天前";
  }else if(days>=30&&days<365){
    var days1=parseInt(days/30);
    gaidongtime=days1+"月前";
  }else if(days>=365){
    var days2=parseInt(days/365);
    gaidongtime=days2+"年前";
  }else{
    gaidongtime="历史很久远";
  }
  return gaidongtime;
 }