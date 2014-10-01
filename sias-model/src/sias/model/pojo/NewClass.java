package sias.model.pojo;

import java.sql.Date;
import sias.model.base.BasePOJO;

public class NewClass extends BasePOJO{

    private Date dataInicio;
    private Date dataTermino;
    private Float valor;
    private Date dataAtualizacao;
    private TipoBeneficioDespesa tipoBeneficioDespesa; 
    private Pessoa pessoa;

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

    public TipoBeneficioDespesa getTipoBeneficioDespesa() {
        return tipoBeneficioDespesa;
    }

    public void setTipoBeneficioDespesa(TipoBeneficioDespesa tipoBeneficioDespesa) {
        this.tipoBeneficioDespesa = tipoBeneficioDespesa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
