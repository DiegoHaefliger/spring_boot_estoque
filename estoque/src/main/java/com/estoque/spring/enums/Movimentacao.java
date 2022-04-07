package com.estoque.spring.enums;

/**
 *
 * @author Diego Haefliger
 */
public enum Movimentacao {

    ENTRADA(1),
    SAIDA(2);

    private int idMovimentacao;

    private Movimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public static Movimentacao valueOf(int id) {
        for (Movimentacao value : Movimentacao.values()) {
            if (value.getIdMovimentacao() == id) {
                return value;
            }
        }
        throw new IllegalArgumentException("Código não encontrado");
    }
}
