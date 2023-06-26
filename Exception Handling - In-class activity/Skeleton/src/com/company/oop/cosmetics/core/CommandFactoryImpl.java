package com.company.oop.cosmetics.core;

import com.company.oop.cosmetics.commands.*;
import com.company.oop.cosmetics.core.contracts.CommandFactory;
import com.company.oop.cosmetics.core.contracts.ProductRepository;
import com.company.oop.cosmetics.commands.contracts.Command;

public class CommandFactoryImpl implements CommandFactory {
    private static final String ILLEGAL_COMMAND = "Command %s is not supported.";

    @Override
    public Command createCommandFromCommandName(String commandTypeValue, ProductRepository productRepository) {
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(commandTypeValue.toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(String.format(ILLEGAL_COMMAND, commandTypeValue));
        }

        switch (commandType) {
            case CREATECATEGORY:
                return new CreateCategoryCommand(productRepository);
            case CREATEPRODUCT:
                return new CreateProductCommand(productRepository);
            case ADDPRODUCTTOCATEGORY:
                return new AddProductToCategoryCommand(productRepository);
            case SHOWCATEGORY:
                return new ShowCategoryCommand(productRepository);
            default:
                return null;
        }
    }

}
