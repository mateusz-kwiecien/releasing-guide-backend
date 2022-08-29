package pl.mkwiecien.releasingguide.domain.util;

import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TimeServiceImpl implements TimeService {

    @Override
    public Instant now() {
        return Instant.now();
    }
}
