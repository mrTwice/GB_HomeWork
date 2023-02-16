import itertools
min_len = 3 
def schet(kolvo: list, res = 0) -> int:
    c = 0
    for num, group in itertools.groupby(kolvo):
        lg = len(list(group)) 
        c += lg
        if lg >= min_len: 
            return schet(kolvo[:c-lg]+kolvo[c:], res+lg)  
    return res
print(schet(input().split())) 