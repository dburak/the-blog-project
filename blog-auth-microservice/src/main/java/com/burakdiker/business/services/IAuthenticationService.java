package com.burakdiker.business.services;

import com.burakdiker.business.dto.UserDto;

public interface IAuthenticationService {

    String loginReturnJwt(UserDto userDto);
}
