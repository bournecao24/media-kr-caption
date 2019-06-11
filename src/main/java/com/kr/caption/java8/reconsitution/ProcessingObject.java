package com.kr.caption.java8.reconsitution;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public abstract class ProcessingObject<T> {

    private ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    abstract protected T handleWork(T input);

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }


    public static void main(String[] args) {
        ProcessingObjectI objectI = new ProcessingObjectI();
        ProcessingObjectII objectII = new ProcessingObjectII();

        objectI.setSuccessor(objectII);

        String result = objectI.handle("Aren't labdas really sexy?!!");
        System.out.println(result);


        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);
        String resultLLambda = pipeline.apply("Aren't labdas really sexy?!!");
    }
}
