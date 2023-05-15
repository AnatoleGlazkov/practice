package algorithms.yandex;

import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

import static utils.ArrayUtils.checkInteger;

/** The type NumberOfRecentCalls */
public class NumberOfRecentCallsTest {


    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new Integer[][]{
                {},
                {1},
                {100},
                {3001},
                {3002}
            }, new Integer[]{null, 1, 2, 3, 3})
        );
    }

    @ParameterizedTest
    @DisplayName("933. Number of Recent Calls")
    @MethodSource("provideData")
    void numberOfRecentCalls(
        Integer[][] request,
        Integer[] expected
    ) {

        final RecentCounter recentCounter = new RecentCounter();
        final Integer[] result = new Integer[request.length];

        for (int i = 0; i < result.length; i++) {
            if (request[i].length != 0) {
                int ping = recentCounter.ping(request[i][0]);
                result[i] = ping != 0
                            ? ping
                            : null;
            }
        }

        Assertions.assertTrue(checkInteger(expected, result));
    }

    static class RecentCounter {

        final private Queue<Integer> bank;

        public RecentCounter() {
            bank = new PriorityQueue<>();
        }

        public int ping(@NonNull int t) {
            bank.add(t);
            execute(t);
            return bank.size();
        }

        private void execute(Integer t) {
            if (!bank.isEmpty() && bank.peek() < t - 3000) {
                bank.poll();
                execute(t);
            }
        }
    }
}


