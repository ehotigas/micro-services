package edp.identity_server.permission.dto;

import java.util.List;

import edp.identity_server.permission.Permission;
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
public class GetPermissionDto {
    private List<Permission> permissions;
}
