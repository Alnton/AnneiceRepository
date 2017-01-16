package com.alnton.myframe.util;

import java.io.Serializable;

/**
 * <在传递意图中，Resource和ArrayList<Resource>类型的数据不能传输，
 * 故将此类型数据放到实现了Serializable中的类中进行传输，因为Intent.put支持Serializable类型>
 *
 * @author 王乾州
 */
public class Data implements Serializable {
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -49619420454972230L;

    private Object object;

    public Object getObject() {
        return object;
    }

    public Data(Object object) {
        this.object = object;
    }
}