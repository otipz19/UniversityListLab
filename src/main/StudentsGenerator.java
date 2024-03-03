package main;

import main.model.entities.Student;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import main.model.valueObjects.Course;
import main.model.valueObjects.Group;
import main.model.valueObjects.PersonName;

import java.util.random.RandomGenerator;

public class StudentsGenerator {
    private static final RandomGenerator rng = RandomGenerator.getDefault();

    private static final String[] maleFirstNames = {"Олександр", "Іван", "Петро", "Михайло", "Андрій", "Сергій", "Володимир", "Василь", "Олег", "Юрій"};
    private static final String[] maleLastNames = {"Ковальчук", "Петренко", "Шевченко", "Бондаренко", "Коваль", "Мельник", "Козак", "Мороз", "Лисенко", "Білоус"};
    private static final String[] maleMiddleNames = {"Олександрович", "Іванович", "Петрович", "Михайлович", "Андрійович", "Сергійович", "Володимирович", "Васильович", "Олегович", "Юрійович"};

    private static final String[] femaleFirstNames = {"Олена", "Тетяна", "Наталія", "Ірина", "Людмила", "Надія", "Марія", "Оксана", "Вікторія", "Анна"};
    private static final String[] femaleLastNames = {"Ковальчук", "Петренко", "Шевченко", "Бондаренко", "Коваль", "Мельник", "Козак", "Мороз", "Лисенко", "Білоус"};
    private static final String[] femaleMiddleNames = {"Олександрівна", "Іванівна", "Петрівна", "Михайлівна", "Андріївна", "Сергіївна", "Володимирівна", "Василівна", "Олегівна", "Юріївна"};

    public static IMyList<Student> generate(int count) {
        var result = new MyList<Student>();
        for (int i = 0; i < count; i++) {
            result.add(generate());
        }
        return result;
    }

    private static Student generate() {
        PersonName firstName, middleName, lastName;
        boolean isFemale = rng.nextBoolean();
        if (isFemale) {
            firstName = getRandomName(femaleFirstNames);
            middleName = getRandomName(femaleMiddleNames);
            lastName = getRandomName(femaleLastNames);
        } else {
            firstName = getRandomName(maleFirstNames);
            middleName = getRandomName(maleMiddleNames);
            lastName = getRandomName(maleLastNames);
        }
        Course course = new Course(rng.nextInt(1, 5));
        Group group = new Group(rng.nextInt(1, 7));
        return new Student(firstName, middleName, lastName, group, course);
    }

    private static PersonName getRandomName(String[] arr) {
        return new PersonName(arr[rng.nextInt(0, arr.length)]);
    }
}
