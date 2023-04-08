package br.com.ada.adabook.service;

import br.com.ada.adabook.domain.Publisher;
import br.com.ada.adabook.dto.PublisherDTO;
import br.com.ada.adabook.dto.PublisherSaveDTO;
import br.com.ada.adabook.exceptions.PublisherNotFoundException;
import br.com.ada.adabook.mapper.PublisherMapper;
import br.com.ada.adabook.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public List<PublisherDTO> list() {
        List<Publisher> publishers = (List<Publisher>) publisherRepository.findAll();
        return publishers.stream().map(publisherMapper::toPublisherDTO).toList();
    }

    @Override
    public PublisherDTO findById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(PublisherNotFoundException::new);
        return publisherMapper.toPublisherDTO(publisher);
    }

    @Override
    public PublisherDTO save(PublisherSaveDTO publisherSaveDTO) {
        Publisher publisher = publisherMapper.toPublisher(publisherSaveDTO);
        publisherRepository.save(publisher);
        return publisherMapper.toPublisherDTO(publisher);
    }

    @Override
    public PublisherDTO update(Long id, PublisherSaveDTO publisherSaveDTO) {
        if (publisherRepository.existsById(id)) {
            Publisher publisher = publisherMapper.toPublisher(publisherSaveDTO);
            publisher.setId(id);
            return publisherMapper.toPublisherDTO(publisherRepository.save(publisher));
        }
        throw new PublisherNotFoundException();
    }

    @Override
    public void delete(Long id) {
        if (!publisherRepository.existsById(id)) {
            throw new PublisherNotFoundException();
        }
        publisherRepository.deleteById(id);
    }
}
