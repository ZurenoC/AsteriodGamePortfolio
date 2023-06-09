package dk.sdu.mmmi.cbse.playersystem;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PlayerPluginTest {
    private static GameData mockedGameData;
    private static World mockedWorld;
    private static PlayerPlugin playerPlugin;

    @BeforeAll
    static void setUp() {
        mockedGameData = mock(GameData.class);
        mockedWorld = mock(World.class);
        playerPlugin = new PlayerPlugin();
    }

    @Test
    @Order(1)
    void addPlayer() {
        playerPlugin.start(mockedGameData, mockedWorld);

        verify(mockedWorld).addEntity(any(Player.class));
    }

    @Test
    @Order(2)
    void removePlayer() {
        playerPlugin.stop(mockedGameData, mockedWorld);

        verify(mockedWorld).removeEntity(any(Player.class));
    }
}