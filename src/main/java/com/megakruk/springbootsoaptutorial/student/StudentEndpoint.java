package com.megakruk.springbootsoaptutorial.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {

    @Autowired
    private StudentService studentService;

    @PayloadRoot(namespace = "http://megakruk.com/soap-tutorial", localPart = "getStudent")
    @ResponsePayload
    public GetResponse getStudentById(@RequestPayload GetStudent getStudent) throws Throwable {
        Student studentById = studentService.getStudentById(getStudent.getId());
        GetResponse getResponse = new GetResponse();
        getResponse.setStudent(studentById);
        return getResponse;
    }
}
