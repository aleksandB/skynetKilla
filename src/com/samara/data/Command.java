package com.samara.data;

/**
 * Created by sr01001 on 13/01/2016.
 */
public class Command {

    private String commandNumber;
    private String ligneNumber;
    private String freeValue;
    private String deptClient;
    private String linkCommand;
    private String linkLigne;
    private String status;

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

    public String getFreeValue() {
        return freeValue;
    }

    public void setFreeValue(String freeValue) {
        this.freeValue = freeValue;
    }

    public String getDeptClient() {
        return deptClient;
    }

    public void setDeptClient(String deptClient) {
        this.deptClient = deptClient;
    }

    public String getLinkCommand() {
        return linkCommand;
    }

    public void setLinkCommand(String linkCommand) {
        this.linkCommand = linkCommand;
    }

    public String getLinkLigne() {
        return linkLigne;
    }

    public void setLinkLigne(String linkLigne) {
        this.linkLigne = linkLigne;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Command command = (Command) o;

        if (commandNumber != null ? !commandNumber.equals(command.commandNumber) : command.commandNumber != null)
            return false;
        if (ligneNumber != null ? !ligneNumber.equals(command.ligneNumber) : command.ligneNumber != null) return false;
        if (freeValue != null ? !freeValue.equals(command.freeValue) : command.freeValue != null) return false;
        if (deptClient != null ? !deptClient.equals(command.deptClient) : command.deptClient != null) return false;
        if (linkCommand != null ? !linkCommand.equals(command.linkCommand) : command.linkCommand != null) return false;
        if (linkLigne != null ? !linkLigne.equals(command.linkLigne) : command.linkLigne != null) return false;
        return !(status != null ? !status.equals(command.status) : command.status != null);

    }

    @Override
    public int hashCode() {
        int result = commandNumber != null ? commandNumber.hashCode() : 0;
        result = 31 * result + (ligneNumber != null ? ligneNumber.hashCode() : 0);
        result = 31 * result + (freeValue != null ? freeValue.hashCode() : 0);
        result = 31 * result + (deptClient != null ? deptClient.hashCode() : 0);
        result = 31 * result + (linkCommand != null ? linkCommand.hashCode() : 0);
        result = 31 * result + (linkLigne != null ? linkLigne.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
