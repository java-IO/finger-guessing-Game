/*使用时，直接调用game方法即可*/

var Jia = {
    /*甲方法*/
    jia: function () {
        var jia = Math.floor(Math.random() * 3 + 1);//甲出拳
        var numJ = 0;//甲出布的计数（numJ=0）
        if (numJ == 1) {
            jia = Math.floor(Math.random() * 2 + 1);//甲出拳
            numJ = 0
        }
        if (jia == 3) {
            numJ++;
        }
        // console.log("甲：" + jia, numJ)
        return jia
    }
};

var Yi = {
    /*乙方法*/
    yi: function () {
        var yi = Math.floor(Math.random() * 3 + 1);//乙出拳
        var numY = 0;//乙出布的计数
        if (numY == 1) {
            yi = 2;//甲出拳
            numY = 0
        }
        if (yi == 1) {
            numY++;
        }
        // console.log("乙：" + yi, numY)
        return yi
    }
};

var game = {
    /*游戏方法*/
    game: function () {
        var jiaYing = 0;//甲赢
        var yiYing = 0;//乙赢
        var ping = 0;//平局
        for (i = 0; jiaYing <= 2 && yiYing <= 2; i++) {
            jia = Jia.jia();
            yi = Yi.yi();
            if (jia == 1) {
                if (yi == 1) {
                    console.log("甲：石头---乙：石头 = 平局");
                    ping++;
                    console.log("平局：" + ping)
                } else if (yi == 2) {
                    console.log("甲：石头---乙：剪刀 = 甲赢");
                    jiaYing++;
                    console.log("甲赢：" + jiaYing)


                } else if (yi == 3) {
                    console.log("甲：石头---乙：布 = 乙赢");
                    yiYing++;
                    console.log("乙赢：" + yiYing)

                }
            }
            if (jia == 2) {
                if (yi == 1) {
                    console.log("甲：剪刀---乙：石头 = 乙赢");
                    yiYing++;
                    console.log("乙赢：" + yiYing)

                } else if (yi == 2) {
                    console.log("甲：剪刀---乙：剪刀 = 平局");
                    ping++;
                    console.log("平局：" + ping)

                } else if (yi == 3) {
                    console.log("甲：剪刀---乙：布 = 甲赢");
                    jiaYing++;
                    console.log("甲赢：" + jiaYing)

                }
            }
            if (jia == 3) {
                if (yi == 1) {
                    console.log("甲：布---乙：石头 = 甲赢");
                    jiaYing++;
                    console.log("甲赢：" + jiaYing)

                } else if (yi == 2) {
                    console.log("甲：布---乙：剪刀 = 乙赢");
                    yiYing++;
                    console.log("乙赢：" + yiYing)

                } else if (yi == 3) {
                    console.log("甲：布---乙：布 = 平局");
                    ping++;
                    console.log("平局：" + ping)

                }
            }
        }
        console.log("游戏结束")
        /*
        比如：X是总次数 Y是胜
       公式是这样的：(100/X)*Y=胜率公式
       */
        sum = jiaYing + yiYing + ping;
        winJ = (100 / sum) * jiaYing;//甲的胜率
        winY = (100 / sum) * yiYing; //乙的胜率
        console.log("共计局数：" + sum);
        console.log("平局：" + ping);
        console.log("甲赢:" + jiaYing + "----甲的胜率：" + winJ + "%");
        console.log("乙赢:" + yiYing + " ----乙的胜率：" + winY + "%");

    }
};