import java.util.Scanner;

public class RunnableDemo01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        MyThread mt1 = new MyThread(1,x) ;    // 实例化对象
        MyThread mt2 = new MyThread(1000,x) ;    // 实例化对象
        MyThread mt3 = new MyThread(1000000,x) ;  // 实例化对象
        Thread t1 = new Thread(mt1) ;       // 实例化Thread类对象
        Thread t2 = new Thread(mt2) ;       // 实例化Thread类对象
        Thread t3 = new Thread(mt3) ;       // 实例化Thread类对象
        t1.start() ;    // 启动多线程
        t2.start() ;    // 启动多线程
        t3.start() ;    // 启动多线程
    }
}

 class MyThread implements Runnable{ // 实现Runnable接口，作为线程的实现类

     long start ;       // 表示线程的名称
     long ans = 0;
     int x;

     public MyThread(int start,int x){
         this.start = start ;
         this.x = x;
     }

     public void run(){  // 覆写run()方法，作为线程 的操作主体
         for(long i=start;i<start*1000;i++){
             if (contain(i, x)) {
                 ans += i;
             }
         }
         System.out.println(ans);
     }

     private static boolean contain(long num, int x) {
         return String.valueOf(num).contains(String.valueOf(x));
     }
 }

