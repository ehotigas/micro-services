package edp.identity_server.user.permition.dto;

import java.util.List;

import edp.identity_server.user.permition.UserPermition;
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
public class GetUserPermitionDto {
    List<UserPermition> userPermitions;
}
