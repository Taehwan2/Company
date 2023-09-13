package com.example.eco.rich.openAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenDataApiService {

    public String getAirQualityData() {
        String apiUrl = "https://infuser.odcloud.kr/oas/docs?namespace=3074462/v1";

        // RestTemplate을 사용하여 API 요청을 보냄
        ResponseEntity<String> response = new RestTemplate().getForEntity(apiUrl,String.class);

        // API 응답을 문자열로 받음
        String apiResponse = response.getBody();


        // 받은 데이터를 처리하거나 원하는 형식으로 가공함
        return apiResponse;
    }
}
