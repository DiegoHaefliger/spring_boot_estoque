package com.estoque.spring.servicos.excetions;

/**
 *
 * @author diego.haefliger
 */
public class ExceptionDatabase extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionDatabase(String msg) {
        super(msg);
    }
}
