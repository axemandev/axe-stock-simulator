package com.axemandev.stocksimulator.utils;

import com.axemandev.stocksimulator.mapper.StockMapper;
import com.opencsv.CSVReader;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.mapstruct.factory.Mappers;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataSourceFactory {

    @Builder
    @NoArgsConstructor
    public static class CSVDataSource<T> implements DataSource<T> {

        @SneakyThrows
        @Override
        public List<T> read(File file) {
            CSVReader csvReader = null;
            csvReader = new CSVReader(new FileReader(file));
            return extractData(csvReader);
        }

        @Override
        public boolean write(List<T> data) {
            return false;
        }

        @Override
        public boolean delete(T item) {
            return false;
        }

        @SneakyThrows
        private List<T> extractData(CSVReader reader) {
            String[] dataRow, header = {};
            Boolean headerProcessed = false;
            List<T> data = new ArrayList<>();

            while ((dataRow = reader.readNext()) != null) {
                if (!headerProcessed) {
                    header = cleanup(dataRow);
                    headerProcessed = true;
                    continue;
                }
                data.add(mapData(header, dataRow));
            }
            return data;
        }

        private T mapData(String[] header, String[] row) {
            Properties properties = new Properties();
            for (int i = 0; i < header.length; i++) {
                properties.put(header[i].trim(), row[i].trim());
            }
            return (T) Mappers.getMapper(StockMapper.class).propertiesToStock(properties);
        }

        private String[] cleanup(String[] data) {
            data[0] = data[0].substring(1);
            return data;
        }
    }
}
