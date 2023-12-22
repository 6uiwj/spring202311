package org.choongang.restcontrollers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.choongang.commons.BadRequestException;
import org.choongang.commons.JSONData;
import org.choongang.entities.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class ApiMemberController {
    //포스트 맵핑의 테스트는 양식과 js 작업을 해줘야 하는데 이게 번거로우므로 ARC 툴을 이용해서 테스트하자.
    //요청데이터를 보낼 때 json 형태의 인코딩 방식을 인식하도록 알려주는 애너테이션
    @PostMapping
    public ResponseEntity<JSONData> join(@Valid @RequestBody RequestJoin form, Errors errors) {
        //에러발생 여부 체크/ 현재 발생한 에러 정보 출력, 에러가 여러개 있을 수있으므로 list로 받는다.
        if (errors.hasErrors()) {
            //fielderror 객체가 넘어올 것 ,fielderror에서  defaultmessage 추출
            List<String> messages = errors.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            //에러 메시지를 여기에 교체해서 출력
            log.info("에러 : {} ", messages.toString());
            //에러가 발생하면 에러메시지를 ,로 찍어서 출력
            //출력되는게 아니라 던져져서 하단의 errorHandler로 보내짐
            String message = messages.stream().collect(Collectors.joining(","));
            //throw new RuntimeException(message);
            throw new BadRequestException(message);
        }

        // log.info(form.toString());
        //응답 코드- 201, Body 없음
        //        return "OK";
        /*
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("CUSTOM_HEADER", "value1")
                .build();


         */
        //응답코드
        HttpStatus status = HttpStatus.CREATED;
        JSONData<Object> data = new JSONData<>();
        data.setStatus(status); //바디는 없다!!! 응답코드만
        return ResponseEntity.status(HttpStatus.CREATED).body(data);  //성공이든 실패이든 Json 데이터 형태의 동일한 형식 출력?
    }

        @GetMapping
        public Member info () {
        //바디 쪽에 출력될 데이터
            Member member = Member.builder()
                    .userNo(1L)
                    .userPw("12345678")
                    .userId("user01")
                    .userNm("사용자01")
                    .email("user01@test.org")
                    .regDt(LocalDateTime.now())
                    .modDt(LocalDateTime.now())
                    .build();

            //JSONData<Member> data = new JSONData<>();
            //data.setData(member);
            //return data;
            return member;

        }

        @GetMapping("/list")
        public List<Member> list () {
            List<Member> members = IntStream.rangeClosed(1, 10)
                    .mapToObj(i -> Member.builder()
                            .userNo(Long.valueOf(i))
                            .userId("user" + i)
                            .userPw("12345678")
                            .userNm("사용자" + i + "@test.org")
                            .regDt(LocalDateTime.now())
                            .modDt(LocalDateTime.now())
                            .build()
                    ).toList();

            return members;
        }

        @GetMapping("/message")
        public String message () {
            return "안녕하세요!";
        }

        @GetMapping("/process")
        public void process () {
            System.out.println("처리....");

        }
        //예외처리 - 예외를 문자로 던짐...?
    /*
        @ExceptionHandler(Exception.class)
        public ResponseEntity errorHandler(Exception e) {
            //응답코드 변경, 바디데이터도 설정?
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            //이렇게 써도 된다.
            return ResponseEntity.badRequest().body(e.getMessage());
        }

     */
    }

