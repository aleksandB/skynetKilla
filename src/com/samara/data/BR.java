package com.samara.data;

/**
 * Created by sr01001 on 13/01/2016.
 */
public class BR {

    private String brRef;
    private String commandNumber;
    private String ligneNumber;
    private String sumValue;
    private String linkBR;

    public String getBrRef() {
        return brRef;
    }

    public void setBrRef(String brRef) {
        this.brRef = brRef;
    }

    public String getCommandNumber() {
        return commandNumber;
    }

    public void setCommandNumber(String commandNumber) {
        this.commandNumber = commandNumber;
    }

    public String getLigneNumber() {
        return ligneNumber;
    }

    public void setLigneNumber(String ligneNumber) {
        this.ligneNumber = ligneNumber;
    }

    public String getSumValue() {
        return sumValue;
    }

    public void setSumValue(String sumValue) {
        this.sumValue = sumValue;
    }

    public String getLinkBR() {
        return linkBR;
    }

    public void setLinkBR(String linkBR) {
        this.linkBR = linkBR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BR br = (BR) o;

        if (brRef != null ? !brRef.equals(br.brRef) : br.brRef != null) return false;
        if (commandNumber != null ? !commandNumber.equals(br.commandNumber) : br.commandNumber != null) return false;
        if (ligneNumber != null ? !ligneNumber.equals(br.ligneNumber) : br.ligneNumber != null) return false;
        if (sumValue != null ? !sumValue.equals(br.sumValue) : br.sumValue != null) return false;
        return !(linkBR != null ? !linkBR.equals(br.linkBR) : br.linkBR != null);

    }

    @Override
    public int hashCode() {
        int result = brRef != null ? brRef.hashCode() : 0;
        result = 31 * result + (commandNumber != null ? commandNumber.hashCode() : 0);
        result = 31 * result + (ligneNumber != null ? ligneNumber.hashCode() : 0);
        result = 31 * result + (sumValue != null ? sumValue.hashCode() : 0);
        result = 31 * result + (linkBR != null ? linkBR.hashCode() : 0);
        return result;
    }
}
