package KotlinGame

import java.util.*


fun main() {
    var gaResult = GameResult()
    gaResult.gameResult()
}

/*结果类*/
class GameResult() {
    //谁先赢3次谁就赢
    fun gameResult() {
        var kotlonGama = KotlinGama()
        while (kotlonGama.jiaYing <= 2 && kotlonGama.yiYing <= 2) {
            kotlonGama.game()
            println("平局数量为:" + kotlonGama.ping)
            println("甲胜数量为:" + kotlonGama.jiaYing)
            println("乙胜数量为:" + kotlonGama.yiYing)
        }
        /*
                比如：X是总次数 Y是胜
                公式是这样的：(100/X)*Y=胜率公式
               */
        var sum = kotlonGama.yiYing + kotlonGama.jiaYing + kotlonGama.ping
        //甲的胜率
        var winJ = (100 / sum) * kotlonGama.jiaYing
        //乙的胜率
        var winY = (100 / sum) * kotlonGama.yiYing
        println("--------------------");
        println("共计局数:" + sum);
        println("甲的胜率:" + winJ + "%");
        println("乙的胜率:" + winY + "%");

    }

}

/*游戏类*/
class KotlinGama() {
    /*平局ping
      甲赢jiaYing
      乙赢yiYing
    */
    var ping: Int = 0
    var jiaYing: Int = 0
    var yiYing: Int = 0
    fun game() {
        //取甲的值
        var jia = Jia()
        jia?.game()
        println("甲---${jia?.chuquan}")
        val chuquanJ = jia.chuquan
        //取乙的值
        var yi = Yi()
        yi?.game()
        println("乙---${yi?.chuquan}")
        val chuquanY = yi.chuquan

        if (chuquanJ == "石头") {
            if (chuquanY == "石头")
                ++ping
            else if (chuquanY == "剪刀")
                ++jiaYing
            else if (chuquanY == "布")
                ++yiYing
        } else if (chuquanJ == "剪刀") {
            if (chuquanY == "石头")
                ++yiYing
            else if (chuquanY == "剪刀")
                ++ping
            else if (chuquanY == "布")
                ++jiaYing
        } else if (chuquanJ == "布") {
            if (chuquanY == "石头")
                ++jiaYing
            else if (chuquanY == "剪刀")
                ++yiYing
            else if (chuquanY == "布")
                ++ping
        }
    }
}

/*初始出拳类*/
open class Person() {
    var chuquan: String? = null
    open fun game(): String? {
        var random = Random().nextInt(3) + 1
        if (random == 1) {
            chuquan = "石头"
        } else if (random == 2)
            chuquan = "剪刀"
        else if (random == 3)
            chuquan = "布"
        return chuquan
    }
}

/*角色甲*/
class Jia() : Person() {
    override fun game(): String? {
        if (chuquan == "布" || chuquan != null) {
            var random = Random().nextInt(2) + 1
            if (random == 1)
                chuquan = "石头"
            else if (random == 2)
                chuquan = "剪刀"
        } else {
            super.game()
        }
        return chuquan
    }
}

/*角色乙*/
class Yi() : Person() {
    override fun game(): String? {
        if (chuquan == "石头" || chuquan != null) {
            chuquan = "剪刀"
        } else {
            super.game()
        }
        return chuquan
    }

}