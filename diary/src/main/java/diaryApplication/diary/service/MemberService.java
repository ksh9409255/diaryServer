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

    // 자동 로그인만 구현하면 진짜 끝
    public void registerMember(MemberDto memberDto){ // 문제점, 안드에서는 카테고리id값을 int로만 받는다. 이것만 해결하면 로그인 끝
        memberRepository.save(memberDto.toEntity()
        );
    }

    public MemberDto findById(Long id){
        Member member = memberRepository.findById(id);
        return new MemberDto(member.getId(),member.getNickname(),member.getCategoryId());
    }

    /**
     * 회원가입 여부 확인 서비스
     * @return : 회원가입 됨 - true
     */
    public Boolean checkRegister(Long id){
        return memberRepository.checkRegister(id);
    }

    public void deleteMember(Long id){
        memberRepository.remove(id);
    }

    public void updateMember(MemberDto memberDto){
        Member member = memberRepository.findById(memberDto.getId());
        member.updateMember(memberDto.getNickName(),memberDto.getCategoryId());
    }

    public Boolean validNickName(String name){
        return memberRepository.validNickName(name);
    }
}
