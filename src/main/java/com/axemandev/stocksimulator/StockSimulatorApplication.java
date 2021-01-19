package com.axemandev.stocksimulator;

import com.axemandev.stocksimulator.exception.StockExceptionHandler;
import com.axemandev.stocksimulator.model.Stock;
import com.axemandev.stocksimulator.service.StockService;
import com.axemandev.stocksimulator.utils.DataSource;
import com.axemandev.stocksimulator.utils.DataSourceFactory;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StockSimulatorApplication {

	@Autowired
	StockService stockService;

	public static void main(String[] args) {
		SpringApplication.run(StockSimulatorApplication.class, args);
	}

	@PostConstruct
	public void init() throws IOException {
		DataSource<Stock> dataSource = new DataSourceFactory.CSVDataSource();
		List<Stock> stocks = dataSource.read(new ClassPathResource("stock-data.csv").getFile());
		stockService.loadStocks(stocks);
	}
}
