package com.alnton.myframe.util.observer;

import java.util.ArrayList;


/**
 * 观察者
 */
class Test1 implements IObserver
{
    
    public void notify(Var v)
    {
        System.out.println("test1 " + v.getVar());
    }
    
}

class Test2 implements IObserver
{
    public void notify(Var v)
    {
        System.out.println("test2 " + v.getVar());
    }
}

public class ObserverDemo
{
    public static void main(String[] arg)
    {
        Var v = new Var();
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        v.registerObserver(test1);
        v.registerObserver(test2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        v.setVar(list);
    }
}