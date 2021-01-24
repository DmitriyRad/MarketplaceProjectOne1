package com.example1.MarketplaceProjectOne.controller;


import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.example1.MarketplaceProjectOne.domain.Message;
import com.example1.MarketplaceProjectOne.exceptions.NotFoundException;
import com.example1.MarketplaceProjectOne.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://vueproject")
@RequestMapping("message")
public class MessageController {
    private MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    // @CrossOrigin(origins = "http://vueproject")
    @GetMapping
    public List<Message> list () {
    return messageRepo.findAll();
    }


    // Получить сообщение по полученному id
    @GetMapping("{id}")
    public Message getOneMessage(@PathVariable("id") Message message) {
        return message;
    }


    //@CrossOrigin(origins = "http://vueproject")
    @PostMapping
    public Message create(@RequestBody Message message) {
        return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDb,
                                      @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageRepo.save(messageFromDb);
    }
    @DeleteMapping ("{id}")
    public void delete(@PathVariable("id") Message message){

      messageRepo.delete(message);

    }

}
