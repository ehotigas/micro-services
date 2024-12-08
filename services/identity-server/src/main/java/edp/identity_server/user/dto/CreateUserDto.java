package edp.identity_server.user.dto;

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
public class CreateUserDto {
    @Nonnull
    @NotEmpty
    private String name;
    
    @Nonnull
    @NotEmpty
    private String username;
    
    @Nonnull
    @NotEmpty
    private String email;
    
    @Nonnull
    @NotEmpty
    private String password;
}
