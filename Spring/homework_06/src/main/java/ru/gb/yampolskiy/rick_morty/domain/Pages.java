package ru.gb.yampolskiy.rick_morty.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pages<T> {
    private Info info;
    private T[] results;
}
