package sias.model.pojo;

import sias.model.base.BasePOJO;

public class Municipio extends BasePOJO {

    private String nome;
    private Uf uf;

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
