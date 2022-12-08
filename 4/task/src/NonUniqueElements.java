public class NonUniqueElements {
    public IntCollector convert(IntCollector arr) {
        int k=0;
        while (k==0){//一度もremoveが呼ばれない＝全ての要素がユニークでない
            //removeがよばれるか、removeが一度も呼ばれず i=array.length になるまで繰り返す
            for (int i=0,j=0; j == 0; i++) {
                if (i == arr.getArray().length) {
                j++;
                k++;
                continue;
            }
                //ユニークな値が見つかった時removeを呼び出す
                if (arr.countOf( arr.getArray()[i] ) == 1) {
                    arr.remove(arr.indexOf(arr.getArray()[i]));
                    j++;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        IntCollector ic =new IntCollector();
        ic.add(1);
        ic.add(50);
        ic.add(40);
        ic.add(10);
        ic.add(100);
        ic.print();
        NonUniqueElements app = new NonUniqueElements();
        app.convert(ic).print();


        ic.add(10);
        ic.add(50);
        ic.add(40);
        ic.add(10);
        ic.add(100);
        ic.add(50);
        ic.print();
        app.convert(ic).print();

        ic.add(-10);
        ic.add(-50);
        ic.add(40);
        ic.add(100);
        ic.add(-50);
        ic.print();
        app.convert(ic).print();

        IntCollector ic2 = new IntCollector();
        ic2.print();
        app.convert(ic2).print();
    }
}
