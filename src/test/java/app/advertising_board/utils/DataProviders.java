package app.advertising_board.utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProviders {
    public static Stream<Arguments> credentialsDataProvider() {
        return Stream.of(
                Arguments.of(ConfigLoader.getInstance().getIncorrectUserName(), ConfigLoader.getInstance().getIncorrectPassword()),
                Arguments.of(ConfigLoader.getInstance().getUserName(), ConfigLoader.getInstance().getIncorrectPassword()),
                Arguments.of(ConfigLoader.getInstance().getIncorrectUserName(), System.getProperty("PASSWORD"))
        );
    }
}
