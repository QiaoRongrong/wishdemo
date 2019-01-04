package org.qr.purejava.lam.domain;

import java.util.List;

/**
 * 专辑  曲目列表
 */
public class Album {

    private String name;

    private List<Track> tracks; //专辑中的曲目列表

    private List<Artist> musicians; //参与创作本专辑的艺术家列表
}
