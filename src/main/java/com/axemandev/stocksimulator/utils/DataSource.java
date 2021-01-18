package com.axemandev.stocksimulator.utils;

import java.io.File;
import java.util.List;

public interface DataSource<T> {

    public List<T> read(File file);

    public boolean write(List<T> data);

    public boolean delete(T item);

}
