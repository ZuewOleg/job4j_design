package ru.job4j.ollection;

/** Данные очереди нужно хранить в ru.job4j.collection.SimpleStack.
 * Для этого задания нужны два стека.
 * Представьте, что у вас стопка с тарелками. Вам нужно достать нижнюю тарелку.
 * Для этого вы перекладываете все тарелки в другую стопку.
 * Стопка - это стек. Для операции извлечения первой тарелки нужны две стопки. */
public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /** должен возвращать первое значение и удалять его из коллекции */
    public T poll() {
        out.push(in.pop());
        return out.pop();
    }

    /** помещает значение в конец */
    public void push(T value) {
        in.push(value);
    }
}
