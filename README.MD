# Справка
## Checks
Проверка определенных условий перед операциями с объектом.

## Использование
### Простые проверки
#### Проверка объекта с помощью ```notNull()```
Данный метод проверяет, не является ли объект ```null```.

```java
import dev.kalenchukov.checks.Checks;

String object = "Алюминивые огурцы";
Checks.require(object).notNull();
```

Результат выполнения:

Если объект является ```null```, будет вызвано исключение ```NullObjectCheckException```.

#### Проверка объекта с помощью ```notEquals()```
Данный метод проверяет, не является ли объект равным заданному объекту.

```java
import dev.kalenchukov.checks.Checks;

String object = "Невесёлая песня";
Checks.require(object).notEquals("Наше утро похоже на ночь");
```

Результат выполнения:

Если объект равен заданному объекту, будет вызвано исключение ```EqualsObjectCheckException```.

#### Проверка объекта с помощью ```notEmpty()```
Данный метод проверяет, не является ли значение объекта пустым.

Поддерживаемые типы:
* String
* CharSequence
* StringBuilder
* Array
* Collection
* List
* Set
* Map

```java
import dev.kalenchukov.checks.Checks;

String object = "Песня для БГ";
Checks.require(object).notEmpty();
```

Результат выполнения:

Если значение объекта является пустым, будет вызвано исключение ```EmptyObjectCheckException```.


#### Проверка объекта с помощью ```notBlank()```
Данный метод проверяет, не является ли значение объекта пустым, с игнорированием белых символов.

Поддерживаемые типы:
* String

```java
import dev.kalenchukov.checks.Checks;

String object = "Мои друзья";
Checks.require(object).notBlank();
```

Результат выполнения:

Если значение объекта является пустым, будет вызвано исключение ```BlankObjectCheckException```.

#### Проверка объекта с помощью ```notZero()```
Данный метод проверяет, не является ли значение объекта нулём.

Поддерживаемые типы:
* Integer

```java
import dev.kalenchukov.checks.Checks;

Integer object = 100;
Checks.require(object).notZero();
```

Результат выполнения:

Если значение объекта является нулём, будет вызвано исключение ```ZeroNumberObjectCheckException```.

#### Проверка объекта с помощью ```notPositive()```
Данный метод проверяет, не является ли значение объекта положительным числом.

Поддерживаемые типы:
* Integer

```java
import dev.kalenchukov.checks.Checks;

Integer object = -99;
Checks.require(object).notPositive();
```

Результат выполнения:

Если значение объекта является положительным числом, будет вызвано исключение ```PositiveNumberObjectCheckException```.

#### Проверка объекта с помощью ```notNegative()```
Данный метод проверяет, не является ли значение объекта отрицательным числом.

Поддерживаемые типы:
* Integer

```java
import dev.kalenchukov.checks.Checks;

Integer object = 34;
Checks.require(object).notNegative();
```

Результат выполнения:

Если значение объекта является отрицательным числом, будет вызвано исключение ```NegativeNumberObjectCheckException```.

#### Проверка объекта с помощью ```notLessNumber()```
Данный метод проверяет, не является ли значение объекта меньше заданного числа.

Поддерживаемые типы:
* Integer

```java
import dev.kalenchukov.checks.Checks;

Integer object = 87;
Checks.require(object).notLessNumber(4);
```

Результат выполнения:

Если значение объекта меньше заданного числа, будет вызвано исключение ```LessNumberObjectCheckException```.

#### Проверка объекта с помощью ```notMoreNumber()```
Данный метод проверяет, не является ли значение объекта больше заданного числа.

Поддерживаемые типы:
* Integer

```java
import dev.kalenchukov.checks.Checks;

Integer object = 3;
Checks.require(object).notMoreNumber(6);
```

Результат выполнения:

Если значение объекта больше заданного числа, будет вызвано исключение ```MoreNumberObjectCheckException```.

#### Проверка объекта с помощью ```notRangeNumber()```
Данный метод проверяет, не является ли значение объекта в пределах заданного диапазона чисел.

Поддерживаемые типы:
* Integer

```java
import dev.kalenchukov.checks.Checks;

Integer object = 11;
Checks.require(object).notRangeNumber(5, 10);
```

Результат выполнения:

Если значение объекта находится в пределах заданного диапазона чисел, будет вызвано исключение ```RangeNumberObjectCheckException```.

#### Проверка объекта с помощью ```notSize()```
Данный метод проверяет, не является ли количество элементов объекта равно заданному числу.

Поддерживаемые типы:
* Array
* Collection
* List
* Set
* Map

```java
import dev.kalenchukov.checks.Checks;

List<String> object = List.of(
	"Пачка сигарет",
	"Стук"
);
Checks.require(object).notSize(5);
```

Результат выполнения:

Если количество элементов объекта равно заданному числу, будет вызвано исключение ```SizeObjectCheckException```.

#### Проверка объекта с помощью ```notLessSize()```
Данный метод проверяет, не является ли количество элементов объекта меньше заданного числа.

Поддерживаемые типы:
* Array
* Collection
* List
* Set
* Map

```java
import dev.kalenchukov.checks.Checks;

Set<String> object = Set.of(
	"Последний герой",
	"В наших глазах",
	"Спокойная ночь"
);
Checks.require(object).notLessSize(2);
```

Результат выполнения:

Если количество элементов объекта меньше заданного числа, будет вызвано исключение ```LessSizeObjectCheckException```.

