package diaryApplication.diary.controller;

import diaryApplication.diary.domain.member.MemberDto;
import diaryApplication.diary.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<MemberDto> findById(@RequestParam("id") Long id){
        return new ResponseEntity(memberService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity registerMember(@RequestBody MemberDto member){
        memberService.registerMember(member);
        return new ResponseEntity(HttpStatus.OK);
    }
}
