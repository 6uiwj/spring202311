package configs;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("mapper")   //추가하면 알아서 스캔?
@EnableTransactionManagement  //트랜잭션 수동관리 (프록시 형태로  설정이 추가됨)
public class DbConfig {

    //설정파일을 가져와 username에 주입한다.
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        /*데이터소스 객체 만들기*/
        DataSource ds = new DataSource();
        /*연결 설정*/
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        //직업 id/pw를 넣지않고 변수로 대체하기(설정 파일에서 값 불러옴)
        ds.setUsername(username);
        ds.setPassword(password);

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
