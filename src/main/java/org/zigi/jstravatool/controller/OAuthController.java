package org.zigi.jstravatool.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String authorize(@RequestParam("redirectUri") String redirectUri, RedirectAttributes redirectAttributes) {
        LOG.info("redirectUri: " + redirectUri);
        redirectAttributes.addAttribute("redirect_uri", redirectUri);

        LOG.info("client ID: " + applicationConfiguration.getClientId());
        redirectAttributes.addAttribute("client_id", applicationConfiguration.getClientId());

        redirectAttributes.addAttribute("response_type", "code");
        redirectAttributes.addAttribute("approval_prompt", "force");
        redirectAttributes.addAttribute("scope", "read,read_all,profile:read_all,activity:read_all");
        return "redirect:https://www.strava.com/oauth/authorize";
    }

    @GetMapping("/token")
    public String token(@RequestParam("redirectUri") String redirectUri, RedirectAttributes redirectAttributes) {
        LOG.info("redirectUri: " + redirectUri);
        redirectAttributes.addAttribute("redirect_uri", redirectUri);

        LOG.info("client ID: " + applicationConfiguration.getClientId());
        redirectAttributes.addAttribute("client_id", applicationConfiguration.getClientId());

        redirectAttributes.addAttribute("response_type", "code");
        redirectAttributes.addAttribute("approval_prompt", "force");
        redirectAttributes.addAttribute("scope", "read,read_all,profile:read_all,activity:read_all");
        return "redirect:https://www.strava.com/oauth/authorize";
    }
}
