package sias.model.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sias.model.base.BasePOJO;

public class BeneficioDespesa extends BasePOJO{

    private Date dataInicio;
    private Date dataTermino;
    private Float valor;
    private Date dataAtualizacao;
    private List<TipoBeneficioDespesa> tipoBeneficioDespesas; 
    private List<Pessoa> pessoas;

    public BeneficioDespesa() {
        this.tipoBeneficioDespesas = new ArrayList<TipoBeneficioDespesa>();
        this.pessoas = new ArrayList<Pessoa>();
    }
    
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
