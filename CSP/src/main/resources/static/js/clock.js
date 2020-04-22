//时间
function showTime(){
    var myDate = new Date();
    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    var date = myDate.getDate();
    var dayArray = new Array(7);
    dayArray[0] = "星期日";
    dayArray[1] = "星期一";
    dayArray[2] = "星期二";
    dayArray[3] = "星期三";
    dayArray[4] = "星期四";
    dayArray[5] = "星期五";
    dayArray[6] = "星期六";
    var day1 = myDate.getDay();
    var day = dayArray[day1];
    var hour = myDate.getHours();
    var minute = myDate.getMinutes();
    var second = myDate.getSeconds();
    var min = checkTime(minute);
    var sec = checkTime(second);
    var time1 = year + "年" + month + "月" + date + "日";
    var time2 = hour + "：" + min + "：" + sec;
    // document.write(time1+day+time2);
    //用js方法
    // document.getElementById("time").innerHTML = time1+day+time2;
    //用jquery方法
    $('#date').text(time1);
    $('#week').text(day);
    $('#time').text(time2);
    setTimeout("showTime()",500);
}
function checkTime(i){
    if(i<10){
        i = "0" + i;
    }
    return i;
}

//电子钟表盘
(function($){
    $.fn.drawClock = function(options){
        var mainId = $(this);

        //设置默认参数
        var defaultOptions = {
            'width': '300px',
            'height': '300px',
            'margin': '20px auto',
            'border': '1px solid #888',
            'border-radius': '50%',
            'box-shadow': '2px 2px 4px #111'
        };
        var options = $.extend(defaultOptions, options);

        mainId.css({
            'width': options.width,
            'height': options.height,
            'margin': options.margin,
            'border': options.border,
            'border-radius': options['border-radius'],
            'box-shadow': options['box-shadow'],
            'position': 'relative'
        }).css({
            'background': '-webkit-gradient(radial, ' + mainId.width()/2 + ' ' + mainId.height()/2 + ', 0, ' + mainId.width()/2 + ' ' + mainId.height()/2 + ', ' + mainId.width()/2 + ', from(#ffe), to(#eee))',
            'background': '-moz-radial-gradient(circle closest-side, #ffe 0%, #eee 100%)'
        });

        //钟表盘中心圆
        $("<div id='circle'></div>").appendTo(mainId).css({
            'width': '20px',
            'height': '20px',
            'border-radius': '50%',
            'box-shadow': '0 0 5px rgba(0,0,0,0.8)',
            'position': 'absolute',
            'z-index': 999,
            'background': '-webkit-gradient(radial, ' + mainId.width()/2 + ' ' + mainId.height()/2 + ', 0, ' + mainId.width()/2 + ' ' + mainId.height()/2 + ', ' + mainId.width()/2 + ', from(#ffe), to(#eee))',
            'background': '-moz-radial-gradient(circle, #eee 30%, #ffe 100%)'
        }).css({
            'left': mainId.width()/2 - $('#circle').width()/2,
            'top': mainId.height()/2 - $('#circle').height()/2
        });

        var dateTime = new Date();
        var oHours = dateTime.getHours();
        var oMinutes = dateTime.getMinutes();
        var oSeconds = dateTime.getSeconds();

        //初始化时分秒
        var hPointer = drawPointer(mainId.width()/2, mainId.height()/2, mainId.width()/2*(3/6), 5, "#333", -90+oHours*30+oMinutes*6/12);
        var mPointer = drawPointer(mainId.width()/2, mainId.height()/2, mainId.width()/2*(4/6), 4, "#666", -90+oMinutes*6);
        var sPointer = drawPointer(mainId.width()/2, mainId.height()/2, mainId.width()/2*(5/6), 3, "#f00", -90+oSeconds*6);

        //运动时分秒
        var timer = setInterval(function(){
            dateTime = new Date();
            oHours = dateTime.getHours();
            oMinutes = dateTime.getMinutes();
            oSeconds = dateTime.getSeconds();
            hPointer.css({'transform': 'rotate(' + (-90+oHours*30+oMinutes*6/12) + 'deg)'});
            mPointer.css({'transform': 'rotate(' + (-90+oMinutes*6) + 'deg)'});
            sPointer.css({'transform': 'rotate(' + (-90+oSeconds*6) + 'deg)'});
        }, 1000);


        //绘制钟表刻度
        for(var i=0; i<60; i++){
            var width = 3, height = 6, oBcolor = '#111';
            if(i%5 == 0){
                width = 5;
                height = 10;
            }
            if(i%15 == 0){
                oBcolor = 'red';
            }
            $("<div class='clockMark'></div>").appendTo(mainId).css({
                'width': width,
                'height': height,
                'position': 'absolute',
                'top': 0,
                'left': mainId.width()/2,
                'background': oBcolor,
                'transform': 'rotate(' + i*6 + 'deg)',
                "transform-origin": "0 " + mainId.width()/2+'px'
            });
        }

        //绘制钟表指针
        function drawPointer (startx, starty, width, height, bcolor, angle) {
            var oPointer = $("<div></div>");
            oPointer.appendTo(mainId).css({
                'width': width,
                'height': height,
                'position': 'absolute',
                'top': starty,
                'left': startx,
                'background': bcolor,
                'transform': 'rotate(' + angle + 'deg)',
                'transform-origin': '0 0'
            });
            return oPointer;
        }
        return this;
    }
})(jQuery);
