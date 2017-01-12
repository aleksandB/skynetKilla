package com.samara.data;

/**
 * Created by sr01001 on 14/01/2016.
 */
public class Livrable {
    private String linkLivr;
    private String name;
    private String ddi_id;
    private String dept_id;
    private String project_id;
    private String date_end_ini;
    private String date_end_real;
    private String date_end_agreed;
    private String status;


    public String getLinkLivr() {
        return linkLivr;
    }

    public void setLinkLivr(String linkLivr) {
        this.linkLivr = linkLivr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDdi_id() {
        return ddi_id;
    }

    public void setDdi_id(String ddi_id) {
        this.ddi_id = ddi_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getDate_end_ini() {
        return date_end_ini;
    }

    public void setDate_end_ini(String date_end_ini) {
        this.date_end_ini = date_end_ini;
    }

    public String getDate_end_real() {
        return date_end_real;
    }

    public void setDate_end_real(String date_end_real) {
        this.date_end_real = date_end_real;
    }

    public String getDate_end_agreed() {
        return date_end_agreed;
    }

    public void setDate_end_agreed(String date_end_agreed) {
        this.date_end_agreed = date_end_agreed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String identStatus(String str){
        String ident="";
        //4 - Deleted; 3 - Accepted; 2 -Delivered; 1 - Open
        if(str.equals("Open")){
            ident = "1";
        }else if(str.equals("Delivered")){
            ident = "2";
        }else if(str.equals("Accepted")){
            ident = "3";
        }else if(str.equals("Deleted")){
            ident = "4";
        } else {
            ident = "1";
        }

        return ident;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livrable livrable = (Livrable) o;

        if (linkLivr != null ? !linkLivr.equals(livrable.linkLivr) : livrable.linkLivr != null) return false;
        if (name != null ? !name.equals(livrable.name) : livrable.name != null) return false;
        if (ddi_id != null ? !ddi_id.equals(livrable.ddi_id) : livrable.ddi_id != null) return false;
        if (dept_id != null ? !dept_id.equals(livrable.dept_id) : livrable.dept_id != null) return false;
        if (project_id != null ? !project_id.equals(livrable.project_id) : livrable.project_id != null) return false;
        if (date_end_ini != null ? !date_end_ini.equals(livrable.date_end_ini) : livrable.date_end_ini != null)
            return false;
        if (date_end_real != null ? !date_end_real.equals(livrable.date_end_real) : livrable.date_end_real != null)
            return false;
        if (date_end_agreed != null ? !date_end_agreed.equals(livrable.date_end_agreed) : livrable.date_end_agreed != null)
            return false;
        return !(status != null ? !status.equals(livrable.status) : livrable.status != null);

    }

    @Override
    public int hashCode() {
        int result = linkLivr != null ? linkLivr.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ddi_id != null ? ddi_id.hashCode() : 0);
        result = 31 * result + (dept_id != null ? dept_id.hashCode() : 0);
        result = 31 * result + (project_id != null ? project_id.hashCode() : 0);
        result = 31 * result + (date_end_ini != null ? date_end_ini.hashCode() : 0);
        result = 31 * result + (date_end_real != null ? date_end_real.hashCode() : 0);
        result = 31 * result + (date_end_agreed != null ? date_end_agreed.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
