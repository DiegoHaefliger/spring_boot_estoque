package com.estoque.spring.servicos.excetions;

/**
 *
 * @author diego.haefliger
 */
public class ExceptionResourceNotFound extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionResourceNotFound(Object id) {
        super("Resource not found. Id " + id);
    }

}
