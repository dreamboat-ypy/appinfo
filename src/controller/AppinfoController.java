package controller;

import com.app.pojo.AppInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AppInfoService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/dev")
public class AppinfoController {
    @Resource
    private AppInfoService appInfoService;
    /*查询所有app info列表*/
    @RequestMapping("/flatform/app/list")
    public String appinfoList(HttpServletRequest request)
    {
      List<AppInfo> appInfoList=appInfoService.findAppinfoList();
      request.setAttribute("appInfoList",appInfoList);
        return "developer/appinfolist";
    }
}
