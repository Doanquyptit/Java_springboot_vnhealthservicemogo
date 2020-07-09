package demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DanhMucModel {
//            "ma": "1",
//            "ten": "Nữ",
//            "maicd": "",
//            "code": "",
//            "codeSystem": ""
    public String ma ="";
    public String ten="";

    @JsonIgnore
    public String maicd="";
    @JsonIgnore
    public String code="";
    @JsonIgnore
    public String codeSystem="";

    public Map<String,Object> extension;


}
