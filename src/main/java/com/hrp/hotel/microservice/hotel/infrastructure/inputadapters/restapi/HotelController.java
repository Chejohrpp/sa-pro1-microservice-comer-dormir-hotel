package com.hrp.hotel.microservice.hotel.infrastructure.inputadapters.restapi;

import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelRequest;
import com.hrp.hotel.microservice.hotel.application.createhotelusecase.CreateHotelUseCase;
import com.hrp.hotel.microservice.hotel.infrastructure.inputports.CreateHotelInputPort;
import com.hrp.hotel.microservice.room.application.createroomusecase.CreateRoomRequest;
import com.hrp.hotel.microservice.room.infraestructure.inputadapters.restapi.RoomResponse;
import com.hrp.hotel.microservice.room.infraestructure.inputports.CreateRoomInputPort;
import com.hrp.hotel.microservice.room.infraestructure.inputports.FindRoomInputPort;
import com.hrp.hotel.microservice.room.infraestructure.inputports.GetPriceInputPort;
import com.hrp.hotel.microservice.room.infraestructure.inputports.UpdateAvailableInputPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {
    private final CreateHotelInputPort hotelInputPort;
    private final CreateRoomInputPort roomInputPort;
    private final FindRoomInputPort findRoomInputPort;
    private final GetPriceInputPort getPriceInputPort;
    private final UpdateAvailableInputPort updateAvailableInputPort;

    @Autowired
    public HotelController(CreateHotelInputPort createHotelInputPort, CreateRoomInputPort roomInputPort, FindRoomInputPort findRoomInputPort, GetPriceInputPort getPriceInputPort, UpdateAvailableInputPort updateAvailableInputPort) {
        this.hotelInputPort = createHotelInputPort;
        this.roomInputPort = roomInputPort;
        this.findRoomInputPort = findRoomInputPort;
        this.getPriceInputPort = getPriceInputPort;
        this.updateAvailableInputPort = updateAvailableInputPort;
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

    @RequestMapping(method = RequestMethod.HEAD, path = "/existing-room")
    public ResponseEntity<Void> checkRoomExists(@RequestParam("hotelid") Long hotelId,
                                                @RequestParam("room-number") String roomNumber){
        if(findRoomInputPort.findByNameAndHotel(roomNumber, hotelId).isPresent()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("{idhotel}/rooms/{roomnumber}/price")
    public ResponseEntity<Double> getPriceRoom(@PathVariable Long idhotel,
                                               @PathVariable String roomnumber) throws EntityNotFoundException {
        Double roomPrice = getPriceInputPort.getPrice(roomnumber, idhotel);
        return ResponseEntity.ok(roomPrice);
    }

    @PutMapping("{idhotel}/rooms/{roomnumber}/available/{available}")
    public ResponseEntity<Boolean> updateAvailableRoom(@PathVariable Long idhotel,
                                                       @PathVariable String roomnumber,
                                                       @PathVariable Boolean available) throws EntityNotFoundException {
        Boolean isUpdate = updateAvailableInputPort.updateAvailable(idhotel, roomnumber, available);
        return ResponseEntity.ok(isUpdate);
    }



}
