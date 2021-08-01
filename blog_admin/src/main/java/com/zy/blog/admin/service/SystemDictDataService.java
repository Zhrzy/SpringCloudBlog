package com.zy.blog.admin.service;

import com.zy.blog.base.ServiceBase;
import com.zy.blog.base.SuperMapper;
import com.zy.blog.entity.Dict;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


public interface SystemDictDataService  extends ServiceBase<Dict> {

    public Map<String, Map<String, Object>> selectByTypeList(List<String> typeIds);

}
