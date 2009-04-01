package net.fly78.dafei1288.util.enumt;
public class Demo {   
	  
    public static void main(String ...args) {// <--> String args[]   
        MyEnum.B.method();  // output:   
                            // B:method()   
        MyEnum.A.method();   
        MyEnum.C.method("ttt");
        MyEnum.A.valueOf("A");
        System.out.println(MyEnum.valueOf("B"));
        MyEnum e = MyEnum.B;
        System.out.println(e.getV());
        
        
    }   
};   
  
enum MyEnum{   
    A(1),
    B(2){
        public void method(){   
            System.out.println("B:method()");   
        } 
     
    },
    C(3){
   	 	public void method(String s){   
            System.out.println("c:method()"+s);   
        } 
    };     
    private int value;   
    MyEnum(int value){   
        this.value = value;   
    }   
      
    public int getV(){
    	return this.value;
    }
    // a common method   
    public void method(){   
        System.out.println("MyEnum:method()"+value);   
    }   
    public void method(String s){   
        System.out.println("MyEnum:method()"+value);   
    }
};  