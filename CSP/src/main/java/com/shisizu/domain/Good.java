package com.shisizu.domain;

import lombok.Data;

/**
 * @author ZhangCaiLei
 * @date 2020-04-10 16:24
 */
@Data
public class Good {
    private Integer gId;
    private String gName;
    private Integer uId;
    // private String uname;
    private Integer gPrice;
    private String gType;
    private Integer gCount;
    private String gPicture;
    private String gDetails;
}
