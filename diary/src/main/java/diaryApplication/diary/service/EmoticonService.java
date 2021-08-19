package diaryApplication.diary.service;

import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.repository.EmoticonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmoticonService {
    private final EmoticonRepository emoticonRepository;

    public void register(EmoticonDto emoticon){
        emoticonRepository.save(emoticon.toEntity());
    }
}
