package com.zy.blog.oauth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/6/22 12:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class ResultMsg {
    private String code;

    private String message;

    private Object data;
}