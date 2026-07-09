package junit_4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class RPGCharacterTest {
    @Test
    void testInitialStatus() {
        RPGCharacter character = new RPGCharacter();
        assertEquals(1, character.getLevel(), "初期レベルは1であるはず");
        assertEquals(100, character.getHP(), "初期HPは100であるはず");
        assertEquals(50, character.getMP(), "初期MPは50であるはず");
    }

    @Test
    void testNormalLevelUp() {
        RPGCharacter character = new RPGCharacter();
        character.levelUp();
        assertEquals(2, character.getLevel(), "レベルが2になるはず");
        assertEquals(110, character.getHP(), "HPが110になるはず");
        assertEquals(55, character.getMP(), "MPが55になるはず");
    }

    @Test
    void testMaxLevel() {
        RPGCharacter character = new RPGCharacter();
        for (int i = 1; i < 99; i++) {
            character.levelUp();
        }
        assertEquals(99, character.getLevel(), "レベルが99になるはず");
        assertEquals(1080, character.getHP(), "HPが1080になるはず");
        assertEquals(540, character.getMP(), "MPが540になるはず");

        RPGCharacter character1 = new RPGCharacter();

        for (int i = 1; i < 99; i++) {
            character1.levelUp();
        }
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> character1.levelUp(), "最大レベルで例外が発生するはず");
        assertEquals("最大レベルに達しています" , exception.getMessage());


        RPGCharacter character2 = new RPGCharacter();
        for (int i = 1; i < 99; i++) {
            character2.levelUp();
        }
        try {
            character2.levelUp();
            fail("最大レベルで例外が発生するはず");
        } catch (IllegalStateException e) {
            assertEquals("最大レベルに達しています" , e.getMessage());
        }
    }
}
