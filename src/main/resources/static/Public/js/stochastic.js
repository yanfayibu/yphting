
//产生不重复的随机数 mynum 产生数量  mywei 生成位数 callback 回调函数
var bossRand = function(mynum,mywei,callback){
            var RandomArr = [];
            var RandomTotal= 0;
            function createRandom(num ,wei){
                if(RandomArr.length==0){
                    RandomTotal = num;
                }
                var start = "1";
                var end ="9";
                var wint = parseInt(wei);
                for(var i=1;i<wint;i++){
                    start+="0"
                    end+="0";
                }
                for(var i=0;i<parseInt(num);i++){
                    var code =parseInt(Math.random()*parseInt(end)+parseInt(start));
                    var str = ","+RandomArr.toString()+",";
                    if(str.indexOf(","+code+",")==-1){
                        RandomArr.push(code);
                    }
                }
                //Remove duplication
                var cha = RandomTotal-RandomArr.length;
                if(cha<=0){
                    callback(RandomArr)
                    RandomArr=[];
                    RandomTotal=0;
                    return;
                }else{
                    createRandom(cha,wei)
                }
            }
            createRandom(mynum,mywei);
}
	
	