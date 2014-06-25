package sias.model.pojo;

import sias.model.base.BasePOJO;

public class TipoBeneficioDespesa extends BasePOJO {

    private String descricao;
    private String tipo;
    private BeneficioDespesa BeneficioDespesa;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BeneficioDespesa getBeneficioDespesa() {
        return BeneficioDespesa;
    }

    public void setBeneficioDespesa(BeneficioDespesa BeneficioDespesa) {
        this.BeneficioDespesa = BeneficioDespesa;
    }

}
