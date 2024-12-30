package edp.identity_server.permission.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotEmpty;
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
public class CreatePermissionDto {
    @Nonnull
    @NotEmpty
    private String role;
}
