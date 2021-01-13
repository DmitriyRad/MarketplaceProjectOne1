package com.example1.MarketplaceProjectOne.controller;


import com.example1.MarketplaceProjectOne.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    private long counter = 4;
private List<Map<String, String>> messagesList = new ArrayList<>() {{
    add(new HashMap<String, String>() {{put("id", "1"); put("text", "First message");}});
    add(new HashMap<String, String>() {{put("id", "2"); put("text", "Second message");}});
    add(new HashMap<String, String>() {{put("id", "3"); put("text", "Third message");}});
}
};

    @GetMapping
    public List<Map<String, String>> list () {
    return messagesList;
    }
    // Получить сообщение по полученному id
    @GetMapping("{id}")
    public Map<String, String> getOneMessage(@PathVariable String id) {
                return messagesList.stream().filter(messagesList -> messagesList.get("id").equals(id)).findFirst().orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> message) {
        message.put("id", String.valueOf(counter++));
        messagesList.add(message);
        return message;
    }

    @PutMapping("{id}")
    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
        Map<String, String> messageFromDB = getOneMessage(id);
        messageFromDB.putAll(message);
        messageFromDB.put("id", id);
        return messageFromDB;
    }
    @DeleteMapping ("{id}")
    public void delete(@PathVariable String id){
        Map<String, String> message = getOneMessage(id);
        messagesList.remove(message);

    }

}