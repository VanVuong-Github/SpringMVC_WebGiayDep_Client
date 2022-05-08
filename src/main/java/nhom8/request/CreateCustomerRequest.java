package nhom8.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CreateCustomerRequest {
	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String urlImage;
}
