package javaGame;

import java.util.Random;

/**
 * 测试类
 */
class JavaGame {
    public static void main(String[] args) {
        GameResult game = new GameResult();
        game.game();
    }
}

/**
 * 结果类
 */
class GameResult {
    Jia jia = new Jia();
    Yi yi = new Yi();
    Game game1 = new Game();

    /*统计所有次数及甲的胜率*/
    public void game() {
        while (game1.getYiYing() <= 2 && game1.getJiaYing() <= 2) {
            // for (int i = 0; game1.getJiaYing() <= 2 && game1.getYiYing() <= 2; i++) {
            jia.guess();
            yi.guess();
            game1.game(jia, yi);
            System.out.println("平局数量为:" + game1.getPing());
            System.out.println("甲胜数量为:" + game1.getJiaYing());
            System.out.println("乙胜数量为:" + game1.getYiYing());
        }
        // }
        /*
         比如：X是总次数 Y是胜
         公式是这样的：(100/X)*Y=胜率公式
        */
        int sum = game1.getYiYing() + game1.getJiaYing() + game1.getPing();
        //甲的胜率
        int winJ = (100 / sum) * game1.getJiaYing();
        //乙的胜率
        int winY = (100 / sum) * game1.getYiYing();
        System.out.println("--------------------");
        System.out.println("共计局数:" + sum);
        System.out.println("甲的胜率:" + winJ + "%");
        System.out.println("乙的胜率:" + winY + "%");
    }
}

/**
 * 游戏类
 */
class Game {
    /*平局ping
      甲赢jiaYing
      乙赢yiYing
 */
    private int ping;
    private int jiaYing;
    private int yiYing;

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public int getJiaYing() {
        return jiaYing;
    }

    public void setJiaYing(int jiaYing) {
        this.jiaYing = jiaYing;
    }

    public int getYiYing() {
        return yiYing;
    }

    public void setYiYing(int yiYing) {
        this.yiYing = yiYing;
    }

    /*猜拳的规则*/
    public void game(Jia jia, Yi yi) {
        //获取甲乙的出拳
        String chuquanJ = jia.getChuquan();
        String chuquanY = yi.getChuquan();
        if (chuquanJ == "石头") {
            if (chuquanY == "石头") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=平局");
                setPing(getPing() + 1);
            } else if (chuquanY == "剪刀") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=甲赢一局");
                setJiaYing(getJiaYing() + 1);
            } else if (chuquanY == "布") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=乙赢一局");
                setYiYing(getYiYing() + 1);
            }
        } else if (chuquanJ == "剪刀") {
            if (chuquanY == "石头") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=乙赢一局");
                setYiYing(getYiYing() + 1);
            } else if (chuquanY == "剪刀") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=平局");
                setPing(getPing() + 1);
            } else if (chuquanY == "布") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=甲赢一局");
                setJiaYing(getJiaYing() + 1);
            }
        } else if (chuquanJ == "布") {
            if (chuquanY == "石头") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=甲赢一局");
                setJiaYing(getJiaYing() + 1);
            } else if (chuquanY == "剪刀") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=乙赢一局");
                setYiYing(getYiYing() + 1);
            } else if (chuquanY == "布") {
                System.out.println("甲出:" + chuquanJ + "--乙出:" + chuquanY + "=平局");
                setPing(getPing() + 1);
            }
        }
    }
}


/**
 * 角色类
 */
class Person {
    private String chuquan;//出拳

    public Person() {
    }

    public Person(String chuquan) {
        this.chuquan = chuquan;
    }

    public String getChuquan() {
        return chuquan;
    }

    public void setChuquan(String chuquan) {
        this.chuquan = chuquan;
    }

    //猜拳的方法
    public void guess() {
        int random = new Random().nextInt(3) + 1;//从0开始计数，+1从1开始计数
        if (random == 1)
            setChuquan("石头");
        else if (random == 2)
            setChuquan("剪刀");
        else if (random == 3)
            setChuquan("布");
    }
}

/**
 * 角色甲
 * * 一旦出了“布”，下次肯定不会出“布”
 */
class Jia extends Person {
    @Override
    public void guess() {
        if (getChuquan() == "布") {
            int random = new Random().nextInt(2) + 1;
            if (random == 2)
                setChuquan("剪刀");
            else if (random == 1)
                setChuquan("石头");
        } else
            super.guess();
    }
}

/**
 * 角色乙
 * 一旦出了“石头”，下次肯定是“剪刀”
 */
class Yi extends Person {
    @Override
    public void guess() {
        if (getChuquan() == "石头") {
            setChuquan("剪刀");
        } else
            super.guess();
    }
}


