package ru.gb.yampolskiy.rick_morty.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class Info {
    private int	count;
    private int	pages;
    private  String next;
    private  String prev;
}
