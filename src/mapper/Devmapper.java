package mapper;

import com.app.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface Devmapper {
    DevUser devdoLogin(@Param("devCode") String devCode,@Param("devPassword") String devPassword);
}
