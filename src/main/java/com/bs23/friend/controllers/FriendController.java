package com.bs23.friend.controllers;

import com.bs23.friend.models.Friend;
import com.bs23.friend.repositories.FriendRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FriendController {

    @Autowired
    private FriendRepo friendRepo;

    @PostMapping
    public void saveFriend(@Valid @RequestBody Friend friend){
        friendRepo.save(friend);
    }




//    @PostMapping
//    public void saveFriend(@RequestBody Friend friend) throws ValidationException {
//        if(friend.getName() != null && friend.getEmail() != null && friend.getPhone() != null)
//            friendRepo.save(friend);
//        else
//            throw new ValidationException("not proper friend object");
//    }



//    //with custom error message class
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ValidationException.class)
//    ErrorMessage exceptionHandlerWithErrorMessage(ValidationException e){
//        return new ErrorMessage("400", e.getMessage());
//    }

    @GetMapping
    public List<Friend> findAllFriend(){
        return friendRepo.findAll();
    }

    @GetMapping("/{id}")
    public Friend findFriendById(@PathVariable Long id){
        return friendRepo.findById(id).orElse(null);
    }

    //Search
    @GetMapping("/search")
    public List<Friend> findFriendsByEmailOrPhone(@RequestParam(name = "email", required = false) String email, @RequestParam(required = false) String phone){
        return friendRepo.findFriendByEmailOrPhone(email, phone);
    }


    @DeleteMapping("/{id}")
    public void deleteFriendById(@PathVariable Long id){
        friendRepo.deleteById(id);
    }

    //update
    @PutMapping
    public ResponseEntity updateFriend(@RequestBody Friend friend){
        if(friendRepo.findById(friend.getId()).isPresent()){
            return new ResponseEntity(friendRepo.save(friend), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);
        }

    }

}
