% Сумма элементов списка
summ_el_from_list([], 0).
summ_el_from_list([Head|Tail], Sum) :-
% Вызов рекурсивной функции
    summ_el_from_list(Tail, SumTmp), Sum is SumTmp + Head.

% Запрос
?- summ_el_from_list([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], Sum)
