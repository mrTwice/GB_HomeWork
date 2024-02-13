package ru.gb.yampolskiy.rick_morty.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
public class Result {
    List<Character> allCharacters;
}
