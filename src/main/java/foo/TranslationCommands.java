package foo;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Locale;

@ShellComponent
public class TranslationCommands {

    //private final TranslationService service;

    /*@Autowired
    public TranslationCommands(TranslationService service) {
        this.service = service;
    }*/

    @ShellMethod("Translate text from one language to another.")
    public String translate(
            @ShellOption() String text,
            @ShellOption(defaultValue = "en_US") Locale from,
            @ShellOption() Locale to
    ) {
        // invoke service
        //        return service.translate(text, from, to);
        System.out.println(String.format("%s,%s,%s", text, from, to));
        return "";
    }
}