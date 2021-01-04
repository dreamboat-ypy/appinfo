package service;

import com.app.pojo.DevUser;
import org.springframework.stereotype.Service;

@Service
public interface DevService {

    DevUser devdoLogin(String devCode, String devPassword);
}
