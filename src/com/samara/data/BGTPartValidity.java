package com.samara.data;

/**
 * Created by sr01001 on 28/03/2016.
 */
public class BGTPartValidity {

    private boolean validCommand;
    private boolean validLine;
    private boolean validStatus;
    private boolean validDeptSN;
    private boolean validDeptSMC;
    private boolean validVal;
    private boolean validBR;
    private boolean validBRVal;
    private boolean validTaux;
    private boolean validCloture;
    private boolean validAll;

    public boolean isValidAll() {
        return validAll;
    }

    public void setValidAll(boolean validAll) {
        this.validAll = validAll;
    }

    public boolean isValidStatus() {
        return validStatus;
    }

    public void setValidStatus(boolean validStatus) {
        this.validStatus = validStatus;
    }

    public boolean isValidCommand() {
        return validCommand;
    }

    public void setValidCommand(boolean validCommand) {
        this.validCommand = validCommand;
    }

    public boolean isValidLine() {
        return validLine;
    }

    public void setValidLine(boolean validLine) {
        this.validLine = validLine;
    }

    public boolean isValidDeptSN() {
        return validDeptSN;
    }

    public void setValidDeptSN(boolean validDeptSN) {
        this.validDeptSN = validDeptSN;
    }

    public boolean isValidDeptSMC() {
        return validDeptSMC;
    }

    public void setValidDeptSMC(boolean validDeptSMC) {
        this.validDeptSMC = validDeptSMC;
    }

    public boolean isValidVal() {
        return validVal;
    }

    public void setValidVal(boolean validVal) {
        this.validVal = validVal;
    }

    public boolean isValidBR() {
        return validBR;
    }

    public void setValidBR(boolean validBR) {
        this.validBR = validBR;
    }

    public boolean isValidBRVal() {
        return validBRVal;
    }

    public void setValidBRVal(boolean validBRVal) {
        this.validBRVal = validBRVal;
    }

    public boolean isValidTaux() {
        return validTaux;
    }

    public void setValidTaux(boolean validTaux) {
        this.validTaux = validTaux;
    }

    public boolean isValidCloture() {
        return validCloture;
    }

    public void setValidCloture(boolean validCloture) {
        this.validCloture = validCloture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BGTPartValidity that = (BGTPartValidity) o;

        if (validCommand != that.validCommand) return false;
        if (validLine != that.validLine) return false;
        if (validStatus != that.validStatus) return false;
        if (validDeptSN != that.validDeptSN) return false;
        if (validDeptSMC != that.validDeptSMC) return false;
        if (validVal != that.validVal) return false;
        if (validBR != that.validBR) return false;
        if (validBRVal != that.validBRVal) return false;
        if (validTaux != that.validTaux) return false;
        if (validCloture != that.validCloture) return false;
        return validAll == that.validAll;

    }

    @Override
    public int hashCode() {
        int result = (validCommand ? 1 : 0);
        result = 31 * result + (validLine ? 1 : 0);
        result = 31 * result + (validStatus ? 1 : 0);
        result = 31 * result + (validDeptSN ? 1 : 0);
        result = 31 * result + (validDeptSMC ? 1 : 0);
        result = 31 * result + (validVal ? 1 : 0);
        result = 31 * result + (validBR ? 1 : 0);
        result = 31 * result + (validBRVal ? 1 : 0);
        result = 31 * result + (validTaux ? 1 : 0);
        result = 31 * result + (validCloture ? 1 : 0);
        result = 31 * result + (validAll ? 1 : 0);
        return result;
    }
}
