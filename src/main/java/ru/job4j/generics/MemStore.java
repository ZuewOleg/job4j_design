package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public boolean replace(String id, T model) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            mem.set(i, model);
        }
        return rsl;
    }

    @Override
    public boolean delete(String id) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            mem.remove(i);
        }
        return rsl;
    }

    @Override
    public T findById(String id) {
        int i = indexOf(id);
        return i < mem.size() ? mem.get(i) : null;
    }
}
