package diaryApplication.diary.service;

import diaryApplication.diary.domain.friend.Friend;
import diaryApplication.diary.domain.friend.FriendDto;
import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.repository.FriendRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendServiceTest {

    @Autowired FriendService friendService;
    @Autowired FriendRepository friendRepository;
    @Autowired FriendDto friendDto = new FriendDto(1L, 2L);

    @Test
    @Transactional
    void save() {
    }

    @Test
    @Transactional
    void findAll() {
        MemberDto member1 = new MemberDto(1L,"kim", 1);
        MemberDto member2 = new MemberDto(2L,"yoon", 1);

        friendService.add(friendDto);
        friendService.save(friendDto);

        friendRepository.findAll(1L);
    }
}