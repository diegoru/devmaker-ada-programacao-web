package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.publisher.PublisherDescriptionDTO;
import br.com.ada.adabook.dto.publisher.PublisherListDTO;
import br.com.ada.adabook.dto.publisher.PublisherSaveDTO;

import java.util.List;

public interface PublisherService {
    List<PublisherListDTO> list();
    PublisherDescriptionDTO findById(Long id);
    PublisherListDTO save(PublisherSaveDTO publisherSaveDTO);
    PublisherListDTO update(Long id, PublisherSaveDTO publisherSaveDTO);
    void delete(Long id);

}
