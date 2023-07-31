
## Memory Model
The memory model describes possible behaviors of a program.
An implementation is free to produce any code it likes, as long as all
resulting executions of a program produce a result that can be predicted
by the memory model.
**Документы:** [Memory Model](https://docs.oracle.com/javase/specs/jls/se13/html/jls-17.html)

## Когда происходит
Happens-before Order

• Захват и освобождение монитора (обязательно того же).<br>
• Запись в volatile переменную и чтение из нее же.<br>
• Начало выполнения потока (вызов start()).<br>
• Завершение выполнения потока (вызов join()).<br>
• The default initialization of any object happens-before any other
actions (other than default)<br>

## Volatile
«Включаем» принудительную “видимость” значения
(«отключаем оптимизации»).<br>
Создаем Happens-before ребро.
**Пример:** [CounterVolatile](CounterVolatile.java)

## Synchronized
Организовать критическую секцию,
в которой будет только один поток.<br>
Ключевое слово: synchronized<br>
synchronized можно навесить на метод или на фрагмент кода.<br>
**Пример:** [CounterSynchronized](CounterSynchronized.java)
