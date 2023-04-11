package br.com.ada.adabook.mapper;

import br.com.ada.adabook.domain.Publisher;
import br.com.ada.adabook.dto.publisher.PublisherDetailsDTO;
import br.com.ada.adabook.dto.publisher.PublisherListDTO;
import br.com.ada.adabook.dto.publisher.PublisherSaveDTO;
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

    public PublisherListDTO toPublisherDTO(Publisher author) {
        return modelMapper.map(author, PublisherListDTO.class);
    }

    public PublisherDetailsDTO toPublisherDescriptionDTO(Publisher publisher) {
        return modelMapper.map(publisher, PublisherDetailsDTO.class);
    }

}
