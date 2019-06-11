package com.kr.caption.java8.reconsitution;

import java.util.function.Consumer;

public abstract class OnlineBanking {

    public void processCustomer(int id){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);




    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1234, (Customer c) -> System.out.println("chajoidsd" + c.toString()));
    }


    public static class OnlineBankingLambda{
        //使用Lambda的方式
        public void processCustomer(int id, Consumer<Customer> consumer){
            Customer c = Database.getCustomerWithId(id);
            consumer.accept(c);
        }
    }


    public static class Customer{

    }
    public static class Database{

        private static Customer  getCustomerWithId(int id){

            return new Customer();
        }
    }
}
