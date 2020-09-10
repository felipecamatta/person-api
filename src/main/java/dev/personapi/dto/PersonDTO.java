package dev.personapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @Pattern(regexp = "^([0][1-9]|[1|2][0-9]|[3][0|1])[.\\-\\/]([0][1-9]|[1][0-2])[.\\-\\/]([1][0-9]{3}|[2][0][0-9]{2})$")
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

}
