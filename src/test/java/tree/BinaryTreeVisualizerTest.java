package tree;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tree.solution.SolutionMax;
import tree.solution.SolutionMaxPath;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.BTreePrinter.printNode;

/** The type BinaryTreeVisualizerTest */
public class BinaryTreeVisualizerTest {

    @ParameterizedTest
    @DisplayName("Максимальный путь дереве")
    @MethodSource("provideSolutionsAndIntAnswer")
    public void maxPathTest(
        final Solution solution,
        final int result
    ) {
        printNode(solution.getRoot());
        int maxPath = solution.maxPathSum();
        System.out.println("result: " + maxPath + "\n");

        assertEquals(result, maxPath);
    }

    private static Stream<Arguments> provideSolutionsAndIntAnswer() {
        return Stream.of(
            Arguments.of(Named.of("SolutionMax", new SolutionMax()), 30),
            Arguments.of(Named.of("SolutionMaxPath", new SolutionMaxPath()), 13)
        );
    }
}