package com.heju.comm.controller;

import com.heju.comm.controller.dto.AccessTokenDTO;
import com.heju.comm.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state ) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("d83fde395dad95e997ea");
        accessTokenDTO.setClient_secret("1e5df013208a7a72b6958785dd5ad156edcfbc91");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }

}
