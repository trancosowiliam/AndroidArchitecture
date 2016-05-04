package br.com.dalcim.architecture.exception;

public class BusinessException extends Exception{

    public BusinessException(String detailMessage) {
        super(detailMessage);
    }
}