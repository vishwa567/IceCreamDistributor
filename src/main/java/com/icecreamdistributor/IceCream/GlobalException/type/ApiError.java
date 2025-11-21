package com.icecreamdistributor.IceCream.GlobalException.type;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        Integer statusCode,
        Object message,
        String path
) {
}
