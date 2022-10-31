package org.zigi.jstravatool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.zigi.jstravatool.config.ApplicationConfiguration;

@Controller
@RequestMapping("/oauth2")
public class OAuthController {

    private static final Logger LOG = LogManager.getLogger(OAuthController.class);
    private final ApplicationConfiguration applicationConfiguration;

    public OAuthController(ApplicationConfiguration applicationConfiguration) {
        this.applicationConfiguration = applicationConfiguration;
    }

    @GetMapping("/authorize")
    public ModelAndView authorize(@RequestParam("redirectUri") String redirectUri, ModelMap model) {
        LOG.info("redirectUri: " + redirectUri);
        model.addAttribute("redirect_uri", redirectUri);

        LOG.info("client ID: " + applicationConfiguration.getClientId());
        model.addAttribute("client_id", applicationConfiguration.getClientId());

        model.addAttribute("response_type", "code");
        model.addAttribute("approval_prompt", "force");
        model.addAttribute("scope", "read,read_all,profile:read_all,activity:read_all");
        return new ModelAndView("forward:https://www.strava.com/oauth/authorize", model);
    }
}
