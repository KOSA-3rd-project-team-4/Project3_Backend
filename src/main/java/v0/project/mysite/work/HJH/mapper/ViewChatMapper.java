package v0.project.mysite.work.HJH.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import v0.project.mysite.work.HJH.model.ViewAnnouncement;
import v0.project.mysite.work.HJH.model.ViewChat;

import java.util.List;

@Mapper
@Qualifier("viewChatMapper")
public interface ViewChatMapper {
    List<ViewChat> selectById(int id);

    void updateUserHired(int contract_chat_id, int hire);
}
