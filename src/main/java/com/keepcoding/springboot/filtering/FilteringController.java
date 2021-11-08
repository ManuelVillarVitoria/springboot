package com.keepcoding.springboot.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @GetMapping(value = "/filter")
    public UserFilteredDto getUserFiltered() {
        return new UserFilteredDto(1, "user1", "1234" );
    }
}
