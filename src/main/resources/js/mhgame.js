var KEY =
    "Wcq5QMdvBSCsHPDsAjIwNMGloDseMv";
function start(point){
    //1.�����ж�
    if(!isNaN(point)&&point>0&&point<=3000){
        console.log("������ķ���Ϊ"+point);
    }else{
        console.log("�����ʽ����");
        return;
    }
    //1.����ʼ��Ϸ����
    var game_id = requestGameStart();
//       requestGameEnd(game_id,point);
}

function requestGameStart(){
    var urlStart = "http://evt.tiancity.com/mh/51833/home/index.php/flash?fn=start&sign=";
    var _loc2_ = createUid();
    var _loc1_ = "guid=" + _loc2_;
    var  _loc3_ = $.md5("start" + _loc1_ + KEY);
    var url = urlStart + _loc3_;
    console.log(_loc3_);
    console.log("URLΪ��" + urlStart + _loc3_);
    console.log("POST����Ϊ��"+_loc1_);
    var game_id;
    $.ajax({
        url:url,
        type:'post',
        data:{
            guid:_loc2_
        },
        async:false,
        success:function(result){
            console.log(result);
//                var str = result.toString();
//                //�������ر���
//                var res = str.spilt("\\|")
//                console.log(res[0]);
//                console.log(res[1]);
        }
    });
}


function requestGameEnd(game_id,point){
    var urlStart = "http://evt.tiancity.com/mh/51833/home/index.php/flash?fn=over&sign=";
    var _loc3_ = createUid();
    var _loc2_ = "guid=" + _loc3_ + "&game_id=" + game_id + "&point=" + point;
    var _loc4_ = $.md5("over" + _loc2_ + KEY);
    console.log("---------��Ϸ����----------");
    console.log("URLΪ��" + urlStart + _loc4_);
    console.log("POST����Ϊ��" + _loc2_);
}

/**
 * ����UID
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
    _loc1_ = _loc1_ + ("0000000" + _loc5_.toString()).substring( _loc5_.toString().length-8,8);
    _loc3_ = 0;
    while(_loc3_ < 4)
    {
        _loc1_ = _loc1_ + _loc2_.charAt(parseInt(15*Math.random(10)));
        _loc3_++;
    }
    return _loc1_;
}
