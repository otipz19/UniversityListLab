package main.model.utils.sorting.comparators;

import java.text.ParseException;
import java.text.RuleBasedCollator;

public class NamesLocaleComparator {
    private static final String rules = "< 'А' < 'Б' < 'В' < 'Г' < 'Ґ' < 'Д' < 'Е' < 'Є' < 'Ж' < 'З' < 'И' < 'І' < 'Ї' < 'Й' < 'К' < 'Л' < 'М' < 'Н' < 'О' < 'П' < 'Р' < 'С' < 'Т' < 'У' < 'Ф' < 'Х' < 'Ц' < 'Ч' < 'Ш' < 'Щ' < 'Ь' < 'Ю' < 'Я'"
            + "< 'а' < 'б' < 'в' < 'г' < 'ґ' < 'д' < 'е' < 'є' < 'ж' < 'з' < 'и' < 'і' < 'ї' < 'й' < 'к' < 'л' < 'м' < 'н' < 'о' < 'п' < 'р' < 'с' < 'т' < 'у' < 'ф' < 'х' < 'ц' < 'ч' < 'ш' < 'щ' < 'ь' < 'ю' < 'я'";

    private static final RuleBasedCollator ukrainianCollator;

    static {
        try {
            ukrainianCollator = new RuleBasedCollator(rules);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static int compare(String left, String right) {
        return ukrainianCollator.compare(left, right);
    }
}
