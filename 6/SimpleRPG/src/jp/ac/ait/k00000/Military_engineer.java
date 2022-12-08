package jp.ac.ait.k00000;

import java.util.Random;

public class Military_engineer extends Hero implements IHeroJob{

    public Military_engineer(String name, int hp, int atk, int def, int agi) {
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
      return "陣地作成";
    }


    public AttackResult specialAttack(CharacterBase target){

        int successRate = 80;  // 攻撃成功率

        // 上記成功判定で攻撃が成功する(それ以外は失敗)
        if (new Random().nextInt(100) >= successRate) { // 失敗判定
            AttackResult ret = new AttackResult();
            ret.defence = 0;   // ダメージ処理をしないで0を返す
            return ret;
        }


        // 引数の行動者の防御力を算出
        //  追加する防御力　= +3~+7のランダムな値
        System.out.println("陣地を作成して防御力アップ");
        int defence =(new java.util.Random().nextInt(5) + 3); // ← +3~+7のランダムな値

        AttackResult ret = new AttackResult();
        ret.defence = defence;
        return ret;
    }

    public String toString() {
        // デバッグ用に職業メッセージを追加しておきます。
        return super.toString() + ", " + this.getJobName() + "(" + this.getSpecialAttackName() + ")";
    }

}
