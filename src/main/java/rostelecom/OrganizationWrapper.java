package rostelecom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrganizationWrapper {

    public static class OrganizationEntity {
        public Long id;
        public Long parentId;
        public String name;

        public OrganizationEntity(
            Long id,
            Long parentId,
            String name
        ) {
            this.id = id;
            this.parentId = parentId;
            this.name = name;
        }
    }

    public static class OrganizationDto {
        public Long id;
        public String name;
        public List<OrganizationDto> childs = new ArrayList<>();

        public OrganizationDto(
            Long id,
            String name
        ) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OrganizationDto that = (OrganizationDto) o;
            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public List<OrganizationDto> mapper(List<OrganizationEntity> entities) {
        List<OrganizationDto> result = new ArrayList<>();

        Map<Long, OrganizationDto> bankId = entities.stream()
            .map(e -> new OrganizationDto(e.id, e.name))
            .collect(Collectors.toMap(organizationEntity -> organizationEntity.id, Function.identity()));

        for (OrganizationEntity entity : entities) {
            if (entity.parentId != null) {
                OrganizationDto dto = bankId.get(entity.parentId);
                dto.childs.add(bankId.get(entity.id));
            } else {
                result.add(bankId.get(entity.id));
            }
        }

        return result;
    }
}