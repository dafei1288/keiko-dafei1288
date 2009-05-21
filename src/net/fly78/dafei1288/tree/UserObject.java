/**
 * net.fly78.dafei1288.tree
 * 
 * @author dafei1288
 *
 * @version 2009/Apr 2, 2009/3:54:20 PM
 */
package net.fly78.dafei1288.tree;

public class UserObject {

    private String name = null;

    private Integer value = Integer.valueOf(0);

    public UserObject() {

    }

    public UserObject(String code, Integer value) {
        this.name = code;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String code) {
        this.name = code;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[name=").append(name).append(", value=").append(value).append("]");
        return result.toString();
    }
}

