package Base;

import java.util.List;


public class Actions {
    public double AverageMean(List<Integer> list) {
        if(list == null || list.isEmpty() || list.contains(null))
            throw new RuntimeException("Список пуст!");
        double average = list.stream().mapToInt(Integer::intValue).sum();
        double averageMean = average/list.size();
        return averageMean;
    }
}
