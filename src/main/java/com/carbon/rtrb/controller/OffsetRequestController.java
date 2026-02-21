package com.carbon.rtrb.controller;

import com.carbon.rtrb.dto.OffsetRequestDTO;
import com.carbon.rtrb.model.OffsetRequest;
import com.carbon.rtrb.service.OffsetRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offset-requests")
public class OffsetRequestController {
    private final OffsetRequestService offsetRequestService;

    public OffsetRequestController(OffsetRequestService offsetRequestService){
        this.offsetRequestService=offsetRequestService;
    }

    @PostMapping
    public ResponseEntity<OffsetRequest>createRequest(@RequestBody OffsetRequestDTO dto) {
        OffsetRequest request = new OffsetRequest();
        request.setCompanyName(dto.getCompanyName());;
        request.setTonsNeeded(dto.getTonsNeeded());
        request.setMaxPricePerTon(dto.getMaxPricePerTon());
        request.setTypePreference(dto.getTypePreference());
        request.setDeadline(dto.getDeadline());

        OffsetRequest saved = offsetRequestService.createRequest(request);
        return ResponseEntity.ok(saved);
    }
    @GetMapping
    public ResponseEntity<List<OffsetRequest>>getALl(){
        return ResponseEntity.ok(offsetRequestService.getAllOpenRequests());
    }
}
