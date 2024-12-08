package edp.identity_server.permition.dto;

import java.util.List;

import edp.identity_server.permition.Permition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetPermitionDto {
    private List<Permition> permitions;
}
