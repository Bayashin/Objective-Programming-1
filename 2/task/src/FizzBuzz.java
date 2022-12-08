public class FizzBuzz {
    public static void main(String[] args) {

        //1から100までの数値で繰り返し処理をさせます。
        for (int x=1; x<=100; x++){
            int judge3 = x%3, judge5 = x%5;

            if (judge3==0){
                //数値が、3の倍数かつ5の倍数の時、「FizzBuzz」と表示
                if (judge5==0) {
                    System.out.println("FizzBuzz");
                }else { ////数値が、3の倍数の時、「Fizz」と表示
                    System.out.println("Fizz");
                }
                //数値が、5の倍数の時、「Buzz」と表示
            } else if (judge5==0){
                    System.out.println("Buzz");
            }else { //上記以外、数値をそのまま表示
                System.out.println(x);
            }
        }
    }
}
