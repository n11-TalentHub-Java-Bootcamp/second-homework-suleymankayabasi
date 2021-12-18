package com.suleymankayabasi.springboot.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.suleymankayabasi.springboot.converter.UserConverter;
import com.suleymankayabasi.springboot.dto.UserDto;
import com.suleymankayabasi.springboot.entity.User;
import com.suleymankayabasi.springboot.service.entityService.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    //A service that can update user information.
    @PutMapping("")
    public UserDto updateUser(@RequestBody UserDto userDto){

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        user = userEntityService.save(user);

        UserDto userDtoResult = UserConverter.INSTANCE.convertUserToUserDto(user);
        return userDtoResult;
    }

    //A service that can delete a user.
    @DeleteMapping("{userName}/{phoneNumber}")
    public void deleteUserByUserNameAndByPhoneNumber(@PathVariable String userName,@PathVariable String phoneNumber){
        User user = userEntityService.findUserByUserName(userName);
        User user1 = userEntityService.findUserByPhoneNumber(phoneNumber);

        if(user.getId() == user1.getId()){
            userEntityService.deleteById(user.getId());
        } else{
            //TODO:“XXX kullanıcı adı ile YYY telefonu bilgileri uyuşmamaktadır.”
        }
    }

    //A service that can save User.
    @PostMapping("")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto){

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        user = userEntityService.save(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    //A service that fetch the User from the user phone number.
    @GetMapping("phoneNumber/{phoneNumber}")
    public MappingJacksonValue findUserByPhoneNumber(@PathVariable String phoneNumber){
        User user = userEntityService.findUserByPhoneNumber(phoneNumber);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);

        String filterName = "UserDtoFilter";

        SimpleFilterProvider simpleFilterProvider = getUserFilterProvider(filterName);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDto);
        mappingJacksonValue.setFilters(simpleFilterProvider);

        return  mappingJacksonValue;
    }

    //A service that retrieves the User with username.
    @GetMapping("userName/{userName}")
    public MappingJacksonValue findUserByUserName(@PathVariable String userName){

        User user = userEntityService.findUserByUserName(userName);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);

        String filterName = "UserDtoFilter";

        SimpleFilterProvider simpleFilterProvider = getUserFilterProvider(filterName);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDto);
        mappingJacksonValue.setFilters(simpleFilterProvider);

        return  mappingJacksonValue;
    }

    //A service that returns all users.
    @GetMapping("")
    public MappingJacksonValue findAllUserList(){

        List<User> userList = userEntityService.findAll();
        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUserListToUserDtoList(userList);

        String filterName = "UserDtoFilter";

        SimpleFilterProvider simpleFilterProvider = getUserFilterProvider(filterName);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userDtoList);
        mappingJacksonValue.setFilters(simpleFilterProvider);

        return  mappingJacksonValue;
    }

    private SimpleFilterProvider getUserFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getUserFilter();
        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getUserFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "lastName", "email","phoneNumber","userName");
    }


}
