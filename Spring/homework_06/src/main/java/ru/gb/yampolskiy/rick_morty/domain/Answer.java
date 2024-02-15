package ru.gb.yampolskiy.rick_morty.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer<T> {
    private Info info;
    private T[] results;

}
