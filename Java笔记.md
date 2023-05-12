# java高级

## 多线程

### 经典问题(生产者消费者问题)

```java
/*
Object notify() 方法用于唤醒一个在此对象监视器上等待的线程
*[经典问题生产者消费者问题] 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
*取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
*生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
*知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
*果店中有产品了再通知消费者来取走产品。
* 共享数据:店员,消费者
* 线程:生产者,消费者
* */
class Clerk{
    public  int produce=0;
    public static int i=0;
   public  synchronized void add() {
       while (true){
            if (produce<20) {
                notify();
                produce++;
                System.out.println(Thread.currentThread().getName() + "生产了" + produce + "件的产品");
            }else
            {
                System.out.println(88888);
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        }
    }
   }
    public synchronized void xiaofei() {
        while (true) {
            if (produce > 0) {
                System.out.println(Thread.currentThread().getName() + "消费还剩下" + produce + "件产品");
                produce--;
                notify();
            } else {
                System.out.println(66666);
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
class Customer extends Thread{//顾客
    private Clerk c1;
    public Customer(Clerk clerk)
    {
        this.c1=clerk;
    }
    public void run() {
        c1.xiaofei();
    }
}
class Productor extends Thread
{
     private Clerk c2;
    public Productor(Clerk c)
    {
        this.c2=c;
    }
    @Override
    public void run() {
        c2.add();
    }
}
public class Produce_classic_question {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Customer customer = new Customer(clerk);
        Productor productor = new Productor(clerk);
        customer.setName("顾客");
        productor.setName("生产者");
        customer.start();
        productor.start();
        System.out.println();
    }
}
```

[代码分析]

问题:为什么只在生产者生产add()这一个方法中添加notify()这个方法的时候不是按照预想中的进行
        预想:在生产者生产add()这一个方法中添加notify()这样子做以后生产者生产一个东西就会唤醒消费者消费
        实际:生产者与消费者的生产add()和消费xiaofei()这两个方法共同的在同一个锁下面如果旨在add()方法里面添加notify()的话,运行时的情况为两个行为先执行消费(消费的步骤简单容易拿到锁，而且消费拿到这一个锁以后生产不可能再拿到这一个锁)发现商品数目为0，然后就会wait(),释放锁，进行add(),add()执行,里面的notify()执行唤醒消费这个进程但是没有释放同步监视器,然后生产完20个以后才会wait(),释放锁,所以就是生产者生产了20个物品以后,消费者一个个消费完了以后wait(),进程全部堵塞
      其中迷茫的时候的问题答案:
      1、notify()只能唤醒另一个进程但是没办法释放同步监视器所以就算唤醒了另一个进程他也没办法执行因为同步监视器在生产add()手里面，只有wait()释放同步监视器以后才能运行(一个线程运行的必要条件1.同步监视器没有被占用2.没有堵塞)
      2、其实生产和消费这两个线程公用一个锁，通过构建一个clerk,方法的同步(public  synchronized void add() {)这个的监视器相当与this,所以两个是同一个clerk就是同一把clerk锁
      3.notify()是唤醒同一把锁下的进程不是一把锁无法唤醒

## 网路编程

