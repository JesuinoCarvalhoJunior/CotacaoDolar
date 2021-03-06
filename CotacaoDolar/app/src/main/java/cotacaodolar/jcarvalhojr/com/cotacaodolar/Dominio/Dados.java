package cotacaodolar.jcarvalhojr.com.cotacaodolar.Dominio;

import java.io.Serializable;

/**
 * Created by Junior_Carvalho on 24/06/2018.
 */
public class Dados implements Serializable {

    private static final long serialVersionUID = 1L;

    // private String idReg;
    private String code;
    private String codeIn;
    private String name;
    private String high;
    private String low;
    private String pctChange;
    private String open;
    private String bid;
    private String ask;
    private String varBid;
    private String timeStamp;
    private String create_Date;

/*
    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }
*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeIn() {
        return codeIn;
    }

    public void setCodeIn(String codeIn) {
        this.codeIn = codeIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getPctChange() {
        return pctChange;
    }

    public void setPctChange(String pctChange) {
        this.pctChange = pctChange;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getVarBid() {
        return varBid;
    }

    public void setVarBid(String varBid) {
        this.varBid = varBid;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(String create_Date) {
        this.create_Date = create_Date;
    }

// Lista sem formatacao
  /*  @Override
    public String toString() {
        return code + "," + codeIn + "," + name + "," + high + "," + low + "," + pctChange + "," + open + ","
                + bid + "," + ask + "," + varBid + "," + timeStamp + "," + create_Date + "]";
    }*/

// Lista formatada
    @Override
    public String toString() {
        return "Cód. externo: " + getCode()
                + "\nCód. interno " + getCodeIn()
                + "\nNome da moeda: " + getName()
                + "\nMáxima: " + getHigh()
                + "\nMínima: " + getLow()
                + "\nPerc. de variação: " + getPctChange() +" %"
                + "\nAbertura: " + getOpen()
                +"\nVariação: " + getBid()
                + "\nCompra: " + getAsk()
                + "\nVenda: " + getVarBid()
                + "\nTimeStamp: " + getTimeStamp()
                + "\nData/Hora: " + getCreate_Date();
    }

}
