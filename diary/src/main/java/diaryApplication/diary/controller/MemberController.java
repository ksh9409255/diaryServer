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
        System.out.println("save");
        memberService.registerMember(member);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkRegister(@RequestParam("id") Long id){
        return new ResponseEntity(memberService.checkRegister(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteMember(@RequestParam("id") Long id){
        memberService.deleteMember(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateMember(@RequestBody MemberDto member){
        memberService.updateMember(member);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/nickname")
    public ResponseEntity<Boolean> validNickName(@RequestParam("nickName") String name){
        return new ResponseEntity(memberService.validNickName(name), HttpStatus.OK);
    }

}
