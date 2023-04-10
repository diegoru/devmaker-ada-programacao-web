package br.com.ada.adabook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String address;
    private String district;
    private String city;
    private String state;
    private String code;

}