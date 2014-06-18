package sias.model.pojo;

import sias.model.base.BasePOJO;

public class TipoBeneficioDespesa extends BasePOJO {

    private String descricao;
    private String tipo;
    private BeneficioDespesa BeneficioDespesa_;

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

    public BeneficioDespesa getBeneficioDespesa_() {
        return BeneficioDespesa_;
    }

    public void setBeneficioDespesa_(BeneficioDespesa BeneficioDespesa_) {
        this.BeneficioDespesa_ = BeneficioDespesa_;
    }

}
