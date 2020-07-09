package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CanBoYTeModel {
    public String ten;
    public String chungChiHanhNghe;

}
