package br.com.cleanarch.application;

public abstract class InUseCase<IN> {

    public abstract void execute(IN in);
}
