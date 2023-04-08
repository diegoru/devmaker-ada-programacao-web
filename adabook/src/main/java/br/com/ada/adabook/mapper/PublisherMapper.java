package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Publisher;
import br.com.ada.adabook.dto.PublisherDTO;
import br.com.ada.adabook.dto.PublisherSaveDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PublisherMapper {

    private final ModelMapper modelMapper;

    public Publisher toPublisher(PublisherSaveDTO authorSaveDTO) {
        return modelMapper.map(authorSaveDTO, Publisher.class);
    }

    public PublisherDTO toPublisherDTO(Publisher author) {
        return modelMapper.map(author, PublisherDTO.class);
    }

}
