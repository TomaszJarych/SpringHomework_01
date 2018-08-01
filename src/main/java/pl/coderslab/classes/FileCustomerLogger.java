package pl.coderslab.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FileCustomerLogger implements CustomerLogger {
	@Value("custoremOperationLog.txt")
	private String fileName;

	@Override
	public void log() {
		try (FileWriter out = new FileWriter(this.fileName, true);){
			String logEntry = LocalDateTime.now() + " : Customer operation \n";
			out.append(logEntry);
			System.out.println(logEntry);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
// #### Zadanie 4
// 1. Utwórz implementację interfejsu `CustomerLogger` o nazwie
// `FileCustomerLogger`.
// 2. Klasa ma logować zmiany na klientach do pliku.
// 3. Dodaj w klasie właściwość `String` o nazwie `filename`, zmodyfikuj ziarno
// tak aby wstrzyknąć właściwość prostą z nazwą pliku logu.
// 4. Zmodyfikuj definicje wstrzykiwania tak aby repozytorium korzystało z
// nowego loggera.
// 5. Jeżeli korzystasz z automatycznego skanowania komponentów użyj w tym celu
// adnotacji `@Primary`.
//