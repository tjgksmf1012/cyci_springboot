package kr.soft.shopping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web에 대한 설정을 모아두는 공간
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //모든 mapping 명
                .allowedOrigins("http://localhost:5173") //Client접속되는 도메인 여러개 사용 가능
                .allowedMethods("GET", "POST")  //접근 방식
                .allowedHeaders("*") //Header에다가 어떤 기능만 허용
                .allowCredentials(true)
                .maxAge(3000);
    }
}
