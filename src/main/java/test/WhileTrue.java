package test;

public class WhileTrue {
    public static void main(String[] args) {
        int i=0;
        while(true) {
            if (i == 3) {
                System.out.println("结束！！！！");
                return;
            }
            System.out.println("i："+i);
            i++;
        }
    }
}
