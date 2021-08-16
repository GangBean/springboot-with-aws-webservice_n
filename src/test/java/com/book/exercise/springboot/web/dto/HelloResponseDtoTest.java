package com.book.exercise.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_property_test(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName())
                .isEqualTo( name ); // #1, #2
        assertThat(dto.getAmount())
                .isEqualTo(amount);
    }
}

/**
 * #1
 * assertj의 검증 메소드
 * 검증사고싶은대상 인자로 전달
 *
 * #2
 * assertThat에 있는 값과 isEqualTo 값 비교
 */
