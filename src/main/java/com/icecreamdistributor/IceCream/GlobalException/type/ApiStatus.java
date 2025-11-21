package com.icecreamdistributor.IceCream.GlobalException.type;

import java.time.LocalDateTime;

public record ApiStatus(
        LocalDateTime timestamp,
        String status
) {
}
