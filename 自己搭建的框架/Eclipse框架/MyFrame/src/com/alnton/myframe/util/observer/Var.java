package com.alnton.myframe.util.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 要观察的变量
 */
public class Var
{
    private ArrayList<Integer> var;
    
    private List<IObserver> obs = new ArrayList<IObserver>();
    
    /**
     * 注册观察者
     * @param ob
     */
    public void registerObserver(IObserver ob)
    {
        obs.add(ob);
    }
    
    public void setVar(ArrayList<Integer> var)
    {
        this.var = var;
        
        /**
         * 变量改变，通知所有观察者
         */
        for (IObserver ob : obs)
        {
            ob.notify(this);
        }
    }
    
    public ArrayList<Integer> getVar()
    {
        return var;
    }
}