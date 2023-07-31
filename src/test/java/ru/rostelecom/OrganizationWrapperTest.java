package ru.rostelecom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.rostelecom.OrganizationWrapper.OrganizationDto;

import java.util.List;
import java.util.stream.Stream;

import static ru.rostelecom.OrganizationWrapper.OrganizationEntity;

/** The type OrganizationWrapperTest */
class OrganizationWrapperTest {

    private OrganizationWrapper wrapper;

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                List.of(
                    new OrganizationEntity(1L, null, "RTK"),
                    new OrganizationEntity(2L, 1L, "Sales"),
                    new OrganizationEntity(3L, 2L, "Marketing"),
                    new OrganizationEntity(4L, 1L, "Finance"),
                    new OrganizationEntity(5L, null, "Sber")
                ),
                expectedData()
            )
        );
    }

    private static List<OrganizationDto> expectedData() {
        OrganizationDto dto1 = new OrganizationDto(1L, "RTK");
        OrganizationDto dto2 = new OrganizationDto(2L, "Sales");
        OrganizationDto dto3 = new OrganizationDto(3L, "Marketing");
        OrganizationDto dto4 = new OrganizationDto(4L, "Finance");
        OrganizationDto dto5 = new OrganizationDto(5L, "Sber");

        dto1.childs.add(dto2);
        dto1.childs.add(dto4);
        dto2.childs.add(dto3);

        return List.of(dto1, dto5);
    }

    @BeforeEach
    void setUp() {
        wrapper = new OrganizationWrapper();
    }

    @ParameterizedTest
    @DisplayName("Wrapper")
    @MethodSource("source")
    void wrapper(
        List<OrganizationEntity> entities,
        List<OrganizationDto> expected
    ) {
        List<OrganizationDto> mapper = wrapper.mapper(entities);

        Assertions.assertEquals(expected, mapper);
    }
}