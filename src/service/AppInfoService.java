package service;

import com.app.pojo.AppInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AppInfoService {
    List<AppInfo> findAppinfoList();
}
