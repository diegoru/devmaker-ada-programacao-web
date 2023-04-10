package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Address;
import br.com.ada.adabook.dto.AddressDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddressMapper {

    private final ModelMapper modelMapper;

    public Address toAddress(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }
}
