package sh.platform.template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WishTest {

    @Test
    public void shouldCreateWish() {
        Wish wish = Wish.of("happy");
        Assertions.assertNotNull(wish);
    }

    @Test
    public void shouldReturnNullWhenParameterIsNull() {
        assertThrows(NullPointerException.class, () ->
                Wish.of(null));
    }
}