package com.github.fabriciolfj.crudperson.core.ports.in;

public interface DocumentValidate {

    boolean isCpf(final String cpf);
    boolean isCnpj(final String cnpj);
}
