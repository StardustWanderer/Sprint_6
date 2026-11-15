import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    // Мокаем зависимость Feline для изоляции тестов класса Lion
    @Mock
    private Feline feline;

    // Проверяем обработку невалидных данных: конструктор должен выбрасывать Exception с понятным сообщением
    @Test
    public void constructorThrowsExceptionWhenSexIsInvalid() {
        String expectedExceptionString = "Используйте допустимые значения пола животного - самец или самка";
        try {
            new Lion("Вертолет", feline);
            Assert.fail("Исключение не было выброшено");
        } catch (Exception exception) {
            Assert.assertEquals(expectedExceptionString, exception.getMessage());
        }
    }

    // Проверяем, что lion.getKittens() запрашивает количество котят у зависимости feline
    @Test
    public void getKittensReturnsValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expected = 999;
        Mockito.when(feline.getKittens()).thenReturn(expected);

        Assert.assertEquals(expected, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    // Проверяем, что lion.getFood() вызывает метод feline.getFood("Хищник") и возвращает рацион хищника
    @Test
    public void getFoodReturnsFoodList() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);

        Assert.assertEquals(expected, lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}