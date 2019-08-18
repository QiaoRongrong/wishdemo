package org.qr.purejava.lam.domain;


import lombok.Data;

/**
 * 艺术家, 个人或者团队
 */
@Data
public class Artist {

    private String name;
    private String members; //成员
    private String origin;  //来自, 如: 利物浦


}
