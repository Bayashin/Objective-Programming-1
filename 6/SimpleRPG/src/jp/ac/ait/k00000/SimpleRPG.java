package jp.ac.ait.k00000;

import java.util.Random;
import java.util.Scanner;

public class SimpleRPG {

    // このクラスでは、画面からの入力をいろいろなメソッドで行うため、
    // フィールド化しておく
    final static Scanner scanner = new Scanner(System.in);

    Hero hero;
    Enemy enemy;
    private int job = 0;

    int hero_maxHp,enemy_maxHp;

    /**
     * 勇者を生成して返すメソッド
     * @return hero
     */
    Hero createHero() {
        Scanner scanner = new Scanner(System.in);

        //勇者の名前を入力させます
        System.out.println("新兵、貴様の名を名乗れ");
        String name = scanner.nextLine();
        System.out.println("貴様の兵科を教えろ");
        System.out.println("1: 工兵、2: 狙撃兵、それ以外: 新兵");
        this.job = scanner.nextInt();

        switch (this.job){
            case 1:
                // 以下の表klに従ってパラメータを生成
                Hero Engineer = new Military_engineer( // パラメータ	ランダム範囲
                        name,
                        new Random().nextInt(41) + 100,  // HP	100 〜 140
                        new Random().nextInt(8) + 5,   // ATK	5 〜 12　
                        new Random().nextInt(11) + 10,   // DEF	10 〜 20
                        new Random().nextInt(8) + 8);   // AGI	8 〜 15

                setHero_maxHp(Engineer.getHp());
                Engineer.setJob("工兵");

                return Engineer;
            case 2:
                //工兵
                // 以下の表に従ってパラメータを生成
                Hero Sniper = new Sniper( // パラメータ	ランダム範囲
                        name,
                        new Random().nextInt(41) + 70,  // HP	70 〜 110
                        new Random().nextInt(11) + 15,   // ATK	15 〜 25　
                        new Random().nextInt(8) + 5,   // DEF	5 〜 12
                        new Random().nextInt(11) + 15);   // AGI	15 〜 25

                setHero_maxHp(Sniper.getHp());
                Sniper.setJob("狙撃手");

                return Sniper;
            default:
                //狙撃兵
                // 以下の表に従ってパラメータを生成
                Hero Recruit = new Recruit( // パラメータ	ランダム範囲
                        name,
                        new Random().nextInt(41) + 80,  // HP	80 〜 120
                        new Random().nextInt(8) + 8,   // ATK	8 〜 15　
                        new Random().nextInt(8) + 8,   // DEF	8 〜 15
                        new Random().nextInt(8) + 8);   // AGI	8 〜 15

                setHero_maxHp(Recruit.getHp());
                Recruit.setJob("新兵");

                return Recruit;
        }
    }

    Enemy createEnemy() {

        final String[] ENEMY_NAMES = {"3等兵", "曹長", "小尉", "中佐", "大将"};

        // 上記配列から、ランダムに1つだけの名前を抽出して敵の名前とする。
        String name = ENEMY_NAMES[new Random().nextInt(ENEMY_NAMES.length)];

        Enemy enemy = new Enemy( // パラメータ	ランダム範囲
                name,
                new Random().nextInt(151) + 50,  // HP  	50 〜 200
                new Random().nextInt(11) + 10,  // ATK	10 〜 20
                new Random().nextInt(11) + 5,   // DEF	5 〜 15
                new Random().nextInt(11) + 10); // AGI	10 〜 20

        setEnemy_maxHp(enemy.getHp());
        return enemy;

    }

    public int getHero_maxHp(){
        return this.hero_maxHp;
    }
    public int getEnemy_maxHp(){
        return this.enemy_maxHp;
    }
    public void setHero_maxHp(int hero_maxHp){
        this.hero_maxHp = hero_maxHp;
    }
    public void setEnemy_maxHp(int enemy_maxHp) {
        this.enemy_maxHp = enemy_maxHp;
    }

