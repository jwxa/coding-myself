var KEY =
    "Wcq5QMdvBSCsHPDsAjIwNMGloDseMv";
function start(point){
    //1.条件判断
    if(!isNaN(point)&&point>0&&point<=3000){
        console.log("您输入的分数为"+point);
    }else{
        console.log("输入格式有误");
        return;
    }
    //1.请求开始游戏流程
    var game_id = requestGameStart();
//       requestGameEnd(game_id,point);
}

function requestGameStart(){
    var urlStart = "http://evt.tiancity.com/mh/51833/home/index.php/flash?fn=start&sign=";
    var _loc2_ = "4d6a9172936115c75ca979F8A39D71c8";
    var _loc1_ = "guid=" + _loc2_;
    var  _loc3_ = $.md5("start" + _loc1_ + KEY);
    var url = urlStart + _loc3_;
    console.log(_loc3_);
    console.log("URL为：" + urlStart + _loc3_);
    console.log("POST参数为："+_loc1_);
    var game_id;
    $.ajax({
        url:url,
        type:'post',
        beforeSend: function(request) {
            request.setRequestHeader("X-Requested-With", "ShockwaveFlash/18.0.0.209");
        },
        data:{
            guid:_loc2_
        },
        async:false,
        success:function(result){
            console.log(result);
//                var str = result.toString();
//                //解析返回报文
//                var res = str.spilt("\\|")
//                console.log(res[0]);
//                console.log(res[1]);
        }
    });
}


function requestGameEnd(game_id,point){
    var urlStart = "http://evt.tiancity.com/mh/51833/home/index.php/flash?fn=over&sign=";
    var _loc3_ = createUID2();
    var _loc2_ = "guid=" + _loc3_ + "&id=" + game_id + "&point=" + point;
    var _loc4_ = $.md5("over" + _loc2_ + KEY);
    console.log("---------游戏结束----------");
    console.log("URL为：" + urlStart + _loc4_);
    console.log("POST参数为：" + _loc2_);
}

/**
 * 创建UID
 * @returns {string}
 */
function createUid(){
    var _loc3_;
    var _loc4_;
    var _loc1_= "";
    var _loc2_= "0123456789abcdef";
    _loc3_ = 0;

    while(_loc3_ < 8)
    {
        _loc1_ = _loc1_ + _loc2_.charAt(parseInt(15*Math.random(10)));
        _loc3_++;
    }
    _loc3_ = 0;
    while(_loc3_ < 3)
    {
        _loc4_ = 0;
        while(_loc4_ < 4)
        {
            _loc1_ = _loc1_ + _loc2_.charAt(parseInt(15*Math.random(10)));
            _loc4_++;
        }
        _loc3_++;
    }
    var _loc5_ = new Date().getTime();
    _loc1_ = _loc1_ + ("0000000" + _loc5_.toString(16)).substring( _loc5_.toString(16).length-8,8);
    console.log("_loc1_:"+_loc1_);
    _loc3_ = 0;
    while(_loc3_ < 4)
    {
        _loc1_ = _loc1_ + _loc2_.charAt(parseInt(15*Math.random(10)));
        _loc3_++;
    }
    return _loc1_;
}

 function createUID2()
{
    var i;
    var j;
    var uid = "";
    var ALPHA_CHARS = "0123456789abcdef";
    for(i = 0; i < 8; i++)
    {
        uid = uid + ALPHA_CHARS.charAt(Math.round(Math.random() * 15));
    }
    for(i = 0; i < 3; i++)
    {
        for(j = 0; j < 4; j++)
        {
            uid = uid + ALPHA_CHARS.charAt(Math.round(Math.random() * 15));
        }
    }
    var time = new Date().getTime();
    uid = uid + ("0000000" + time.toString(16).toUpperCase()).substr(-8);
    for(i = 0; i < 4; i++) {
        uid = uid + ALPHA_CHARS.charAt(Math.round(Math.random() * 15));
    }
    return uid;
}

