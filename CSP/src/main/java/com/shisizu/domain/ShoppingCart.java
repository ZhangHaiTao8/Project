package com.shisizu.domain;

import lombok.Data;

import java.nio.channels.Pipe;

/**
 * @author 袁红
 * @create 2020-04-14-13:34
 */
@Data
public class ShoppingCart {
    private int bcid;
    private int bccount;
    private int bctotal;
    private int uid;
    private int gid;
    private String gpicture;
    private String gname;
    private int gprice;
}
