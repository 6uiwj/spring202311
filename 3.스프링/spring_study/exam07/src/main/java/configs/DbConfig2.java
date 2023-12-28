package configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
public class DbConfig2 {

    @Profile("dev")
    @Configuration
    @MapperScan("mapper")
    @EnableTransactionManagement
    static class DbDevConfig {
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("dev profile!");
            /*데이터소스 객체 만들기*/
            DataSource ds = new DataSource();
            /*연결 설정*/
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("SPRING6");
            ds.setPassword("_aA123456");

            /*커넥션 풀 설정 - 테스트니까 2개만 !!*/
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            //유효객체 상태일 때에는 연결 되어있는지 체크?
            ds.setTestWhileIdle(true);
            //ds.setMinEvictableIdleTimeMillis() : 연결이 되어있더라도 60초가 지나면 새로 만들게
            //ds.setTimeBetweenEvictionRunsMillis(); 엄..음..

            return ds;
        }

        //트랜잭션 관리
        @Bean
        public PlatformTransactionManager transactionManager() {
            //DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource());
            //참조 변수는 반환값밖에 쓰이지 않기 때문에 바로 리턴으로 해주자.
            return new DataSourceTransactionManager(dataSource());
        }

        //데이터 소스 통합
        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception{
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource());
            //예외 발생하므로 전가시키자.
            return sessionFactoryBean.getObject();
        }

    }

    @Profile("prod")
    @Configuration
    @MapperScan("mapper")
    @EnableTransactionManagement
    static class DbProdConfig {
        @Bean(destroyMethod = "close")
        public DataSource dataSource() {
            System.out.println("prod profile!");

            /*데이터소스 객체 만들기*/
            DataSource ds = new DataSource();
            /*연결 설정*/
            ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            ds.setUsername("SPRING6");
            ds.setPassword("_aA123456");

            /*커넥션 풀 설정 - 테스트니까 2개만 !!*/
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            //유효객체 상태일 때에는 연결 되어있는지 체크?
            ds.setTestWhileIdle(true);
            //ds.setMinEvictableIdleTimeMillis() : 연결이 되어있더라도 60초가 지나면 새로 만들게
            //ds.setTimeBetweenEvictionRunsMillis(); 엄..음..

            return ds;
        }

        //트랜잭션 관리
        @Bean
        public PlatformTransactionManager transactionManager() {
            //DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource());
            //참조 변수는 반환값밖에 쓰이지 않기 때문에 바로 리턴으로 해주자.
            return new DataSourceTransactionManager(dataSource());
        }

        //데이터 소스 통합
        @Bean
        public SqlSessionFactory sqlSessionFactory() throws Exception{
            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource());
            //예외 발생하므로 전가시키자.
            return sessionFactoryBean.getObject();
        }

    }
}
