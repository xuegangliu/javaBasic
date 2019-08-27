package com.lxg.problem.others;

/**
 * @author xuegangliu
 */
public class HashFunction {
    int grade;
    int cls;
    String firstName;
    String lastName;

    HashFunction(int grade, int cls, String firstName, String lastName){
        this.grade = grade;
        this.cls = cls;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode(){

        int b = 31;
        int hash = 0;
        hash = hash * b + ((Integer)grade).hashCode();
        hash = hash * b + ((Integer)cls).hashCode();
        hash = hash * b + firstName.toLowerCase().hashCode();
        hash = hash * b + lastName.toLowerCase().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o){

        if(this == o) {
            return true;
        }
        if(o == null) {
            return false;
        }
        if(getClass() != o.getClass()) {
            return false;
        }
        HashFunction another = (HashFunction)o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }
}
