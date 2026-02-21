package com.carbon.rtrb.service;


import com.carbon.rtrb.model.OffsetRequest;
import com.carbon.rtrb.repository.OffsetRequestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OffsetRequestService {

    private final OffsetRequestRepository offsetRequestRepository;

    public OffsetRequestService(OffsetRequestRepository offsetRequestRepository) {
        this.offsetRequestRepository = offsetRequestRepository;
    }

    public OffsetRequest createRequest(OffsetRequest request) {
        request.setCreatedAt(LocalDateTime.now());
        request.setStatus("open");
        return offsetRequestRepository.save(request);
    }

    public List<OffsetRequest> getAllOpenRequests() {
        return offsetRequestRepository.findAll();
    }
}
