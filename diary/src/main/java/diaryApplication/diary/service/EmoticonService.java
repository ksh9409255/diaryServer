package diaryApplication.diary.service;

import diaryApplication.diary.domain.emoticon.Emoticon;
import diaryApplication.diary.domain.emoticon.EmoticonDto;
import diaryApplication.diary.repository.EmoticonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmoticonService {
    private final EmoticonRepository emoticonRepository;

    public void register(EmoticonDto emoticon){
        Emoticon newEmoticon = new Emoticon();
        emoticonRepository.save(newEmoticon.toEntity(emoticon));
    }
}
