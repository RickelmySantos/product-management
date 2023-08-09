package com.management.product.dto;

import com.management.product.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
