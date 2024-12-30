package edp.identity_server.user.permission.dto;

import java.util.List;

import edp.identity_server.user.permission.UserPermission;
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
public class GetUserPermissionDto {
    List<UserPermission> userPermissions;
}
