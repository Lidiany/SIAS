package sias.model.pojo;

import sias.model.base.BasePOJO;

public class TipoDeficiencia extends BasePOJO {

    private String codigo;
    private String descricao;
    private String ativo;
    private DeficienciaPessoa DeficienciaPessoa;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public DeficienciaPessoa getDeficienciaPessoa() {
        return DeficienciaPessoa;
    }

    public void setDeficienciaPessoa(DeficienciaPessoa DeficienciaPessoa) {
        this.DeficienciaPessoa = DeficienciaPessoa;
    }

}
