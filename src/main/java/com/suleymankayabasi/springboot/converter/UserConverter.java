package com.suleymankayabasi.springboot.converter;

import com.suleymankayabasi.springboot.dto.UserDto;
import com.suleymankayabasi.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(target="id",source="id")
    UserDto convertUserToUserDto(User user);

    @Mapping(source="id",target="id")
    User convertUserDtoToUser(UserDto userDto);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "lastName",source = "lastName")
    @Mapping(target = "email",source = "email")
    @Mapping(target = "phoneNumber",source = "phoneNumber")
    @Mapping(target = "userName",source = "userName")
    List<UserDto> convertAllUserListToUserDtoList(List<User> userList);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "userName",source = "userName")
    List<User> convertAllUserDtoListToUserList(List<UserDto> userDtoList);

}
