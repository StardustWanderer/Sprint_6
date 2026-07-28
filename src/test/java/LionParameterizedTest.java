import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

// Параметризованный тест для проверки наличия гривы у льва в зависимости от его пола
@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expected;

    // Конструктор принимает входные тестовые данные для каждого запуска
    public LionParameterizedTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    // Набор данных: пол животного и ожидаемое наличие гривы (true/false)
    @Parameterized.Parameters(name = "{0} has mane = {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    // Проверяем, что doesHaveMane() возвращает корректный булев результат для всех валидных полов
    @Test
    public void hasManeReturnsCorrectValue() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, feline);

        Assert.assertEquals(expected, lion.doesHaveMane());
    }
}