#### Проверка объекта с помощью ```notMoreSize()```
Данный метод проверяет, не является ли количество элементов объекта больше заданного числа.

Поддерживаемые типы:
* Array
* Collection
* List
* Set
* Map

```java
import dev.kalenchukov.checks.Checks;

Map<Integer, String> object = Map.of(
	1, "Нам с тобой",
	2, "Звезда",
	3, "Следи за собой"
);
Checks.require(object).notMoreSize(3);
```

Результат выполнения:

Если количество элементов объекта больше заданного числа, будет вызвано исключение ```MoreSizeObjectCheckException```.

#### Проверка объекта с помощью ```notRangeSize()```
Данный метод проверяет, не является ли количество элементов объекта равно заданному диапазону чисел.

Поддерживаемые типы:
* Array
* Collection
* List
* Set
* Map

```java
import dev.kalenchukov.checks.Checks;

String[] object = {
	"Закрой за мной дверь",
	"Дальше действовать будем мы",
	"Камчатка",
	"Бездельник"
};
Checks.require(object).notRangeSize(1, 2);
```

Результат выполнения:

Если количество элементов объекта равно заданному диапазону чисел, будет вызвано исключение ```RangeSizeObjectCheckException```.

#### Проверка объекта с помощью ```notLength()```
Данный метод проверяет, не является ли количество символов объекта равному заданному чисел.

Поддерживаемые типы:
* String
* CharSequence
* StringBuilder

```java
import dev.kalenchukov.checks.Checks;

String object = "Место для шага вперёд";
Checks.require(object).notLength(15);
```

Результат выполнения:

Если количество символов объекта равному заданному чисел, будет вызвано исключение ```LengthObjectCheckException```.

#### Проверка объекта с помощью ```notLessLength()```
Данный метод проверяет, не является ли количество символов объекта меньше заданного числа.

Поддерживаемые типы:
* String
* CharSequence
* StringBuilder

```java
import dev.kalenchukov.checks.Checks;

String object = "Мама, мы все сошли с ума";
Checks.require(object).notLessLength(10);
```

Результат выполнения:

Если количество символов объекта меньше заданного числа, будет вызвано исключение ```LessLengthObjectCheckException```.

#### Проверка объекта с помощью ```notMoreLength()```
Данный метод проверяет, не является ли количество символов объекта больше заданного числа.

Поддерживаемые типы:
* String
* CharSequence
* StringBuilder
* Array
* Collection
* List
* Set
* Map
* Integer

```java
import dev.kalenchukov.checks.Checks;

String object = "Попробуй спеть вместе со мной";
Checks.require(object).notMoreLength(50);
```

Результат выполнения:

Если количество символов объекта больше заданного числа, будет вызвано исключение ```MoreLengthObjectCheckException```.

#### Проверка объекта с помощью ```notRangeLength()```
Данный метод проверяет, не является ли количество символов объекта равно заданному диапазону чисел.

Поддерживаемые типы:
* String
* CharSequence
* StringBuilder

```java
import dev.kalenchukov.checks.Checks;

String object = "Малыш";
Checks.require(object).notRangeLength(1, 4);
```

Результат выполнения:

Если количество символов объекта равно заданному диапазону чисел, будет вызвано исключение ```RangeLengthObjectCheckException```.

### Собственное условие проверки
Для нестандартных проверок, можно использовать собственные условия проверки с помощью ```Predicate```.

```java
import java.util.function.Predicate;
import dev.kalenchukov.checks.Checks;

String object = "Hello, world!";
Predicate<String> predicate = (value) -> (value.matches("[0-9]+"));
Checks.require(object).not(predicate);
```

Результат выполнения:

Если объект удовлетворяет условию, будет вызвано исключение ```IllegalObjectCheckException```.

### Комбинированные проверки
```java
import dev.kalenchukov.checks.Checks;

String object = "Текст";
Checks.require(object).notNull().notEmpty().notMoreLength(100);
```

Результат выполнения:
* Если объект окажется ```null```, будет вызвано исключение ```NullObjectCheckException```.
* Если строка окажется пустой, будет вызвано исключение ```EmptyObjectCheckException```.
* Если длина строка окажется больше 100 символов, будет вызвано исключение ```MoreLengthObjectCheckException```.

### Возврат объекта
Проверяемый объект можно вернуть, если он успешно прошёл все проверки.
Для этого необходимо использовать метод ```get()``` в самом конце цепочки проверок.

Данную возможность приятно использовать в конструкторе класса.

```java
import dev.kalenchukov.checks.Checks;

public class Kino
{
	private String name;

	public Kino(final String name)
	{
		this.name = Checks.require(name).notNull().get();
	}
}
```

#### Исключение
#### Сообщение исключения
Задать сообщение исключения можно для каждой проверки. Для этого необходимо передать сообщение параметром метода.

```java
import dev.kalenchukov.checks.Checks;

String object = "Текст";
Checks.require(object)
	.notNull("Строка не должна быть null.")
	.notEmpty("Строка не должна быть пуста.")
	.notMoreLength(100, "Строка не должна быть больше 100 символов.");
```

#### Виновник исключения
Получить объект, который вызвал исключение, можно из объекта исключения.

```java
import dev.kalenchukov.checks.Checks;
import dev.kalenchukov.checks.exceptions.MoreLengthObjectCheckException;

String object = "Текст";

try
{
	Checks.require(object).notMoreLength(1);
}
catch (MoreLengthObjectCheckException exception)
{
	exception.getCulprit();
}
```
