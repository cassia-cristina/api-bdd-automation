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
    private String firstName = "Najara";

    @Builder.Default
    private String lastName = "Souza";

    @Builder.Default
    private String email = "naiara@gmail.com";

    @Builder.Default
    private String password = "12345";

    @Builder.Default
    private String phone = "32480001";

    @Builder.Default
    private int userStatus = 1;

}
