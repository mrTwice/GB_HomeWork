- #### Универсальный метод для проверки победы
      boolean isWin()
 
- #### Метод для бота, реализовывающий механизм, позволяющий в некоторых ситуациях предотвратить победу игрока в его следующий ход
      int[] checkHumansMoves()
 
- #### Методы непосредственно реализующие проверку победных комбинаций
      boolean firsDiagonal()
      boolean secondDiagonal()
      boolean horizontal()
      boolean vertical() 

- #### Универсальный метод для проверки победы для более активной блокировки ходов ползователя
      boolean findWinPlayersCombination()

- #### Метод добавляющий поиск предпобедных комбинаций.
      int[] checkPrevention()
 
- #### Методы непосредственно реализующие проверку победных комбинаций с учетом более жестких требований
      boolean firsDiagonalForBot()
      boolean secondDiagonalForBot()
      boolean horizontalForBot()
      boolean verticalForBot()