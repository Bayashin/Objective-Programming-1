package jp.ac.ait.k00000;

public class Weapon extends Equipment{
    private int atk;

    public Weapon(String name, int atk){
        //初期値セット
        //super(name)のあとにthis.atk = atk
        super(name);
        this.atk = atk;
    }

    public Weapon(){
        this.setName("武器");
        this.atk = atk;
    }

    public int getAtk(){
    return this.atk;
    }

    public void setAtk(int atk){
        this.atk = atk;
    }

}