    /**
     *  勇者の行動
     * @return falseの場合続行不能
     */
    boolean heroAction() {
        // 勇者の1回分の行動決定と行動を行わせるメソッド

        // 画面より、攻撃か逃亡かを選択させ、その行動結果を画面に表示します
        System.out.println("貴様の行動を選択しろ(1: 格闘, 2: 特殊行動 3: 拳銃で射撃,　4: 短機関銃で射撃, 5: 突撃銃で射撃,　6: 軽機関銃で射撃,　7:狙撃銃で射撃, 8:携帯式無反動砲,　それ以外: 逃亡)");
        String input ="2";
        input = scanner.nextLine();
        switch (input){
            case "1":
                //  格闘だった場合
                // 攻撃
                AttackResult ret1 = hero.attack(enemy);
                System.out.println(enemy.getName() + "に" + ret1.damage + "のダメージ");
                System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                if (ret1.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;
            case "2":
                // 職業の取得 (変数heroはHeroのインスタンス)
                IHeroJob job = (IHeroJob)hero;
//              このとき、上記4をすっ飛ばして実装を行うと、職業クラスのインスタンスではなくHeroクラスのインスタンスが渡されてしまう。
//              必ずIHeroJobを実装した勇者の職業クラスを使ってHeroのインスタンスを生成したものを渡してください。
//              きちんとできているかをチェックするには、 if (hero instanceof IHeroJob) {} が使えます。

//              特殊行動を行う場合は、jobからメソッドを呼び出しましょう。
                AttackResult res = job.specialAttack(hero);
                switch(this.job){
                    case 0:
                        ret1 = hero.attack(enemy);
                        System.out.println(enemy.getName() + "に" + ret1.damage + "のダメージ");
                        System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                        if (ret1.state == AttackResult.BATTLE_END) {
                            // 戦闘終了
                            System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                            return false; // 続行不能
                        }
                        return true;
                    case 1:
                        hero.setDef(res.defence);
                        System.out.println(hero.getName() + "の防御力が" + res.defence + "増加");
                        System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                        return true;
                    case 2:
                        hero.setAgi(res.agility);
                        System.out.println(hero.getName() + "の素早さが" + res.agility + "増加");
                        System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                        return true;
                }
            case "3":
                //拳銃装備だった場合
                //武器装備
                Weapon weapon = new Weapon("拳銃",5);
                hero.setWeapon(weapon);
                // 攻撃
                AttackResult ret2 = hero.attack(enemy);
                System.out.println(enemy.getName() + "に" + ret2.damage + "のダメージ");
                System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                weapon.setName("武器");
                weapon.setAtk(0);
                if (ret2.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;
            case "4":
                //短機関銃装備だった場合
                //武器装備
                Weapon weapon1 = new Weapon("短機関銃",10);
                hero.setWeapon(weapon1);
                // 攻撃
                AttackResult ret3 = hero.attack(enemy);
                System.out.println(enemy.getName() + "に" + ret3.damage + "のダメージ");
                System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                weapon1.setName("武器");
                weapon1.setAtk(0);
                if (ret3.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;
            case "5":
                //突撃銃装備だった場合
                //武器装備
                Weapon weapon2 = new Weapon("突撃銃",15);
                hero.setWeapon(weapon2);
                // 攻撃
                AttackResult ret4 = hero.attack(enemy);
                System.out.println(enemy.getName() + "に" + ret4.damage + "のダメージ");
                System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                weapon2.setName("武器");
                weapon2.setAtk(0);
                if (ret4.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;
            case "6":
                //軽機関銃装備だった場合
                //武器装備
                Weapon weapon3 = new Weapon("軽機関銃",20);
                hero.setWeapon(weapon3);
                // 攻撃
                AttackResult ret5 = hero.attack(enemy);
                System.out.println(enemy.getName() + "に" + ret5.damage + "のダメージ");
                System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                weapon3.setName("武器");
                weapon3.setAtk(0);
                if (ret5.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;
            case "7":
                //狙撃銃装備だった場合
                //武器装備
                Weapon weapon4 = new Weapon("狙撃銃",25);
                hero.setWeapon(weapon4);
                // 攻撃
                AttackResult ret6 = hero.attack(enemy);
                System.out.println(enemy.getName() + "に" + ret6.damage + "のダメージ");
                System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                weapon4.setName("武器");
                weapon4.setAtk(0);
                if (ret6.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;
            case "8":
                //狙撃銃装備だった場合
                //武器装備
                Weapon weapon5 = new Weapon("携帯式無反動砲",40);
                hero.setWeapon(weapon5);
                // 攻撃
                AttackResult ret7 = hero.attack(enemy);
                System.out.println(enemy.getName() + "に" + ret7.damage + "のダメージ");
                System.out.println(enemy.getHp() + "/" +getEnemy_maxHp());
                weapon5.setName("武器");
                weapon5.setAtk(0);
                if (ret7.state == AttackResult.BATTLE_END) {
                    // 戦闘終了
                    System.out.print("よくやった!! " + enemy.getName() + "を撃破した!!\nゲームクリア。");
                    return false; // 続行不能
                }
                // 戻り値は、行動により戦闘続行可否をbooleanで返します
                return true;
            default:
                // 逃亡だった場合
                System.out.println(hero.getName() + "には失望した。敵前逃亡は許されない。\nゲームオーバー");
                return false; // 続行不能
        }
    }

    boolean enemyAction() {
        // 敵の1回分の攻撃行動を行わせるメソッド（敵は攻撃の行動のみ行います）
        // 攻撃だった場合
        AttackResult ret = enemy.attack(hero);
        System.out.println(hero.getName() + "に" + ret.damage + "のダメージ");
        System.out.println(hero.getHp() + "/" +getHero_maxHp());
        if (ret.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.println(hero.getName() + "は無残にも倒れてしまった。ゲームオーバー");
            return false; // 続行不能
        }
        // 戻り値は、行動により戦闘続行可否をbooleanで返します
        return true;
    }

    void battleLoop() {
        //戦闘処理の無限ループを用意します
        while(true) {
            // 無限ループ内では、勇者と敵の素早さを比較し行動順序を入れ替え、それぞれの行動を行います
            // 行動により戦闘続行不可能になった場合は、その場で無限ループを抜け、メソッドを終了します
            if (hero.getAgi() >= enemy.getAgi()) {
                // 勇者のほうが早い
                if (!heroAction()) return;
                if (!enemyAction()) return;
            } else {
                if (!enemyAction()) return;
                if (!heroAction()) return;
            }
        }
    }

    public static void main(String[] args) {
        SimpleRPG app = new SimpleRPG();

        app.hero = app.createHero();
        System.out.println(app.hero.getJob()+": " + app.hero.getName() + " HP:" + app.hero.getHp() + " ATK:" + app.hero.getAtk() + " DEF:" + app.hero.getDef() + " AGI:" + app.hero.getAgi());

        app.enemy = app.createEnemy();
        System.out.println("敵　: " + app.enemy.getName() + " HP:" + app.enemy.getHp() + " ATK:" + app.enemy.getAtk() + " DEF:" + app.enemy.getDef() + " AGI:" + app.enemy.getAgi());
        app.battleLoop();
    }


}
