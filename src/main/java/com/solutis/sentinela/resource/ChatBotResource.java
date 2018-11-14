package com.solutis.sentinela.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.Context;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@CrossOrigin
@RestController
public class ChatBotResource {

    private final String USER = "3cc4463b-f49d-481a-8d24-21a35439c7a9";
    private final String PASSWORD = "n270mhfPm3Cg";
    private final String WORKSPACE_ID = "fe9c0e40-6a82-4dd1-8868-845cc11f1018";

    private Assistant service;
    private Context context;
    private MessageOptions options;

    public ChatBotResource() {
        service = new Assistant("2018-11-10");
        service.setUsernameAndPassword(USER, PASSWORD);
    }

    @GetMapping("/chatbot")
    public ResponseEntity<?> buscaPrimeiraMensagem() {

        options = new MessageOptions.Builder(WORKSPACE_ID).context(null).build();
        MessageResponse response = service.message(options).execute();

        context = response.getContext();
        return ResponseEntity.ok().body(response.getOutput().getGeneric());
    }

    @PostMapping("/chatbot")
    public ResponseEntity<?> enviar(@RequestBody String message) {

        options = new MessageOptions.Builder(WORKSPACE_ID).context(context).build();
        MessageResponse response = service.message(options).execute();

        options = new MessageOptions.Builder(WORKSPACE_ID)
                .input(new InputData.Builder(message)
                        .build()).context(context)
                .build();

        response = service.message(options).execute();
        context = response.getContext();

        return ResponseEntity.ok().body(response.getOutput().getGeneric());
    }

}
