package com.samara.data;

/**
 * Created by sr01001 on 14/01/2016.
 */
public class BGTPart {
    private String cmd_id;
    private String ligne_id;
    private String clt_dept_id;
    private String project_id;
    private String dept_id;
    private String part_value;
    private String comment;
    private String br_nom;
    private String br_budget;
    private String taux;
    private String cloture;
    private String bl_link;
    private String bl_date;
    private String ct_link;
    private String ct_date;
    private String ct_value;
    private String linkCreate;
    private BGTPartValidity bgtPartValidity;

    public BGTPartValidity getBgtPartValidity() {
        return bgtPartValidity;
    }

    public void setBgtPartValidity(BGTPartValidity bgtPartValidity) {
        this.bgtPartValidity = bgtPartValidity;
    }

    public String getCloture() {
        return cloture;
    }

    public void setCloture(String cloture) {
        this.cloture = cloture;
    }

    public String getLinkCreate() {
        return linkCreate;
    }

    public void setLinkCreate(String linkCreate) {
        this.linkCreate = linkCreate;
    }

    public String getCmd_id() {
        return cmd_id;
    }

    public void setCmd_id(String cmd_id) {
        this.cmd_id = cmd_id;
    }

    public String getLigne_id() {
        return ligne_id;
    }

    public void setLigne_id(String ligne_id) {
        this.ligne_id = ligne_id;
    }

    public String getClt_dept_id() {
        return clt_dept_id;
    }

    public void setClt_dept_id(String clt_dept_id) {
        this.clt_dept_id = clt_dept_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getPart_value() {
        return part_value;
    }

    public void setPart_value(String part_value) {
        this.part_value = part_value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBr_nom() {
        return br_nom;
    }

    public void setBr_nom(String br_nom) {
        this.br_nom = br_nom;
    }

    public String getBr_budget() {
        return br_budget;
    }

    public void setBr_budget(String br_budget) {
        this.br_budget = br_budget;
    }

    public String getTaux() {
        return taux;
    }

    public void setTaux(String taux) {
        this.taux = taux;
    }

    public String getBl_link() {
        return bl_link;
    }

    public void setBl_link(String bl_link) {
        this.bl_link = bl_link;
    }

    public String getBl_date() {
        return bl_date;
    }

    public void setBl_date(String bl_date) {
        this.bl_date = bl_date;
    }

    public String getCt_link() {
        return ct_link;
    }

    public void setCt_link(String ct_link) {
        this.ct_link = ct_link;
    }

    public String getCt_date() {
        return ct_date;
    }

    public void setCt_date(String ct_date) {
        this.ct_date = ct_date;
    }

    public String getCt_value() {
        return ct_value;
    }

    public void setCt_value(String ct_value) {
        this.ct_value = ct_value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BGTPart bgtPart = (BGTPart) o;

        if (cmd_id != null ? !cmd_id.equals(bgtPart.cmd_id) : bgtPart.cmd_id != null) return false;
        if (ligne_id != null ? !ligne_id.equals(bgtPart.ligne_id) : bgtPart.ligne_id != null) return false;
        if (clt_dept_id != null ? !clt_dept_id.equals(bgtPart.clt_dept_id) : bgtPart.clt_dept_id != null) return false;
        if (project_id != null ? !project_id.equals(bgtPart.project_id) : bgtPart.project_id != null) return false;
        if (dept_id != null ? !dept_id.equals(bgtPart.dept_id) : bgtPart.dept_id != null) return false;
        if (part_value != null ? !part_value.equals(bgtPart.part_value) : bgtPart.part_value != null) return false;
        if (comment != null ? !comment.equals(bgtPart.comment) : bgtPart.comment != null) return false;
        if (br_nom != null ? !br_nom.equals(bgtPart.br_nom) : bgtPart.br_nom != null) return false;
        if (br_budget != null ? !br_budget.equals(bgtPart.br_budget) : bgtPart.br_budget != null) return false;
        if (taux != null ? !taux.equals(bgtPart.taux) : bgtPart.taux != null) return false;
        if (cloture != null ? !cloture.equals(bgtPart.cloture) : bgtPart.cloture != null) return false;
        if (bl_link != null ? !bl_link.equals(bgtPart.bl_link) : bgtPart.bl_link != null) return false;
        if (bl_date != null ? !bl_date.equals(bgtPart.bl_date) : bgtPart.bl_date != null) return false;
        if (ct_link != null ? !ct_link.equals(bgtPart.ct_link) : bgtPart.ct_link != null) return false;
        if (ct_date != null ? !ct_date.equals(bgtPart.ct_date) : bgtPart.ct_date != null) return false;
        if (ct_value != null ? !ct_value.equals(bgtPart.ct_value) : bgtPart.ct_value != null) return false;
        if (linkCreate != null ? !linkCreate.equals(bgtPart.linkCreate) : bgtPart.linkCreate != null) return false;
        return !(bgtPartValidity != null ? !bgtPartValidity.equals(bgtPart.bgtPartValidity) : bgtPart.bgtPartValidity != null);

    }

    @Override
    public int hashCode() {
        int result = cmd_id != null ? cmd_id.hashCode() : 0;
        result = 31 * result + (ligne_id != null ? ligne_id.hashCode() : 0);
        result = 31 * result + (clt_dept_id != null ? clt_dept_id.hashCode() : 0);
        result = 31 * result + (project_id != null ? project_id.hashCode() : 0);
        result = 31 * result + (dept_id != null ? dept_id.hashCode() : 0);
        result = 31 * result + (part_value != null ? part_value.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (br_nom != null ? br_nom.hashCode() : 0);
        result = 31 * result + (br_budget != null ? br_budget.hashCode() : 0);
        result = 31 * result + (taux != null ? taux.hashCode() : 0);
        result = 31 * result + (cloture != null ? cloture.hashCode() : 0);
        result = 31 * result + (bl_link != null ? bl_link.hashCode() : 0);
        result = 31 * result + (bl_date != null ? bl_date.hashCode() : 0);
        result = 31 * result + (ct_link != null ? ct_link.hashCode() : 0);
        result = 31 * result + (ct_date != null ? ct_date.hashCode() : 0);
        result = 31 * result + (ct_value != null ? ct_value.hashCode() : 0);
        result = 31 * result + (linkCreate != null ? linkCreate.hashCode() : 0);
        result = 31 * result + (bgtPartValidity != null ? bgtPartValidity.hashCode() : 0);
        return result;
    }
}
