package sias.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class DeficienciaPessoa {

    private String descricao;
    private List<TipoDeficiencia> tipoDeficiencias = new ArrayList<TipoDeficiencia>();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<TipoDeficiencia> getTipoDeficiencias() {
        return tipoDeficiencias;
    }

    public void setTipoDeficiencias(List<TipoDeficiencia> tipoDeficiencias) {
        this.tipoDeficiencias = tipoDeficiencias;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
