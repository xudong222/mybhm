package com.example.demo.controller;

import com.example.demo.base.constants.CodeEnum;
import com.example.demo.base.entity.AuthConfirmReq;
import com.example.demo.base.entity.AuthConfirmResp;
import com.example.demo.base.entity.ReturnEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping(value = "/authConfirm",method = RequestMethod.POST)
     public ReturnEntity<AuthConfirmResp> authConfirm(@RequestBody AuthConfirmReq req){
        AuthConfirmResp resp = new AuthConfirmResp();
        if(!new ClassPropertyHandler<>(req).noHasNullOrEmptyPropertyValue()){
            return ReturnEntity.returnEntity(CodeEnum.REQUIRED_VERIFICATION_EROOR,"abc",resp);
        }
//        System.out.println(new ClassPropertyHandler<>(req).noHasNullOrEmptyPropertyValue());

        resp.setApplicationId("123");

        System.out.println("Thhis");
        return ReturnEntity.returnEntity(CodeEnum.SUCCESS,"abc",resp);
    }
}

