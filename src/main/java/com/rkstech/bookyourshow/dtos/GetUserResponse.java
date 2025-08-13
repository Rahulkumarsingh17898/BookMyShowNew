package com.rkstech.bookyourshow.dtos;

import com.rkstech.bookyourshow.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserResponse {
    private Long id;
    private String user;
    private String email;

    public static GetUserResponse fromUser(User user) {
        return new GetUserResponse(user.getId(),user.getName(),user.getEmail());
    }
}
