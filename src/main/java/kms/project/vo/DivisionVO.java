package kms.project.vo;

public class DivisionVO {
    private int division_code ; // 분류 인덱스
    private String division_lType ;
    private String division_mType;
    private String division_sType;

    public int getDivision_code() {
        return division_code;
    }

    public void setDivision_code(int division_code) {
        this.division_code = division_code;
    }

    public String getDivision_lType() {
        return division_lType;
    }

    public void setDivision_lType(String division_lType) {
        this.division_lType = division_lType;
    }

    public String getDivision_mType() {
        return division_mType;
    }

    public void setDivision_mType(String division_mType) {
        this.division_mType = division_mType;
    }

    public String getDivision_sType() {
        return division_sType;
    }

    public void setDivision_sType(String division_sType) {
        this.division_sType = division_sType;
    }
}
