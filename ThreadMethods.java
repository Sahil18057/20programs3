class A extends Thread
{
    public void run()
    {
        for(int i = 1; i <= 5; i++)
        {
            if(i == 1)
            yield();
            System.out.println("\t From Thread A : i = " + i);
        }
        System.out.println("Exit from A ");
    }
}

class B extends Thread
{
    public void run()
    {
        for(int j = 1; j <= 5; j++)
        {
            System.out.println("\t From Thread B : j = " + j);
            if(j == 3)
            stop();
        }
        System.out.println("Exit from B ");
    }
}

class C extends Thread
{
    public void run()
    {
        for(int k = 1; k <= 5; k++)
        {
            System.out.println("\t From Thread C : k = " + k);
            if(k == 1)
            try
            {
                sleep(1000);
            }
            catch (Exception e)
            {

            }
        }
        System.out.println("Exit from C ");
    }
}

class ThreadMethods
{
    public static void main(String args[])
    {
        A threadA = new A();
        B threadB = new B();
        C threadC = new C();

        System.out.println("Start thread A ");
        threadA.start();

        System.out.println("Start thread B ");
        threadB.start();

        System.out.println("Start thread C ");
        threadC.start();

        System.out.println("End of main thread ")
    }
}

/*

Start thread A
Start thread B
Start thread C
End of main thread
         From Thread B : j = 1
         From Thread C : k = 1
         From Thread A : i = 1
         From Thread B : j = 2
         From Thread B : j = 3
         From Thread A : i = 2
         From Thread A : i = 3
         From Thread A : i = 4
         From Thread A : i = 5
Exit from A
         From Thread C : k = 2
         From Thread C : k = 3
         From Thread C : k = 4
         From Thread C : k = 5
Exit from C

*/