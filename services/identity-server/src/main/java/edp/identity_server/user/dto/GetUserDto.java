package edp.identity_server.user.dto;

import java.util.List;

import edp.identity_server.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetUserDto {
    private List<User> userList;
}
