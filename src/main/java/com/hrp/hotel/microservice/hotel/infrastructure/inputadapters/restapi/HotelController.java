package com.hrp.hotel.microservice.hotel.infrastructure.inputadapters.restapi;

import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelRequest;
import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelUseCase;
import com.hrp.hotel.microservice.hotel.infrastructure.inputports.CreateHotelInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final CreateHotelInputPort hotelInputPort;

    @Autowired
    public HotelController(CreateHotelInputPort createHotelInputPort) {
        this.hotelInputPort = createHotelInputPort;
    }

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody CreateHotelRequest createHotelRequest ) throws Exception {
        hotelInputPort.createHotel(createHotelRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(HotelResponse.from("Hotel was created successfully"));
    }
}
