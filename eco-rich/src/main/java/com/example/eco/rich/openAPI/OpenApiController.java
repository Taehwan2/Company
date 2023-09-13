package com.example.eco.rich.openAPI;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class OpenApiController {
 private final OpenDataApiService openDataApiService;

 @GetMapping("/crime")
 @ApiOperation(value = "공공 API 사용", notes = "한국범죄 통계에 대하여 받을 수 있다.")
 public ResponseEntity getApi(){
     return new ResponseEntity(openDataApiService.getAirQualityData(), HttpStatus.ACCEPTED);
 }

}


