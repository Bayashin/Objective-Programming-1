package jp.ac.ait.k00000;

import java.util.Random;

public class Recruit extends Hero implements IHeroJob{

    SimpleRPG sim = new SimpleRPG();

    public Recruit(String name, int hp, int atk, int def, int agi) {
        // それぞれ引数の値で初期値セット
        super(name, hp, atk, def, agi);
    }

    public String getJobName(){
        return this.getName();
    }

    /**
     * 新兵なので特殊行動はありません
     * @paramt　arget 行動対象（自分）
     * @return　行動結果
     */
    public String getSpecialAttackName(){
        return "";
    }


    public AttackResult specialAttack(CharacterBase target){
        AttackResult ret1 = sim.hero.attack(sim.enemy);
        System.out.println(sim.enemy.getName() + "に" + ret1.damage + "のダメージ");
        System.out.println(sim.enemy.getHp() + "/" +sim.getEnemy_maxHp());
        if (ret1.state == AttackResult.BATTLE_END) {
            // 戦闘終了
            System.out.print("よくやった!! " + sim.enemy.getName() + "を撃破した!!\nゲームクリア。");
        }


        return ret1;
    }

    public String toString() {
        // デバッグ用に職業メッセージを追加しておきます。
        return super.toString() + ", " + this.getJobName() + "(" + this.getSpecialAttackName() + ")";
    }

}
