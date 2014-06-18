package sias.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BeneficioDespesa {

    private Date dataInicio;
    private Date dataTermino;
    private Float valor;
    private Date dataAtualizacao;
    private List<TipoBeneficioDespesa> tipoBeneficioDespesas = new ArrayList<TipoBeneficioDespesa>();
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<TipoBeneficioDespesa> getTipoBeneficioDespesas() {
        return tipoBeneficioDespesas;
    }

    public void setTipoBeneficioDespesas(List<TipoBeneficioDespesa> tipoBeneficioDespesas) {
        this.tipoBeneficioDespesas = tipoBeneficioDespesas;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
