package SeminarTask_02;

import SeminarTask_02.Interfaces.Food;
import SeminarTask_02.Interfaces.Thing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    //region Поля

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    //endregion

    //region Конструкторы

    /**
     * Создание нового экземпляра корзины
     * @param market принадлежность к магазину
     */
    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public void cardBalancing()
    {
        foodstuffs.stream()
                .filter(Food::getProteins)
                .findFirst()
                .ifPresentOrElse(
                        food -> {
                            System.out.println("Продукты с протеинами уже есть в корзине.\n");
                        },
                        () -> {
                            System.out.println("Продуктов с протеинами в корзине нет. Сейчас добавим.\n");
                            market.getThings(clazz).stream()
                                .filter(Food::getProteins)
                                .findFirst()
                                .map(foodstuffs::add);
                        }
                );

        foodstuffs.stream()
                .filter(Food::getCarbohydrates)
                .findFirst()
                .ifPresentOrElse(
                        food -> {
                            System.out.println("Продукты с углеводами уже есть в корзине.");
                        },
                        () -> {
                            System.out.println("Продуктов с углеводами в корзине нет. Сейчас добавим.");
                            market.getThings(clazz).stream()
                                    .filter(Food::getCarbohydrates)
                                    .findFirst()
                                    .map(foodstuffs::add);
                        }
                );

        foodstuffs.stream()
                .filter(Food::getFats)
                .findFirst()
                .ifPresentOrElse(
                        food -> {
                            System.out.println("Продукты с жирами уже есть в корзине.");
                        },
                        () -> {
                            System.out.println("Продуктов с жирами в корзине нет. Сейчас добавим.");
                            market.getThings(clazz).stream()
                                    .filter(Food::getFats)
                                    .findFirst()
                                    .map(foodstuffs::add);
                        }
                );

        if (foodstuffs.stream().anyMatch(Food::getProteins)
                && foodstuffs.stream().anyMatch(Food::getFats)
                && foodstuffs.stream().anyMatch(Food::getCarbohydrates))
        {
            System.out.println("Корзина сбалансирована по БЖУ.");
        } else
            System.out.println("Корзина не может быть сбалансирована.");


    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }



    public void printFoodstuffs()
    {
        /*int index = 1;
        for (var food : foodstuffs)
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n", index++, food.getName(), food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет", food.getCarbohydrates() ? "Да" : "Нет");*/


        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                index.getAndIncrement(), food.getName(),
                food.getProteins() ? "Да" : "Нет",
                food.getFats() ? "Да" : "Нет",
                food.getCarbohydrates() ? "Да" : "Нет"));
    }
}
