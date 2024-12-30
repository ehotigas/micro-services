package edp.identity_server.user;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import edp.identity_server.user.permission.UserPermission;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column
    private Boolean deleted;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = false)
    private List<UserPermission> permissions;
}
