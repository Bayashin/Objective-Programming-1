package jp.ac.ait.k21099;
/**
 * 答え合わせをした場合のHit,Blowの数を帆jして返信するためのクラス
 */

public class Response {

    /**
     * Hit と　Blow　の数
     */
    private int hit;
    private int blow;

    /**
     * HitとBlowを初期化
     * @param hit
     */
    public Response(int hit, int blow){
        setHit(hit);
        setBlow(blow);
    }

    public Response(){
        this(0, 0);
    }


    public int getHit(){
        return hit;
    }

    public void setHit(int hit){
        this.hit = hit;
    }

    public int getBlow(){
        return blow;
    }

    public void setBlow(int blow){
        this.blow = blow;
    }
}
