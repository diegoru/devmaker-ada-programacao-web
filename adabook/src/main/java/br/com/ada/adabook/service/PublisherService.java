package br.com.ada.adabook.service;

import br.com.ada.adabook.dto.PublisherDTO;
import br.com.ada.adabook.dto.PublisherSaveDTO;

import java.util.List;

public interface PublisherService {
    List<PublisherDTO> list();
    PublisherDTO findById(Long id);
    PublisherDTO save(PublisherSaveDTO publisherSaveDTO);
    PublisherDTO update(Long id, PublisherSaveDTO publisherSaveDTO);
    void delete(Long id);

}
