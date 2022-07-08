package com.zy.blog.serach.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

/**
 * @description:
 * @author: 小章鱼
 * @date: 2022/6/19 20:22
 **/
@Configuration@RefreshScope

public class RestClientConfig /*extends AbstractElasticsearchConfiguration*/ {

        @Value("${blogconfig.esurl}")
        private String eshost;
        /*@Override
        public RestHighLevelClient elasticsearchClient() {
            return RestClients.create(ClientConfiguration.builder().connectedTo("106.14.136.83:9200").build()).rest();
        }*/

        // no special bean creation needed
        @Bean
        RestHighLevelClient client() {
            ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                    .connectedTo(eshost)//elasticsearch地址
                    .build();
            return RestClients.create(clientConfiguration).rest();
        }
}