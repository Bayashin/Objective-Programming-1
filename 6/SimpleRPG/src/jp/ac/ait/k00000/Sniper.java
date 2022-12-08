package jp.ac.ait.k00000;

import java.util.Random;

public class Sniper extends Hero implements IHeroJob{
    public Sniper(String name, int hp, int atk, int def, int agi) {
        // それぞれ引数の値で初期値セット
        super(name, hp, atk, def, agi);
    }

    public String getJobName(){
        return this.getName();
    }

    /**
     * 陣地作成は40％の確率で成功し、成功時に自分のdefを＋3〜＋7する
     * @paramt　arget 行動対象（自分）
     * @return　行動結果
     */
    public String getSpecialAttackName(){
        return "隠密行動";
    }


    public AttackResult specialAttack(CharacterBase target){

        int successRate = 80;  // 攻撃成功率

        // 上記成功判定で攻撃が成功する(それ以外は失敗)
        if (new Random().nextInt(100) >= successRate) { // 失敗判定
            AttackResult ret = new AttackResult();
            ret.agility = 0;   // ダメージ処理をしないで0を返す
            return ret;
        }


        // 引数の行動者の すばやさ を算出
        //  追加する すばやさ　= +3~+7のランダムな値
        System.out.println("隠密行動で相手より先に攻撃");
        int Agility =(new java.util.Random().nextInt(5) + 3); // ← +3~+7のランダムな値

        AttackResult ret = new AttackResult();
        ret.agility = Agility;
        return ret;
    }

    public String toString() {
        // デバッグ用に職業メッセージを追加しておきます。
        return super.toString() + ", " + this.getJobName() + "(" + this.getSpecialAttackName() + ")";
    }

}
