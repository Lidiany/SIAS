package sias.model.pojo;

import java.util.ArrayList;
import java.util.List;
import sias.model.base.BasePOJO;

public class TipoEscolaridade extends BasePOJO {

    private String codigo;
    private String descricao;
    private Boolean ativo;
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    
}
