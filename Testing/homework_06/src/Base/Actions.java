package Base;

import java.util.List;


public class Actions implements AverageMean {
    @Override
    public double AverageMean(List<Integer> list) {
        if(list == null || list.isEmpty())
            throw new RuntimeException("Список пуст!");
        double averageMean = list.stream().mapToInt(Integer::intValue).sum()/list.size();
        return averageMean;
    }
}
