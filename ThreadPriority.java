class A extends Thread
{
    public void run()
    {
        System.out.println("threadA started ");
        for(int i = 1; i <= 4; i++)
        {
            System.out.println("\t From Thread A : i = " + i);
        }
        System.out.println("Exit from A ");
    }
}

class B extends Thread
{
    public void run()
    {
        System.out.println("threadB started ");
        for(int j = 1; j <= 4; j++)
        {
            System.out.println("\t From Thread B : j = " + j);
        }
        System.out.println("Exit from B ");
    }
}

class C extends Thread
{
    public void run()
    {
        System.out.println("tnreadC started ");
        for(int k = 1; k <= 4; k++)
        {
            System.out.println("\t From Thread C : k = " + k);
        }
        System.out.println("Exit from C ");
    }
}

class ThreadPriority
{
    public static void main(String args[])
    {
        A threadA = new A();
        B threadB = new B();
        C threadC = new C();

        threadC.setPriority(Thread MAX_PRIORITY);
        threadB.setPriority(threadA.getPriority()+1);
        threadA.setPriority(Thread MIN_PRIORITY);

        System.out.println("Start thread A ");
        threadA.start();

        System.out.println("Start thread B ");
        threadB.start();

        System.out.println("Start thread C ");
        threadC.start();

        System.out.println("End of main thread ");
    }
}


/*

Start thread A
Start thread B
threadA started
Start thread C
threadB started
End of main thread
tnreadC started
         From Thread A : i = 1
         From Thread B : j = 1
         From Thread C : k = 1
         From Thread B : j = 2
         From Thread A : i = 2
         From Thread B : j = 3
         From Thread C : k = 2
         From Thread B : j = 4
         From Thread A : i = 3
Exit from B
         From Thread C : k = 3
         From Thread A : i = 4
         From Thread C : k = 4
Exit from A
Exit from C

*/