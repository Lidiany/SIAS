package sias.model.pojo;

import java.util.ArrayList;
import java.util.List;
import sias.model.base.BasePOJO;

public class TipoOcupacao extends BasePOJO {

    private String codigo;
    private String descricao;
    private String ativo;
    
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
}
