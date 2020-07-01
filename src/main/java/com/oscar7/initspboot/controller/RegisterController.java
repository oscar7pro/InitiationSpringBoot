package com.oscar7.initspboot.controller;

import org.springframework.stereotype.Controller;

@Controller
public class RegisterController {
/*

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;
    private EmailService emailService;

    @Autowired
    public RegisterController(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService, EmailService emailService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
        this.emailService = emailService;
    }

    */
/**
 * Return registration template: renvoie la page formulaire
 *
 * @param modelAndView
 * @param user
 * @return
 *//*

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    */
/**
 * Process form input data : processus de saisi de donnée
 *
 * @param modelAndView
 * @param user
 * @param bindingResult
 * @return
 *//*

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user,
                                                BindingResult bindingResult, HttpServletRequest request) {
        //lookup user in list by mail
        User userexists = userService.findUserByEmail(user.getEmail());

        System.out.println(userexists);
        if (userexists != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {//new user so we create user and send confirmation e-mail

            //disable user until check click on confirmation link in email
            user.setEnabled(false);

            //Generate random 36-character string token for confirmation link
            user.setConfirmationToken(UUID.randomUUID().toString());
            userService.saveUser(user);

            String appUrl = request.getScheme() + "://" + request.getServerName();
            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration confirmation");
            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
                    + appUrl + "/confirm?token=" + user.getConfirmationToken());
            registrationEmail.setFrom("nyona77@gmail.com");

            emailService.sendEmail(registrationEmail);

            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

    */
/**
 * Process confirmation link
 *
 * @param modelAndView
 * @param token
 * @return
 *//*

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
        User user = userService.findUserByConfirmationToken(token);

        if (user == null) {//No token in the list
            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
        } else {//Token found
            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
        }
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult,
                                                @RequestParam Map requestParams, RedirectAttributes redir) {
        modelAndView.setViewName("confirm");
       // Zxcvbn passwordCheck = new Zxcvbn();
        return  null;
    }

*/

}
