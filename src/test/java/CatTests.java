import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    // Создаём мок изолированной зависимости Feline
    private final Feline feline = Mockito.mock(Feline.class);

    private Cat cat;

    // Перед каждым тестом изолированно создаём новый объект Cat с подставленным моком
    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    // Проверяем, что метод getSound() возвращает характерный звук "Мяу"
    @Test
    public void getSoundReturnsMeow() {
        String expected = "Мяу";
        String result = cat.getSound();

        Assert.assertEquals(expected, result);
    }

    // Проверяем, что cat.getFood() обращается к методу feline.eatMeat() и возвращает полученный список еды
    @Test
    public void getFoodCallsEatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expected);

        List<String> actual = cat.getFood();

        Assert.assertEquals(expected, actual);
        Mockito.verify(feline).eatMeat();
    }
}