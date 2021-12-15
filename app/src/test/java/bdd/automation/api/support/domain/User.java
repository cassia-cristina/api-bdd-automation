package bdd.automation.api.support.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @Builder.Default
    private int id = 12;
    @Builder.Default
    private String username = "naiara";
    @Builder.Default
    private String firstName = "Cassia";
    @Builder.Default
    private String lastName = "Souza";
    @Builder.Default
    private String email = "cassia@gmail.com";
    @Builder.Default
    private String password = "12345";
    @Builder.Default
    private String phone = "32480000";
    @Builder.Default
    private int userStatus = 1;

}
