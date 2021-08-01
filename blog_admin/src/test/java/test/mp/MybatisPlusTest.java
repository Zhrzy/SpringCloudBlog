package test.mp;

import com.zy.blog.admin.mapper.SystemDictDataMapper;
import com.zy.blog.entity.Dict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author: Zy_Zhr
 * @description:
 * @date: 2021/7/31 23:53
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MybatisPlusTest.class})
public class MybatisPlusTest {

    @Resource
    private SystemDictDataMapper systemDictDataMapper;


   @Test
    public void testInsert(){
        //测试插入
        Dict dict =new Dict();
        dict.setOid(2);
        dict.setDictTypeUid("uuid");
        dict.setUid("1");
       systemDictDataMapper.selectById(1);
    }

}
