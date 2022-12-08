package javaapps;
public class Test {
    protected int num;

    public Test(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void modify(int x) {
        num += x;
    }
}
