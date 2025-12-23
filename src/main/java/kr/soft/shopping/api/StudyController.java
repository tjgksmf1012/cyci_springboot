package kr.soft.shopping.api;

import jakarta.servlet.http.HttpServletRequest;
import kr.soft.shopping.dto.CalcDTO;
import kr.soft.shopping.dto.DataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/test")
    public void test() {
        logger.info("TEST ACTION");
    }

    @GetMapping("/test1")
    public String test1() {
        logger.info("TEST ACTION");

        return "Hello World";
    }

    //데이터 건내기 (input)
    @GetMapping("/data1")
    public void data1(HttpServletRequest request) {
        String data = request.getParameter("text");
        logger.info("data: {}", data);
    }

    @GetMapping("/data2")
    public void data2(DataDTO dto) {
        logger.info("data: {}", dto.toString());
    }

    @GetMapping("/data3")
    public void data3(CalcDTO dto) {
        logger.info("data: {}", dto.getNum1() + dto.getNum2());
        logger.info("data: {}", dto.getNum1() - dto.getNum2());
    }

    @PostMapping("/post1")
    public DataDTO post1(@RequestBody DataDTO dto) {
        logger.info("data: {}", dto.toString());
        return dto;
    }

    @GetMapping("/res1")
    public void res1(DataDTO dto) {
        logger.info("data: {}", dto.toString());
    }

}
