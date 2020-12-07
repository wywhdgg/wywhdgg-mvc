package com.wywhdgg.mvc.beans;

import lombok.Data;
import lombok.ToString;

/***
 *@author dzb
 *@date 2019/11/26 6:55
 *@Description:
 *@version 1.0
 */
@Data
@ToString
public class PropertyValue {
    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        super();
        this.name = name;
        this.value = value;
    }

}
