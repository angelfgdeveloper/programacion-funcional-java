package com.platzi.functional._04_functional;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CLIArgumentsUtils {

    // Mostrar el manual cuando sea true
    static void showHelp(CLIArguments cliArguments) {
        // Consumer es una interface generica
        Consumer<CLIArguments> consumerHelper = cliArguments1 -> {
            if (cliArguments.isHelp()) {
                System.out.println("Manual solicitado");
            }
        };

        consumerHelper.accept(cliArguments);
    }

    //
    static CLIArguments generateCLI() {
        // Supplier es una interface generica (solo tiene metodo get())
        Supplier<CLIArguments> generator = () -> new CLIArguments();
        return generator.get();
    }

}
