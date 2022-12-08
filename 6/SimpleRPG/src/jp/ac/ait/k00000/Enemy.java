package jp.ac.ait.k00000;

public class Enemy extends CharacterBase{

    public Enemy(String name, int hp, int atk, int def, int agi) {
        // それぞれ引数の値で初期値セット
        super(name, hp, atk, def, agi);
    }

    public AttackResult attack(CharacterBase target){
        int damage = (int)Math.ceil((double)this.getAtk() - (target.getDef() / 2.0))
                + (new java.util.Random().nextInt(7) - 3); // ← −3〜+3のランダムな値

        // 与えるダメージの計算式に従って計算されたダメージ量を引数の相手に与えます。
        boolean isBattleEnd = target.receiveDamage(damage);

        // 戻り値は、AttackResultのインスタンスを生成し、ダメージ量と戦闘続行かどうかの状態をAttackResultの定数フィールドを使って設定して返します。
        AttackResult ret = new AttackResult();
        ret.damage = damage;
        if (isBattleEnd) {  // 戦闘が終わる場合により詳細な状態を渡したい
            ret.state = AttackResult.BATTLE_END;
        } // CONTINUE は初期値なので、ENDの場合のみ設定すればOK
        return ret;
    }
}
