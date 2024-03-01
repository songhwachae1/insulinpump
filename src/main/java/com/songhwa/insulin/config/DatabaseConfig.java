package com.songhwa.insulin.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.songhwa.insulin.mapper")
public class DatabaseConfig {

  private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

  @Autowired
  ApplicationContext applicationContext;

  @Bean
  public SqlSessionFactory sqlSession(DataSource dataSource) throws Exception {
    SqlSessionFactory result;
    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

    sessionFactory.setDataSource(dataSource);
    sessionFactory
        .setMapperLocations(applicationContext.getResources("classpath*:mapper/*Mapper.xml"));
    result = sessionFactory.getObject();
    logger.debug("sqlSessionMariaDB=" + result);
    return result;
  }

  @Bean
  public DataSourceTransactionManager transactionManager(DataSource dataSource) {
    DataSourceTransactionManager dstm = new DataSourceTransactionManager();
    dstm.setDataSource(dataSource);
    logger.debug("\n\ncall transactionManager=" + dstm + "\n\n");
    return dstm;
  }
}
