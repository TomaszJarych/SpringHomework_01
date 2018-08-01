package pl.coderslab.classes;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component
public class SimpleCustomerLogger implements CustomerLogger {

	@Override
	public void log() {
		System.out.println(LocalDateTime.now()+ " : Customer operation ");
	}

}
// #### Zadanie 2
// 1. Utwórz interfejs `CustomerLogger` zawierający metodę `void log()`;
// 3. Utwórz klasę `SimpleCustomerLogger` implementującą interfejs
// `CustomerLogger`.
// 4. W ciele metody `log` dodaj wyświetlanie na konsoli napisu `<Aktualna data
// i godzina>: Customer operation`;
// 5. `SimpleCustomerLoggerImpl` - powinno być ziarnem zarządzanym przez
// Springa.
// 5. Utwórz initializer aplikacji Spring.
// 6. Utwórz obiekt kontekstu na podstawie konfiguracji.
// 7. Pobierz od kontekstu ziarno a następnie wywołaj na nim metodę log.