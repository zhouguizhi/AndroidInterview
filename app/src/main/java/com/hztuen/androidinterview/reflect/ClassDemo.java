package com.hztuen.androidinterview.reflect;

public class ClassDemo {
    public class InnerClass1 {
        public InnerClass1() {
            System.out.println("Inner Class1");
        }
    }

    public class InnerClass2 {
        public InnerClass2() {
            System.out.println("Inner Class2");
        }
    }
     class InnerClass3 {
        public InnerClass3() {
            System.out.println("Inner Class3");
        }
    }
    private class InnerPrivateClass {
        public InnerPrivateClass() {
            System.out.println("Inner Private Class");
        }
    }
}
