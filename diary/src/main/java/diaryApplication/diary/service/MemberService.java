package diaryApplication.diary.service;

import diaryApplication.diary.domain.member.Member;
import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public void registerMember(MemberDto memberDto){
        memberRepository.save(memberDto.toEntity());
    }

    public MemberDto findById(Long id){
        Member member = memberRepository.findById(id);
        return new MemberDto(member.getId(),member.getNickname(),member.getCategoryId());
    }
}
