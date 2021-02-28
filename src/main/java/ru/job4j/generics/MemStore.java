package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int i = Integer.parseInt(id);
        boolean rsl = i != -1;
        if (rsl) {
            mem.set(i, model);
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        int i = Integer.parseInt(id);
        boolean rsl = i != -1;
        if (rsl) {
            mem.remove(i);
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int i = Integer.parseInt(id);
        return i != -1 ? mem.get(i) : null;
    }
}
