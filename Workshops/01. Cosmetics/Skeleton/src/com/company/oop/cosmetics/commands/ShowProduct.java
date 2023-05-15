package com.company.oop.cosmetics.commands;

import com.company.oop.cosmetics.commands.contracts.Command;
import com.company.oop.cosmetics.core.contracts.CosmeticsFactory;
import com.company.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.company.oop.cosmetics.models.products.Product;

import java.util.List;

public class ShowProduct implements Command {
    private CosmeticsRepository cosmeticsRepository;
    private CosmeticsFactory cosmeticsFactory;

    public ShowProduct(CosmeticsFactory cosmeticsFactory, CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsFactory = cosmeticsFactory;
        this.cosmeticsRepository = cosmeticsRepository;
    }
    @Override
    public String execute(List<String> parameters) {
        String productToShow = parameters.get(0);
        return showProduct(productToShow);
    }
    private String showProduct(String productToShow) {
        if (!cosmeticsRepository.getProducts().containsKey(productToShow)) {
            return String.format(CommandConstants.PRODUCT_DOES_NOT_EXIST, productToShow);
        }

        Product product = cosmeticsRepository.getProducts().get(productToShow);

        return product.print();
    }
}
