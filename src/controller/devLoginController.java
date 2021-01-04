package controller;

import com.app.pojo.DevUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.DevService;
import util.EmptyUtils;

import javax.annotation.Resource;
import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dev")
public class devLoginController {

    @Resource
    private DevService devService;

    @RequestMapping("/main")
    public String main(HttpServletRequest request) throws NoPermissionException {DevUser devUserSession= (DevUser) request.getSession().getAttribute("devUserSession");

        if(devUserSession == null)
        {
            //全局异常处理
            throw  new NoPermissionException();
        }
      return "developer/main";
    }

    @RequestMapping(value = "/login")
    public String devlogin()
    {
        return "devlogin";
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dologin(HttpServletRequest request, @RequestParam(required = true) String devCode, @RequestParam(required = true) String devPassword ) {
        //进行用户名判空
        if (EmptyUtils.isNotEmpty(devCode) && EmptyUtils.isNotEmpty(devPassword)) {
            DevUser devUser = devService.devdoLogin(devCode, devPassword);
            if (EmptyUtils.isNotEmpty(devUser)) {
                request.getSession().setAttribute("devUserSession", devUser);
                return "redirect:/dev/main";
            } else {
                request.setAttribute("error", "用户名或密码错误");
            }

        } else {
            request.setAttribute("error", "用户名或密码不可以为空");

        }
        return "devlogin";
    }
}
