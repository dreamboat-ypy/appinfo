package service;

import com.app.pojo.DevUser;
import mapper.Devmapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevServiceImpl implements DevService {
    @Resource Devmapper devmapper;
    @Override
    public DevUser devdoLogin(String devCode, String devPassword) {
        return devmapper.devdoLogin(devCode,devPassword);
    }
}
