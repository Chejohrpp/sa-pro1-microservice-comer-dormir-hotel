package com.hrp.hotel.microservice.hotel.infrastructure.inputadapters.restapi;

import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelRequest;
import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelUseCase;
import com.hrp.hotel.microservice.hotel.infrastructure.inputports.CreateHotelInputPort;
import com.hrp.hotel.microservice.room.application.createroomusecase.CreateRoomRequest;
import com.hrp.hotel.microservice.room.infraestructure.inputadapters.restapi.RoomResponse;
import com.hrp.hotel.microservice.room.infraestructure.inputports.CreateRoomInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {
    private final CreateHotelInputPort hotelInputPort;
    private final CreateRoomInputPort roomInputPort;

    @Autowired
    public HotelController(CreateHotelInputPort createHotelInputPort, CreateRoomInputPort roomInputPort) {
        this.hotelInputPort = createHotelInputPort;
        this.roomInputPort = roomInputPort;
    }

    @PostMapping
    public ResponseEntity<HotelResponse> createHotel(@RequestBody CreateHotelRequest createHotelRequest ) throws Exception {
        hotelInputPort.createHotel(createHotelRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(HotelResponse.from("Hotel was created successfully"));
    }

    @PostMapping("{idhotel}/rooms/create")
    public ResponseEntity<RoomResponse> createRoom(@PathVariable("idhotel") Long idhotel,
                                                   @RequestBody CreateRoomRequest createRoomRequest ) throws Exception {
        roomInputPort.createRoom(idhotel, createRoomRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(RoomResponse.from("Room was created successfully"));
    }
}
