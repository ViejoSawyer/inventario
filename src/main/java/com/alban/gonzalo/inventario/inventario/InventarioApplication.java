package com.alban.gonzalo.inventario.inventario;

import com.alban.gonzalo.inventario.inventario.entity.Store;
import com.alban.gonzalo.inventario.inventario.service.ProductService;
import com.alban.gonzalo.inventario.inventario.service.StoreService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InventarioApplication implements CommandLineRunner {

	private final ProductService productService;

	private final StoreService storeService;

	public InventarioApplication(ProductService productService, StoreService storeService) {
		this.productService = productService;
		this.storeService = storeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.save();

		Store store1 = new Store("str1", "Store Center");
		Store store2 = new Store("str2", "Store North");
		Store store3 = new Store("str3", "Store East");
		Store store4 = new Store("str4", "Store West");
		List<Store> stores = Arrays.asList(store1, store2, store3, store4);
		storeService.chargeStores(stores);
	}
}
